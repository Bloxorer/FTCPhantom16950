package org.firstinspires.ftc.teamcode.opmodes.autonom;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.teamcode.methods.Methods;
import org.firstinspires.ftc.teamcode.methods.Methods_for_OpenCV;
import org.firstinspires.ftc.teamcode.methods.Methods_move;
import org.firstinspires.ftc.teamcode.roadrunner.drive.DriveConstants;
import org.firstinspires.ftc.teamcode.roadrunner.drive.SampleMecanumDrive;
import org.firstinspires.ftc.teamcode.roadrunner.trajectorysequence.TrajectorySequence;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfPoint;
import org.opencv.core.Point;
import org.opencv.core.Scalar;
import org.opencv.imgproc.Imgproc;
import org.openftc.easyopencv.OpenCvCameraFactory;
import org.openftc.easyopencv.OpenCvCameraRotation;
import org.openftc.easyopencv.OpenCvPipeline;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by maryjaneb  on 11/13/2016.
 *
 * nerverest ticks
 * 60 1680
 * 40 1120
 * 20 560
 *
 * monitor: 640 x 480
 *YES
 */
@Autonomous(name= "RRtest", group="Autonomous")

//
public class RRtest extends Methods {
    private final ElapsedTime runtime = new ElapsedTime();
    private static int valLeft;
    private static int valRight;
    private int rows;
    private int cols;
    @Override
    public void runOpMode() throws InterruptedException {
        Methods_move move = new Methods_move();
        Methods_for_OpenCV cameramethd = new Methods_for_OpenCV();
        valLeft = cameramethd.getValLeft();
        valRight = cameramethd.getValRight();
        rows = cameramethd.getRows();
        cols = cameramethd.getCols();
        int cameraMonitorViewId = hardwareMap.appContext.getResources().getIdentifier("cameraMonitorViewId", "id", hardwareMap.appContext.getPackageName());
        phoneCam = OpenCvCameraFactory.getInstance().createWebcam(hardwareMap.get(WebcamName.class, "Webcam 1"), cameraMonitorViewId);
        phoneCam.openCameraDevice();
        phoneCam.setPipeline(new Methods_for_OpenCV.StageSwitchingPipeline());
        phoneCam.startStreaming(rows, cols, OpenCvCameraRotation.UPRIGHT);
        leftF = hardwareMap.dcMotor.get("lf");
        leftB = hardwareMap.dcMotor.get("lr");
        rightF = hardwareMap.dcMotor.get("rf");
        rightB = hardwareMap.dcMotor.get("rr");
        pisun = hardwareMap.crservo.get("pis");
        pod = hardwareMap.dcMotor.get("pod");
        drin = hardwareMap.dcMotor.get("drin");
        big = hardwareMap.crservo.get("big");
        zaxvat = hardwareMap.crservo.get("zx");
        SampleMecanumDrive drive = new SampleMecanumDrive(hardwareMap);
        initGyro();
        waitForStart();
        TrajectorySequence untitled0 = drive.trajectorySequenceBuilder(new Pose2d(-35.76, -60.68, Math.toRadians(90.00)))
                .splineTo(new Vector2d(-35.32, 8.88), Math.toRadians(90.58))

                .build();



        runtime.reset();
        while (opModeIsActive()) {
            telemetry.addData("Values", valLeft + "  " + valRight);
            telemetry.update();
            sleep (150);

            if (valLeft == 255) {
               drive.followTrajectorySequence(untitled0);
               stop_all();
                sleep(30000);
            } else if (valRight  == 255) {
                drive.followTrajectorySequence(untitled0);
                stop_all();
                sleep(30000);
            } else {
                drive.followTrajectorySequence(untitled0);
                stop_all();
                sleep(30000);
            }
        }}
            /*
            if (valLeft == 255) {
            } else if (valRight == 255) {
            } else {
            }*/





}