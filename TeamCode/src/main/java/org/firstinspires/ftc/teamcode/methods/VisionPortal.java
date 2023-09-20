package org.firstinspires.ftc.teamcode.methods;

import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.vision.apriltag.AprilTagGameDatabase;
import org.firstinspires.ftc.vision.apriltag.AprilTagProcessor;
import org.firstinspires.ftc.vision.tfod.TfodProcessor;

// Todo: there will be code that combines opencv april tags and tensorflow
public class VisionPortal {
    public static class  AprilTags extends Methods {
        Methods methods = new Methods();
        private void AprilTag() {
            AprilTagProcessor.Builder myAprilTagProcessorBuilder;
            AprilTagProcessor myAprilTagProcessor;

            // Create a new AprilTag Processor Builder object.
            myAprilTagProcessorBuilder = new AprilTagProcessor.Builder();

            // Optional: specify a custom Library of AprilTags.
            // myAprilTagProcessorBuilder.setTagLibrary(myAprilTagLibrary);   // The OpMode must have already created a Library.

            // Optional: set other custom features of the AprilTag Processor (4 are shown here).
            myAprilTagProcessorBuilder.setDrawTagID(true);       // Default: true, for all detections.
            myAprilTagProcessorBuilder.setDrawTagOutline(true);  // Default: true, when tag size was provided (thus eligible for pose estimation).
            myAprilTagProcessorBuilder.setDrawAxes(true);        // Default: false.
            myAprilTagProcessorBuilder.setDrawCubeProjection(true);        // Default: false.

            // Create an AprilTagProcessor by calling build()
            myAprilTagProcessor = myAprilTagProcessorBuilder.build();
            TfodProcessor myTfodProcessor;
            // Create the TensorFlow Object Detection processor and assign it to a variable.
            myTfodProcessor = TfodProcessor.easyCreateWithDefaults();

            TfodProcessor.Builder myTfodProcessorBuilder;


            // Create a new TFOD Processor Builder object.
            myTfodProcessorBuilder = new TfodProcessor.Builder();

            // Optional: set other custom features of the TFOD Processor (4 are shown here).
            myTfodProcessorBuilder.setMaxNumRecognitions(10);  // Max. number of recognitions the network will return
            myTfodProcessorBuilder.setUseObjectTracker(true);  // Whether to use the object tracker
            myTfodProcessorBuilder.setTrackerMaxOverlap((float) 0.2);  // Max. % of box overlapped by another box at recognition time
            myTfodProcessorBuilder.setTrackerMinSize(16);  // Min. size of object that the object tracker will track

            // Enable or disable the AprilTag processor.
            myVisionPortal.setProcessorEnabled(myAprilTagProcessor, true);

            // Create a VisionPortal, with the specified camera and AprilTag processor, and assign it to a variable.
            myVisionPortal = VisionPortal.easyCreateWithDefaults(hardwareMap.get(WebcamName.class, "Webcam 1"), myAprilTagProcessor);

            // Create a TFOD Processor by calling build()
            myTfodProcessor = myTfodProcessorBuilder.build();
        }//

    }

    public class TFOD{
        private void TFOD(){

        }

    }


}
