package org.firstinspires.ftc.teamcode.old.opmodes.autonom.centerstage;



import static org.firstinspires.ftc.vision.VisionPortal.makeMultiPortalView;

import android.util.Size;

import com.acmerobotics.dashboard.FtcDashboard;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.util.ElapsedTime;


import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.teamcode.old.methods.Methods;
import org.firstinspires.ftc.teamcode.old.methods.Methods_for_OpenCV;

import org.firstinspires.ftc.vision.VisionPortal;
import org.firstinspires.ftc.vision.apriltag.AprilTagProcessor;
import org.openftc.easyopencv.OpenCvCameraFactory;
import org.openftc.easyopencv.OpenCvCameraRotation;

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
@Autonomous(name= "A_KRAN_BLIZ", group="Autonomous")

//
public class A_KRASN_BLIZ extends Methods {

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

        webcam1 = hardwareMap.get(WebcamName.class, "Webcam 1");
        zaxvatLeft = hardwareMap.crservo.get("zxl");
        zaxvatRight = hardwareMap.crservo.get("zxr");
        leftB = hardwareMap.dcMotor.get("lr");
        leftF = hardwareMap.dcMotor.get("lf");
        rightB = hardwareMap.dcMotor.get("rr");
        rightF = hardwareMap.dcMotor.get("rf");
        pod = hardwareMap.dcMotor.get("pod");
        actu = hardwareMap.dcMotor.get("act");
        zx = hardwareMap.dcMotor.get("zx");
        pnap = hardwareMap.dcMotor.get("pnap");
        kr = hardwareMap.crservo.get("kr");

        Thread threads = new Thread(() -> {

        });threads.start();
        aprilTag = new AprilTagProcessor.Builder().build();
        VisionPortal.Builder builder = new VisionPortal.Builder();
        builder.setCamera(webcam1).addProcessor(aprilTag).setLiveViewContainerId(1);
        // telemetryAprilTag();
        visionPortal = builder
                .enableLiveView(true)
                .setCameraResolution(new Size(640, 480))
                .build();
        makeMultiPortalView(2, VisionPortal.MultiPortalLayout.VERTICAL);
        Methods_for_OpenCV methodsForOpenCV = new Methods_for_OpenCV();
        int rows = methodsForOpenCV.getRows();
        int cols = methodsForOpenCV.getCols();
        int cameraMonitorViewId = hardwareMap.appContext.getResources().getIdentifier("cameraMonitorViewId", "id", hardwareMap.appContext.getPackageName());
        phoneCam = OpenCvCameraFactory.getInstance().createWebcam(webcam1,3);
        phoneCam.openCameraDevice();
        phoneCam.setPipeline(new Methods_for_OpenCV.StageSwitchingPipeline());
        phoneCam.startStreaming(rows, cols, OpenCvCameraRotation.UPRIGHT);

        Thread thread = new Thread(()-> {
            telemetry.addData("Values", valLeft + "  " + valRight);
            while(opModeInInit()){
                telemetry.update();
                valLeft = Methods_for_OpenCV.getValLeft();
                valRight = Methods_for_OpenCV.getValRight();
            }
        }); thread.start();

        FtcDashboard.getInstance().startCameraStream(phoneCam, 100);
        runtime.reset();
        waitForStart();
        while (opModeIsActive()) {
            telemetry.update();
            valLeft = Methods_for_OpenCV.getValLeft();
            valRight = Methods_for_OpenCV.getValRight();
            telemetry.update();
            sleep(150);
            // 291 221
            if (valLeft == 255) {
                pramo();
                vpered(600, 0.25);
                vlevo(1700, 0.25);
                stop_all();
                sleep(30000);
            } else if (valRight == 255) {
                pravo();
                vpered(900, 0.25);
                vlevo(1700, 0.25);
                stop_all();
                sleep(30000);
            } else {
                levo();
                vpered(900, 0.25);
                vlevo(1700, 0.35);
                stop_all();
                sleep(30000);
            }//
        }
    }
}
