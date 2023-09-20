package org.firstinspires.ftc.teamcode.opmodes.autonom;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.teamcode.methods.Methods;
import org.firstinspires.ftc.teamcode.methods.Methods_for_OpenCV;
import org.firstinspires.ftc.teamcode.methods.Methods_move;
import org.firstinspires.ftc.teamcode.methods.VisionPortal;
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
@Autonomous(name= "CamTestNew", group="Autonomous")

//
public class NewCamTest extends Methods {
    private final ElapsedTime runtime = new ElapsedTime();
    private static int valLeft;
    private static int valRight;
    private int rows;
    private int cols;
    @Override
    public void runOpMode() throws InterruptedException {
        VisionPortal visionPortal = new VisionPortal();
        VisionPortal.AprilTags.
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

        initGyro();
        waitForStart();

        runtime.reset();
        while (opModeIsActive()) {
            telemetry.addData("Values", valLeft + "  " + valRight);
            telemetry.update();
            sleep (150);

            if (valLeft == 255) {
                drin_castom(500);
                move.vpered(800, 0.25);
                sleep(250);
                move.razvarot(540,0.25);
                move.vpered(700, 0.3);
                sleep(30000);
            } else if (valRight  == 255) {
                drin_castom(500);
                move.vpered(800, 0.25);
                move.vpered(250, 0.3);
                sleep(30000);
            } else {
                drin_castom(500);
                move.vpered(800, 0.25);
                sleep(250);
                move.razvarot(-540,0.25);
                move.vpered(700, 0.3);
                sleep(30000);
            }
        }}
            /*
            if (valLeft == 255) {
            } else if (valRight == 255) {
            } else {
            }*/





}
