package org.firstinspires.ftc.teamcode.methods;




import org.firstinspires.ftc.robotcore.external.hardware.camera.BuiltinCameraDirection;
import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;

import org.firstinspires.ftc.vision.VisionPortal;

import org.firstinspires.ftc.vision.apriltag.AprilTagProcessor;
import org.firstinspires.ftc.vision.tfod.TfodProcessor;



// Todo: there will be code that combines opencv april tags and tensorflow
public class VisionPortall extends Methods {
    private static final String TFOD_MODEL_ASSET = "CenterStageRed.tflite";
    private static final String[] LABELS = {
            "red allience",
    };
    private static final boolean USE_WEBCAM = false;  // true for webcam, false for phone camera

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
              .setModelAssetName(TFOD_MODEL_ASSET)
              .setModelLabels(LABELS)
              .build();
        tfod.setMinResultConfidence(0.85f);
        // -----------------------------------------------------------------------------------------
        // Camera Configuration
        // -----------------------------------------------------------------------------------------

        if (USE_WEBCAM) {
            visionPortal = new VisionPortal.Builder()
                    .setCamera(hardwareMap.get(WebcamName.class, "Webcam 1"))
                    .addProcessors(aprilTag)
                    .build();
        } else {
            visionPortal = new VisionPortal.Builder()
                    .setCamera(BuiltinCameraDirection.BACK)
                    .addProcessors(aprilTag,tfod)
                    .build();
        }



    // end method initAprilTag()
}}