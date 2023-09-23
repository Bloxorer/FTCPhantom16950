package org.firstinspires.ftc.teamcode.methods;


import android.util.Size;

import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.vision.VisionPortal;
import org.firstinspires.ftc.vision.apriltag.AprilTagDetection;
import org.firstinspires.ftc.vision.apriltag.AprilTagProcessor;
import org.firstinspires.ftc.vision.tfod.TfodProcessor;

import java.util.ArrayList;

// Todo: there will be code that combines opencv april tags and tensorflow
public class VisionPortall {


   /* public static class AprilTags extends Methods {
        Methods methods = new Methods();

        private void AprilTag() {
            AprilTagProcessor.Builder myAprilTagProcessorBuilder;
            AprilTagProcessor myAprilTagProcessor;

            //Create a new AprilTag Processor Builder object.
            myAprilTagProcessorBuilder = new AprilTagProcessor.Builder();

            // The OpMode must have already created a Library.

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
            VisionPortal myVisionPortal = null;
            myVisionPortal.setProcessorEnabled(myAprilTagProcessor, true);

            // Create a VisionPortal, with the specified camera and AprilTag processor, and assign it to a variable.
            myVisionPortal = VisionPortal.easyCreateWithDefaults(hardwareMap.get(WebcamName.class, "Webcam 1"), myAprilTagProcessor);


            myVisionPortal = new VisionPortal.Builder()
                    .setCamera(hardwareMap.get(WebcamName.class, "Webcam 1"))
                    .addProcessor(myAprilTagProcessor)
                    .setCameraResolution(new Size(640, 480))
                    .setStreamFormat(VisionPortal.StreamFormat.YUY2)
                    .enableLiveView(true)
                    .setAutoStopLiveView(true)
                    .build();

            myVisionPortal.setProcessorEnabled(myAprilTagProcessor, true);

            // Create a TFOD Processor by calling build()
            myTfodProcessor = myTfodProcessorBuilder.build();



            AprilTagDetection myAprilTagDetection = null;
            int myAprilTagIdCode = myAprilTagDetection.id;

            ArrayList<AprilTagDetection> myAprilTagDetections;  // list of all detections
            myAprilTagDetection = null;
            int myAprilTagIdCode;                           // ID code of current detection, in for() loop

// Get a list of AprilTag detections.
            myAprilTagDetections = myAprilTagProcessor.getDetections();

// Cycle through through the list and process each AprilTag.
            for (myAprilTagDetection :
                 {
                 }) {

                if (myAprilTagDetection.metadata != null) {  // This check for non-null Metadata is not needed for reading only ID code.
                    myAprilTagIdCode = myAprilTagDetection.id;

                    // Now take action based on this tag's ID code, or store info for later action.

                }
            }

        }///


    }


    private static org.firstinspires.ftc.vision.VisionPortal easyCreateWithDefaults(WebcamName webcamName, AprilTagProcessor myAprilTagProcessor) {
        return null;
    }

    private void setProcessorEnabled(AprilTagProcessor myAprilTagProcessor, boolean b) {

   }*/



}



