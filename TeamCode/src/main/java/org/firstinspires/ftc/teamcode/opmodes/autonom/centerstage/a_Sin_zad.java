package org.firstinspires.ftc.teamcode.opmodes.autonom.centerstage;



import org.firstinspires.ftc.robotcore.external.android.util.Size;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.util.ElapsedTime;


import org.firstinspires.ftc.teamcode.methods.Methods;
import org.firstinspires.ftc.teamcode.methods.Methods_for_OpenCV;
import org.firstinspires.ftc.teamcode.methods.Methods_move;
import org.firstinspires.ftc.teamcode.methods.VisionPortall;
import org.firstinspires.ftc.vision.VisionPortal;
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
@Autonomous(name= "a_Sin_zad", group="Autonomous")

//
public class a_Sin_zad extends Methods {
    private final ElapsedTime runtime = new ElapsedTime();
    private static int valLeft;
    private static int valRight;
    private int rows;
    private int cols;
    private VisionPortal visionPortal;
    @Override
    public void runOpMode() throws InterruptedException {
        Methods_move move = new Methods_move();
        Size size = new Size(rows, cols);
        VisionPortall visionPortall = new VisionPortall();
        Methods_for_OpenCV cameramethd = new Methods_for_OpenCV();

        leftF = hardwareMap.dcMotor.get("lf");
        leftB = hardwareMap.dcMotor.get("lr");
        rightF = hardwareMap.dcMotor.get("rf");
        rightB = hardwareMap.dcMotor.get("rr");
        ryka = hardwareMap.dcMotor.get("motor");
        zaxvat = hardwareMap.crservo.get("zaxvat");
        motor2 = hardwareMap.dcMotor.get("motor2");
        pisun = hardwareMap.crservo.get("pis");

        valLeft = cameramethd.getValLeft();
        valRight = cameramethd.getValRight();
        rows = cameramethd.getRows();
        cols = cameramethd.getCols();
        Thread thread = new Thread(() -> {int cameraMonitorViewId = hardwareMap.appContext.getResources().getIdentifier("cameraMonitorViewId", "id", hardwareMap.appContext.getPackageName());

            phoneCam1 = OpenCvCameraFactory.getInstance().createInternalCamera(OpenCvInternalCamera.CameraDirection.BACK, cameraMonitorViewId);

            phoneCam1.openCameraDevice();
            phoneCam1.setPipeline(new Methods_for_OpenCV.StageSwitchingPipeline());

            phoneCam1.startStreaming(rows, cols, OpenCvCameraRotation.UPRIGHT);});
        visionPortall.initVisionPortal();


        // visionPortall.telemetryAprilTag();

        runtime.reset();

        waitForStart();

        while (opModeIsActive()) {

            telemetry.addData("Values", valLeft + "  " + valRight);
            telemetry.update();
            sleep (150);
            if (valLeft == 255) {
                zaxvat.setPower(0);
                motor2.setPower(1);
                nazad(700, 0.25);
                razvarot(-200, 0.25);
                vpered(300, 0.25);
                razvarot(00, 0.25);
                nazad(1000, 0.25);
                xvatat(-900,0.25);
                sleep(30000);
            } else if (valRight  == 255) {
                zaxvat.setPower(0);
                motor2.setPower(1);
                nazad(700, 0.25);
                razvarot(-200, 0.25);
                vpered(300, 0.25);
                razvarot(800, 0.25);
                nazad(1000, 0.25);
                xvatat(-900,0.25);
                sleep(30000);
            } else {
                zaxvat.setPower(0);
                motor2.setPower(1);
                nazad(700, 0.25);
                razvarot(-200, 0.25);
                vpered(300, 0.25);
                razvarot(800, 0.25);
                nazad(1000, 0.25);
                xvatat(-900,0.25);
                sleep(30000);
            }
        }}
            /*
            if (valLeft == 255) {
            } else if (valRight == 255) {
            } else {
            }*/





}