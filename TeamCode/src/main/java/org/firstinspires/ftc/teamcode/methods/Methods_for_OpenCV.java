package org.firstinspires.ftc.teamcode.methods;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfPoint;
import org.opencv.core.Point;
import org.opencv.core.Scalar;
import org.opencv.imgproc.Imgproc;
import org.openftc.easyopencv.OpenCvPipeline;
import java.util.ArrayList;
import java.util.List;



import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

//Todo: create there all necessary for OpenCV instead of creating new instance in every Autonomous Method
public class Methods_for_OpenCV extends  LinearOpMode{
    static int valLeft;
    static int valRight;
    private static float rectHeight = 0.5f / 8f;
    private static float rectWidth = 0.5f / 8f;
    private static float rectHeight1 = 0.5f / 8f;
    private static float rectWidth1 = 0.5f / 8f;

    private static float offsetX = 0f / 8f;//changing this moves the three rects and the three circles left or right, range : (-2, 2) not inclusive
    private static float offsetY = 0f / 8f;//changing this moves the three rects and circles up or down, range: (-4, 4) not inclusive

    private static float[] leftPos = {2f / 8f + offsetX, 4f / 8f + offsetY};
    private static float[] rightPos = {3f / 8f + offsetX, 4 / 8f + offsetY};

    final int rows = 640;
    final int cols = 480;

    public static int getValLeft() {
        return valLeft;
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }

    public static void setValLeft(int valLeft) {
        Methods_for_OpenCV.valLeft = valLeft;
    }

    public static int getValRight() {
        return valRight;
    }

    public static void setValRight(int valRight) {
        Methods_for_OpenCV.valRight = valRight;
    }

    @Override
    public void runOpMode() throws InterruptedException {

    }

    public static class StageSwitchingPipeline extends OpenCvPipeline {
        Mat yCbCrChan2Mat = new Mat();
        Mat thresholdMat = new Mat();
        Mat all = new Mat();
        List<MatOfPoint> contoursList = new ArrayList<>();

        enum Stage {//color difference. greyscale
            detection,//includes outlines
            THRESHOLD,//b&w
            RAW_IMAGE,//displays raw view
        }

        private Methods_for_OpenCV.StageSwitchingPipeline.Stage stageToRenderToViewport = Methods_for_OpenCV.StageSwitchingPipeline.Stage.detection;
        private  Methods_for_OpenCV.StageSwitchingPipeline.Stage[] stages = Methods_for_OpenCV.StageSwitchingPipeline.Stage.values();

        @Override
        public void onViewportTapped() {
            /*
             * Note that this method is invoked from the UI thread
             * so whatever we do here, we must do quickly.
             */

            int currentStageNum = stageToRenderToViewport.ordinal();

            int nextStageNum = currentStageNum + 1;

            if (nextStageNum >= stages.length) {
                nextStageNum = 0;
            }

            stageToRenderToViewport = stages[nextStageNum];
        }

