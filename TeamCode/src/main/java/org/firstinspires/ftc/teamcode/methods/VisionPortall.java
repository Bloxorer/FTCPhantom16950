package org.firstinspires.ftc.teamcode.methods;




import android.util.Size;

import org.firstinspires.ftc.robotcore.external.hardware.camera.BuiltinCameraDirection;
import org.firstinspires.ftc.robotcore.external.hardware.camera.CameraCaptureSession;
import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;

import org.firstinspires.ftc.robotcore.external.hardware.camera.controls.ExposureControl;
import org.firstinspires.ftc.robotcore.external.tfod.Recognition;
import org.firstinspires.ftc.vision.VisionPortal;

import org.firstinspires.ftc.vision.VisionPortal.Builder;
import org.firstinspires.ftc.vision.apriltag.AprilTagProcessor;
import org.firstinspires.ftc.vision.tfod.TfodProcessor;

import java.util.List;
import java.util.concurrent.TimeUnit;


/// Todo: there will be code that combines opencv april tags and tensorflow
public class VisionPortall extends Methods {
    public double x;
    public double y;
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
    public TfodProcessor tfod;

    /**
     * The variable to store our instance of the vision portal.
     */

    public VisionPortal visionPortal;
    ExposureControl myExposureControl;
    public void initVisionPortal() {


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
                    
                    .setMaxNumRecognitions(1)
                    .setModelAssetName(TFOD_MODEL_ASSET1)
                    .setModelLabels(LABELS)
                    .build();
        CameraCaptureSession vuforia = null;

        myExposureControl = vuforia.getCamera().getControl(ExposureControl.class);
        myExposureControl.setMode(ExposureControl.Mode.Manual);
        myExposureControl.setExposure(30, TimeUnit.MILLISECONDS);
    }

    public TfodProcessor getTfod() {
        return tfod;
    }

    public void setTfod(TfodProcessor tfod) {
        this.tfod = tfod;
    }

    public AprilTagProcessor getAprilTag() {
        return aprilTag;
    }

    public void setAprilTag(AprilTagProcessor aprilTag) {
        this.aprilTag = aprilTag;
    }
}