package org.firstinspires.ftc.teamcode.opmodes.autonom.centerstage;



import org.firstinspires.ftc.robotcore.external.android.util.Size;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;


import org.firstinspires.ftc.robotcore.external.hardware.camera.BuiltinCameraDirection;
import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.robotcore.external.tfod.Recognition;
import org.firstinspires.ftc.teamcode.methods.Methods;
import org.firstinspires.ftc.teamcode.methods.Methods_for_OpenCV;

import org.firstinspires.ftc.teamcode.methods.VisionPortall;
import org.firstinspires.ftc.vision.VisionPortal;
import org.firstinspires.ftc.vision.apriltag.AprilTagProcessor;
import org.firstinspires.ftc.vision.tfod.TfodProcessor;
import org.openftc.easyopencv.OpenCvCameraFactory;
import org.openftc.easyopencv.OpenCvCameraRotation;
import org.openftc.easyopencv.OpenCvInternalCamera;

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
@Autonomous(name= "a_Sin_zad", group="Autonomous")

//
public class a_Sin_zad extends Methods {

    private final ElapsedTime runtime = new ElapsedTime();
    private static int valLeft = -1;
    private static int valRight = -1;
    private static float rectHeight = 0.5f / 8f;
    private static float rectWidth = 0.5f / 8f;
    private static float rectHeight1 = 0.5f / 8f;
    private static float rectWidth1 = 0.5f / 8f;

    private static float offsetX = 0f / 8f;//changing this moves the three rects and the three circles left or right, range : (-2, 2) not inclusive
    private static float offsetY = 0f / 8f;//changing this moves the three rects and circles up or down, range: (-4, 4) not inclusive

    private static float[] leftPos = {2.0f / 8f + offsetX, 4f / 8f + offsetY};
    private static float[] rightPos = {2.8f / 8f + offsetX, 4 / 8f + offsetY};
    public void runOpMode() throws InterruptedException {
        VisionPortall visionPortall = new VisionPortall();

        webcam1 = hardwareMap.get(WebcamName.class, "Webcam 1");
        leftF = hardwareMap.dcMotor.get("lf");
        leftB = hardwareMap.dcMotor.get("lr");
        rightF = hardwareMap.dcMotor.get("rf");
        rightB = hardwareMap.dcMotor.get("rr");
        bros = hardwareMap.crservo.get("bs");
        zaxvatLeft = hardwareMap.crservo.get("zxl");
        zaxvatRight = hardwareMap.crservo.get("zxr");
        actu = hardwareMap.dcMotor.get("ac");
        pod = hardwareMap.dcMotor.get("pod");
        Methods_for_OpenCV methodsForOpenCV = new Methods_for_OpenCV();

       int rows = methodsForOpenCV.getRows();
       int cols = methodsForOpenCV.getCols();
        int cameraMonitorViewId = hardwareMap.appContext.getResources().getIdentifier("cameraMonitorViewId", "id", hardwareMap.appContext.getPackageName());

        phoneCam = OpenCvCameraFactory.getInstance().createWebcam(hardwareMap.get(WebcamName.class, "Webcam 1"), cameraMonitorViewId);

        phoneCam.openCameraDevice();
        phoneCam.setPipeline(new Methods_for_OpenCV.StageSwitchingPipeline());

        phoneCam.startStreaming(rows, cols, OpenCvCameraRotation.UPRIGHT);



        telemetry.addData("Values", valLeft + "  " + valRight);
        telemetry.update();
        // visionPortall.telemetryAprilTag();

        runtime.reset();

        waitForStart();

        while (opModeIsActive()) {
            telemetry.addData("Values", valLeft + "  " + valRight);
            telemetry.update();

            telemetry.update();
            sleep (150);
            // 291 221
            if (valLeft == 255) {
                bros.setPower(1);
                act(400, 0.4);
                zaxvatLeft.setPower(0.05);
                nazad(750, 0.25);
                razvarot(450, 0.25);
                bros.setPower(0.2);
                vpered(100,0.25);
                bros.setPower(1);
                razvarot(450, 0.25);
                vpered(750,0.25);
                razvarot(-450, 0.25);
                nazad(1100,0.25);
                sleep(30000);
            } else if (valRight == 255) {
                bros.setPower(1);
                act(400, 0.4);
                zaxvatLeft.setPower(0.05);
                nazad(750, 0.25);
                bros.setPower(0.2);
                nazad(100,0.25);
                vpered(200,0.25);
                bros.setPower(1);
                vpered(750,0.25);
                razvarot(450, 0.25);
                nazad(1100,0.25);
                sleep(30000);
            } else {
                bros.setPower(1);
                act(400, 0.4);
                zaxvatLeft.setPower(0.05);
                nazad(650, 0.25);
                bros.setPower(0.2);

                nazad(100,0.25);
                vpered(200,0.25);
                bros.setPower(1);
                vpered(450,0.25);
                razvarot(450, 0.25);
                nazad(1100,0.25);
                sleep(30000);
                /*bros.setPower(1);
                act(400, 0.4);
                zaxvatLeft.setPower(0.05);
                nazad(750, 0.25);
                razvarot(-450, 0.25);
                bros.setPower(0.2);
                vpered(100,0.25);
                bros.setPower(1);
                razvarot(450, 0.25);
                vpered(750,0.25);
                razvarot(450, 0.25);
                nazad(1000,0.25);
                sleep(30000);*/
            }
        }}
            /*
            if (valLeft == 255) {
            } else if (valRight == 255) {
            } else {
            }*/





}