        @Override
        public Mat processFrame(Mat input) {
            contoursList.clear();
            /*
             * This pipeline finds the contours of yellow blobs such as the Gold Mineral
             * from the Rover Ruckus game.
             */

            Scalar blueLowHSV = new Scalar(0, 0, 0); // lower bound HSV for blue
            Scalar blueHighHSV = new Scalar(360, 100.0, 100.0);// higher bound HSV for blue
            Scalar redLowHSV = new Scalar(0,0,0);
            Scalar redHighHSV = new Scalar(0,100.0,100.0);
            Mat hsvImage = new Mat();
            Imgproc.cvtColor(input, hsvImage, Imgproc.COLOR_BGR2HSV);
            Mat colorMaskblue = new Mat();
            Mat colorMaskred = new Mat();//
            Core.inRange(hsvImage, blueLowHSV, blueHighHSV, colorMaskblue); // filter for blue
            Core.inRange(hsvImage, redLowHSV, redHighHSV, colorMaskred); // filter for red
            //Core.inRange(hsvImage, lowHSV, blueHighHSV, colorMask);
           // Core.inRange(hsvImage, lowHSV, blueHighHSV, colorMask);
            //Core.inRange(hsvImage, lowHSV, blueHighHSV, colorMask);
            Mat coloredImage = new Mat();
            Core.bitwise_and(input, input, coloredImage, colorMaskblue);
            Core.bitwise_and(coloredImage, coloredImage, coloredImage, colorMaskred);
            Imgproc.cvtColor(coloredImage, coloredImage, Imgproc.COLOR_BGR2HSV);
            Core.add(coloredImage, new Scalar(60, 100.0, 100.0), coloredImage, colorMaskblue);
            Core.add(coloredImage, new Scalar(60, 100.0,100.0), coloredImage, colorMaskred);
            Imgproc.cvtColor(coloredImage, input, Imgproc.COLOR_HSV2RGB);



            //color diff cb.
            //lower cb = more blue = skystone = white
            //higher cb = less blue = oyellow stne = grey


            Imgproc.cvtColor(input, yCbCrChan2Mat, Imgproc.COLOR_RGB2YCrCb);//converts rgb to ycrcb


            Core.extractChannel(yCbCrChan2Mat, yCbCrChan2Mat, 2);//takes cb difference and stores


            //b&w
            Imgproc.threshold(yCbCrChan2Mat, thresholdMat, 120, 255, Imgproc.THRESH_BINARY_INV);

            //outline/contour
            Imgproc.findContours(thresholdMat, contoursList, new Mat(), Imgproc.RETR_LIST, Imgproc.CHAIN_APPROX_SIMPLE);
            yCbCrChan2Mat.copyTo(all);//copies mat object
            // Imgproc.drawContours(all, contoursList, -1, new Scalar(255, 0, 0), 3, 8);//draws blue contours


            //get values from frame


            double[] pixLeft = thresholdMat.get((int) (input.rows() * leftPos[1]), (int) (input.cols() * leftPos[0]));//gets value at circle
            valLeft = (int) pixLeft[0];

            double[] pixRight = thresholdMat.get((int) (input.rows() * rightPos[1]), (int) (input.cols() * rightPos[0]));//gets value at circle
            valRight = (int) pixRight[0];

            //create three points
            Point pointLeft = new Point((int) (input.cols() * leftPos[0]), (int) (input.rows() * leftPos[1]));
            Point pointRight = new Point((int) (input.cols() * rightPos[0]), (int) (input.rows() * rightPos[1]));

            //draw circles on those points
            Imgproc.circle(all, pointLeft, 5, new Scalar(0, 0, 255), 1);//draws circle
            Imgproc.circle(all, pointRight, 5, new Scalar(0, 0, 255), 1);//draws circle

            //draw 3 rectangles
            Imgproc.rectangle(//1-3
                    all,
                    new Point(
                            input.cols() * (leftPos[0] - rectWidth1 / 2),
                            input.rows() * (leftPos[1] - rectHeight1 / 2)),
                    new Point(
                            input.cols() * (leftPos[0] + rectWidth1 / 2),
                            input.rows() * (leftPos[1] + rectHeight1 / 2)),
                    new Scalar(0, 0, 255), 3);

            Imgproc.rectangle(//5-7
                    all,
                    new Point(
                            input.cols() * (rightPos[0] - rectWidth / 2),
                            input.rows() * (rightPos[1] - rectHeight / 2)),
                    new Point(
                            input.cols() * (rightPos[0] + rectWidth / 2),
                            input.rows() * (rightPos[1] + rectHeight / 2)),
                    new Scalar(0, 0, 255), 3);

            switch (stageToRenderToViewport) {
                case THRESHOLD: {
                    return thresholdMat;
                }

                case detection: {
                    return all;
                }

                case RAW_IMAGE: {
                    return input;
                }

                default: {
                    return input;
                }
            }
        }
    }
}

