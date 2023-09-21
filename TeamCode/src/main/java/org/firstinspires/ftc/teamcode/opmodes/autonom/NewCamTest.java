package org.firstinspires.ftc.teamcode.opmodes.autonom;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.methods.Methods;
import org.firstinspires.ftc.teamcode.methods.Methods_for_OpenCV;
import org.firstinspires.ftc.teamcode.methods.Methods_move;
import org.firstinspires.ftc.teamcode.methods.VisionPortall;
import org.openftc.easyopencv.OpenCvCameraFactory;
import org.openftc.easyopencv.OpenCvCameraRotation;
import org.openftc.easyopencv.OpenCvInternalCamera;

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
        VisionPortall visionPortall = new VisionPortall();

        Methods_move move = new Methods_move();
        Methods_for_OpenCV cameramethd = new Methods_for_OpenCV();
        valLeft = cameramethd.getValLeft();
        valRight = cameramethd.getValRight();
        rows = cameramethd.getRows();
        cols = cameramethd.getCols();
        int cameraMonitorViewId = hardwareMap.appContext.getResources().getIdentifier("cameraMonitorViewId", "id", hardwareMap.appContext.getPackageName());
        phoneCam1 = OpenCvCameraFactory.getInstance().createInternalCamera(OpenCvInternalCamera.CameraDirection.BACK, cameraMonitorViewId);
        phoneCam1.openCameraDevice();
        phoneCam1.setPipeline(new Methods_for_OpenCV.StageSwitchingPipeline());
        phoneCam1.startStreaming(rows, cols, OpenCvCameraRotation.UPRIGHT);

        waitForStart();

        runtime.reset();
        while (opModeIsActive()) {
            telemetry.addData("Values", valLeft + "  " + valRight);
            telemetry.update();
            sleep (150);

            if (valLeft == 255) {
                sleep(30000);
            } else if (valRight  == 255) {
                sleep(30000);
            } else {
                sleep(30000);
            }
        }}
            /*
            if (valLeft == 255) {
            } else if (valRight == 255) {
            } else {
            }*/





}
