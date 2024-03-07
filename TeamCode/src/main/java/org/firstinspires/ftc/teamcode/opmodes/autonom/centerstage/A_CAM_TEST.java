package org.firstinspires.ftc.teamcode.opmodes.autonom.centerstage;



import static org.firstinspires.ftc.vision.VisionPortal.makeMultiPortalView;

import android.util.Size;

import com.acmerobotics.dashboard.FtcDashboard;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.util.ElapsedTime;


import org.firstinspires.ftc.robotcore.external.hardware.camera.BuiltinCameraDirection;
import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.robotcore.external.stream.CameraStreamSource;
import org.firstinspires.ftc.teamcode.methods.Methods;
import org.firstinspires.ftc.teamcode.methods.Methods_for_OpenCV;

import org.firstinspires.ftc.vision.VisionPortal;
import org.firstinspires.ftc.vision.apriltag.AprilTagProcessor;
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
@Autonomous(name= "A_CAM_TEST", group="Autonomous")

//
public class A_CAM_TEST extends Methods {

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
    int num[] = makeMultiPortalView(4, VisionPortal.MultiPortalLayout.VERTICAL);
    @Override
    public void runOpMode() throws InterruptedException {

        aprilTag = new AprilTagProcessor.Builder().build();
        VisionPortal.Builder builder = new VisionPortal.Builder();
        builder.setCamera(BuiltinCameraDirection.BACK).addProcessor(aprilTag);

        visionPortal = builder
                .setLiveViewContainerId(num[2])
                .setCameraResolution(new Size(640,480))
                .build();
        Methods_for_OpenCV methodsForOpenCV = new Methods_for_OpenCV();

            int rows = methodsForOpenCV.getRows();
            int cols = methodsForOpenCV.getCols();
           // int cameraMonitorViewId = hardwareMap.appContext.getResources().getIdentifier("cameraMonitorViewId", "id", hardwareMap.appContext.getPackageName());
            phoneCam1 = OpenCvCameraFactory.getInstance().createInternalCamera(OpenCvInternalCamera.CameraDirection.BACK, num[1]);
            phoneCam1.openCameraDevice();phoneCam1.setPipeline(new Methods_for_OpenCV.StageSwitchingPipeline());
            phoneCam1.startStreaming(1920, 1080, OpenCvCameraRotation.UPRIGHT);

        Thread telemetryopencv = new Thread(()-> {
            while(opModeInInit()){
                telemetry.addData("Values", valLeft + "  " + valRight);
                valLeft = methodsForOpenCV.getValLeft();
                valRight = methodsForOpenCV.getValRight();
                telemetry.update();

            }
        });
        telemetryopencv.start();
        Thread telemetryapriltag = new Thread(this::telemetryAprilTag);
        telemetryapriltag.start();

        runtime.reset();
        waitForStart();
        while (opModeIsActive()) {
            telemetry.update();
            valLeft = Methods_for_OpenCV.getValLeft();
            valRight = Methods_for_OpenCV.getValRight();
            if (aprilTag.getDetections() != null){
                telemetryAprilTag();
            }
            sleep(150);


            }//
        }
        public void initMultiPortal(){
        
    }
    }

