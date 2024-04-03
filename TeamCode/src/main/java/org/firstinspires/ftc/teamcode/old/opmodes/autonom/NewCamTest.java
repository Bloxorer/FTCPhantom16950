package org.firstinspires.ftc.teamcode.old.opmodes.autonom;


import android.util.Size;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.hardware.camera.BuiltinCameraDirection;
import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;

import org.firstinspires.ftc.robotcore.external.tfod.Recognition;
import org.firstinspires.ftc.teamcode.old.methods.Methods;
import org.firstinspires.ftc.teamcode.old.methods.Methods_for_OpenCV;
import org.firstinspires.ftc.vision.VisionPortal;
import org.firstinspires.ftc.vision.apriltag.AprilTagProcessor;
import org.firstinspires.ftc.vision.tfod.TfodProcessor;
import org.openftc.easyopencv.OpenCvCameraFactory;
import org.openftc.easyopencv.OpenCvCameraRotation;

import java.util.List;

/**
 * Created by maryjaneb  on 11/13/2016.
 *
 * nerverest ticks
 * 60 1680
 * 40 1120
 * 20 560
 * <p>
 * monitor: 640 x 480
 *YES
 */
@Autonomous(name= "CamTestNew", group="Autonomous")

//
public class NewCamTest extends Methods {
    // Declare class members
    private static final String VUFORIA_KEY = "8a87a69a26024507ac03fedb5a601be6";

    private static final String TFOD_MODEL_ASSET1 = "CenterStageRed.tflite";
    private static final String TFOD_MODEL_ASSET2 = "CenterStageBlue.tflite";
    private static final String[] LABELS = {
            "red allience",
            "blue allience"
    };
    private static final boolean USE_WEBCAM = false;  // true for webcam, false for phone camera

    public AprilTagProcessor aprilTag;
    public TfodProcessor tfod, tfod1;
    public VisionPortal visionPortal;
    int rows = 640;
    int cols = 480;
    private final ElapsedTime runtime = new ElapsedTime();
    @Override
    public void runOpMode() throws InterruptedException {
        Methods_for_OpenCV methodsForOpenCV = new Methods_for_OpenCV();

        rows = methodsForOpenCV.getRows();
        cols = methodsForOpenCV.getCols();
        int cameraMonitorViewId = hardwareMap.appContext.getResources().getIdentifier("cameraMonitorViewId", "id", hardwareMap.appContext.getPackageName());

        phoneCam = OpenCvCameraFactory.getInstance().createWebcam(hardwareMap.get(WebcamName.class, "Webcam 1"), cameraMonitorViewId);

        phoneCam.openCameraDevice();
        phoneCam.setPipeline(new Methods_for_OpenCV.StageSwitchingPipeline());

        phoneCam.startStreaming(rows, cols, OpenCvCameraRotation.UPRIGHT);
        runtime.reset();

        waitForStart();

        while (opModeIsActive()) {
          // telemetryTfod();
            sleep (150);
           /* if (true) {
                sleep(30000);
            } else if (false) {
                sleep(30000);
            } else {
                sleep(30000);
            }*/
        }}
            /*
            if (valLeft == 255) {
            } else if (valRight == 255) {
            } else {
            }*/

    private void initVisionPortal() {

        aprilTag = new AprilTagProcessor.Builder()
                .setLensIntrinsics(578.272, 578.272, 402.145, 221.506)
                .build();

        tfod = new TfodProcessor.Builder()
                .setModelAssetName(TFOD_MODEL_ASSET1)
                .setModelLabels(LABELS)
                .build();

        if (USE_WEBCAM) {
            visionPortal = new VisionPortal.Builder()
                    .setCamera(hardwareMap.get(WebcamName.class, "Webcam 1"))
                    .setStreamFormat(VisionPortal.StreamFormat.YUY2)
                    .addProcessors(aprilTag,tfod)
                    .setCameraResolution(new Size(640, 480))
                    .enableLiveView(true)

                    .build();
        } else {
            visionPortal = new VisionPortal.Builder()
                    .setCamera(BuiltinCameraDirection.BACK)
                    .addProcessors(aprilTag,tfod)
                    .setCameraResolution(new Size(640, 480))
                    .enableLiveView(true)
                    .build();



        }
    }
    private void telemetryTfod() {

        List<Recognition> currentRecognitions = tfod.getRecognitions();
        telemetry.addData("# Objects Detected", currentRecognitions.size());

        // Step through the list of recognitions and display info for each one.
        for (Recognition recognition : currentRecognitions) {
            double x = (recognition.getLeft() + recognition.getRight()) / 2;
            double y = (recognition.getTop() + recognition.getBottom()) / 2;

            telemetry.addData("", " ");
            telemetry.addData("Image", "%s (%.0f %% Conf.)", recognition.getLabel(), recognition.getConfidence() * 100);
            telemetry.addData("- Position", "%.0f / %.0f", x, y);
            telemetry.addData("- Size", "%.0f x %.0f", recognition.getWidth(), recognition.getHeight());
            telemetry.update();
        }
    }
}
