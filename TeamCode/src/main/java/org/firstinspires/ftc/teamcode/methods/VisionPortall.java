package org.firstinspires.ftc.teamcode.methods;




import android.util.Size;

import org.firstinspires.ftc.robotcore.external.hardware.camera.BuiltinCameraDirection;
import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;

import org.firstinspires.ftc.robotcore.external.tfod.Recognition;
import org.firstinspires.ftc.vision.VisionPortal;

import org.firstinspires.ftc.vision.VisionPortal.Builder;
import org.firstinspires.ftc.vision.apriltag.AprilTagProcessor;
import org.firstinspires.ftc.vision.tfod.TfodProcessor;

import java.util.List;


/// Todo: there will be code that combines opencv april tags and tensorflow
public class VisionPortall extends Methods {
    public double x;
    public double y;
    private WebcamName webcam1;
    private static final String TFOD_MODEL_ASSET1 = "CenterStageobh.tflite";
    private static final String TFOD_MODEL_ASSET2 = "CenterStageBlue.tflite";
    private static final String[] LABELS = {
            "red allience",
            "blue allience"
    };
    private static final boolean USE_WEBCAM = true;  // true for webcam, false for phone camera

    /**
     * The variable to store our instance of the AprilTag processor.
     */
    public AprilTagProcessor aprilTag;

    /**
     * The variable to store our instance of the TensorFlow Object Detection processor.
     */
    public TfodProcessor tfod, tfod1;

    /**
     * The variable to store our instance of the vision portal.
     */

    public VisionPortal visionPortal;

    public void initVisionPortal() {
        List<Recognition> currentRecognitions = tfod.getRecognitions();
        for (Recognition recognition : currentRecognitions) {
            double x = (recognition.getLeft() + recognition.getRight()) / 2;
            double y = (recognition.getTop() + recognition.getBottom()) / 2;

            // -----------------------------------------------------------------------------------------
            // AprilTag Configuration
            // -----------------------------------------------------------------------------------------
            aprilTag = new AprilTagProcessor.Builder()
                    .setLensIntrinsics(578.272, 578.272, 402.145, 221.506)
                    .build();

            // -----------------------------------------------------------------------------------------
            // TFOD Configuration
            // -----------------------------------------------------------------------------------------

            tfod = new TfodProcessor.Builder()
                    .setModelAssetName(TFOD_MODEL_ASSET1)
                    .setModelLabels(LABELS)
                    .setIsModelTensorFlow2(true)
                    .build();
            // tfod.setMinResultConfidence(0.85f);
          /* tfod1 = new TfodProcessor.Builder()
                   .setModelAssetName(TFOD_MODEL_ASSET2)
                   .setModelLabels(LABELS)
                   .build();
           tfod1.setMinResultConfidence(0.85f);*/
            // -----------------------------------------------------------------------------------------
            // Camera Configuration
            // -----------------------------------------------------------------------------------------

            if (USE_WEBCAM) {
                visionPortal = new VisionPortal.Builder()
                        .setCamera(webcam1)
                        .setStreamFormat(VisionPortal.StreamFormat.YUY2)
                        .addProcessors(aprilTag,tfod)
                        .setCameraResolution(new Size(640, 480))
                        .enableLiveView(true)
                        .build();
            } else {
                visionPortal = new VisionPortal.Builder()
                        .setCamera(BuiltinCameraDirection.BACK)
                        .addProcessors(aprilTag,tfod, tfod1)
                        .build();
            }




            // end method initAprilTag()
        }
    }
    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

}