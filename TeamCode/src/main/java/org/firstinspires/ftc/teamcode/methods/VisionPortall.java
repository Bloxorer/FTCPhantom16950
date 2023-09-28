package org.firstinspires.ftc.teamcode.methods;


import android.util.Size;

import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.AxesOrder;
import org.firstinspires.ftc.robotcore.external.navigation.AxesReference;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.robotcore.external.navigation.Orientation;
import org.firstinspires.ftc.vision.VisionPortal;
import org.firstinspires.ftc.vision.apriltag.AprilTagDetection;
import org.firstinspires.ftc.vision.apriltag.AprilTagGameDatabase;
import org.firstinspires.ftc.vision.apriltag.AprilTagLibrary;
import org.firstinspires.ftc.vision.apriltag.AprilTagMetadata;
import org.firstinspires.ftc.vision.apriltag.AprilTagProcessor;
import org.firstinspires.ftc.vision.tfod.TfodProcessor;

import java.util.ArrayList;

// Todo: there will be code that combines opencv april tags and tensorflow
public class VisionPortall extends Methods {

    Methods methods = new Methods();
    public AprilTagProcessor myAprilTagProcessor;
    public AprilTagProcessor.Builder myAprilTagProcessorBuilder;
    public void AprilTag() {



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

        // Enable or disable the AperilTag processor.
        VisionPortal myVisionPortal = null;
        myVisionPortal.setProcessorEnabled(myAprilTagProcessor, true);





        myVisionPortal.setProcessorEnabled(myAprilTagProcessor, true);

        // Create a TFOD Processor by calling build()
        myTfodProcessor = myTfodProcessorBuilder.build();


        AprilTagDetection myAprilTagDetection = null;
        int myAprilTagIdCode = myAprilTagDetection.id;

        ArrayList<AprilTagDetection> myAprilTagDetections;  // list of all detections
        myAprilTagDetection = null;


// Get a list of AprilTag detections.
        myAprilTagDetections = myAprilTagProcessor.getDetections();

// Cycle through through the list and process each AprilTag.
        String myAprilTagName;
        myAprilTagName = myAprilTagDetection.metadata.name;


        double myTagPoseX = myAprilTagDetection.ftcPose.x;
        double myTagPoseY = myAprilTagDetection.ftcPose.y;
        double myTagPoseZ = myAprilTagDetection.ftcPose.z;
        double myTagPosePitch = myAprilTagDetection.ftcPose.pitch;
        double myTagPoseRoll = myAprilTagDetection.ftcPose.roll;
        double myTagPoseYaw = myAprilTagDetection.ftcPose.yaw;


        double myTagPoseRange = myAprilTagDetection.ftcPose.range;
        double myTagPoseBearing = myAprilTagDetection.ftcPose.bearing;
        double myTagPoseElevation = myAprilTagDetection.ftcPose.elevation;


// Create the AprilTag processor and assign it to a variable.
        myAprilTagProcessor = AprilTagProcessor.easyCreateWithDefaults();


        AprilTagMetadata myAprilTagMetadata = null;
        AprilTagLibrary.Builder myAprilTagLibraryBuilder;
        AprilTagLibrary myAprilTagLibrary;

// Create a new AprilTagLibrary.Builder object and assigns it to a variable.
        myAprilTagLibraryBuilder = new AprilTagLibrary.Builder();

// Add all the tags from the given AprilTagLibrary to the AprilTagLibrary.Builder.
// Get the AprilTagLibrary for the current season.
        myAprilTagLibraryBuilder.addTags(AprilTagGameDatabase.getCurrentGameTagLibrary());


// Add a tag to the AprilTagLibrary.Builder.
        //myAprilTagLibraryBuilder.addTag(myAprilTagMetadata);

// Build the AprilTag library and assign it to a variable.
        //myAprilTagLibrary = myAprilTagLibraryBuilder.build();

// Create a new AprilTagProcessor.Builder object and assign it to a variable.
        //myAprilTagProcessorBuilder = new AprilTagProcessor.Builder();

// Set the tag library.
        //myAprilTagProcessorBuilder.setTagLibrary(myAprilTagLibrary);

// Build the AprilTag processor and assign it to a variable.
        //myAprilTagProcessor = myAprilTagProcessorBuilder.build();


        // Temporarily stop the live view (RC preview).
        //myVisionPortal.stopLiveView();

// Start the live view (RC preview) again.
        //myVisionPortal.resumeLiveView();


        //myAprilTagProcessorBuilder.toString();

        // Enable or disable the AprilTag processor.
        //myVisionPortal.setProcessorEnabled(myAprilTagProcessor, true);

// Enable or disable the TensorFlow Object Detection processor.
        //myVisionPortal.setProcessorEnabled(myTfodProcessor, true);


        // Temporarily stop the streaming session. This can save CPU
// resources, with the ability to resume quickly when needed.
        //myVisionPortal.stopStreaming();

// Resume the streaming session if previously stopped.
        // myVisionPortal.resumeStreaming();

// Save computing resources by closing VisionPortal at any time, if no
// longer needed.
        //myVisionPortal.close();

        for (AprilTagDetection detection : myAprilTagProcessor.getDetections())  {

            Orientation rot = Orientation.getOrientation(detection.rawPose.R, AxesReference.INTRINSIC, AxesOrder.XYZ, AngleUnit.DEGREES);

            // Original source data
            double poseX = detection.rawPose.x;
            double poseY = detection.rawPose.y;
            double poseZ = detection.rawPose.z;

            double poseAX = rot.firstAngle;
            double poseAY = rot.secondAngle;
            double poseAZ = rot.thirdAngle;



        }


        if (myAprilTagDetection.metadata != null) {  // This check for non-null Metadata is not needed for reading only ID code.
            myAprilTagIdCode = myAprilTagDetection.id;

            // Now take action based on this tag's ID code, or store info for later action.


        }
    }

///




    private static org.firstinspires.ftc.vision.VisionPortal easyCreateWithDefaults(WebcamName webcamName, AprilTagProcessor myAprilTagProcessor) {
        return null;
    }

    private void setProcessorEnabled(AprilTagProcessor myAprilTagProcessor, boolean b) {

    }





}



