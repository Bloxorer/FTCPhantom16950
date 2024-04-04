package org.firstinspires.ftc.teamcode.old.opmodes.autonomrr;



import com.acmerobotics.roadrunner.Pose2d;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.util.ElapsedTime;


import org.firstinspires.ftc.teamcode.old.methods.Methods;
import org.firstinspires.ftc.teamcode.old.methods.Methods_for_OpenCV;

import org.firstinspires.ftc.teamcode.old.roadrunnernew.MecanumDrive;

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
@Autonomous(name= "A_SIn_Zadnik_RR", group="Autonomous")
@Disabled
//
public class A_Sin_Zadnikl extends Methods {

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
        MecanumDrive drive = new MecanumDrive(hardwareMap, new Pose2d(0,0,0));
        Methods_for_OpenCV methodsForOpenCV = new Methods_for_OpenCV();

        Thread thread = new Thread(() -> {
            while (opModeInInit()){
                valLeft = Methods_for_OpenCV.getValLeft();
                valRight = Methods_for_OpenCV.getValRight();
                telemetry.update();
            }
        });
        thread.start();
        runtime.reset();
        waitForStart();
        while (opModeIsActive()) {

            valLeft = Methods_for_OpenCV.getValLeft();
            valRight = Methods_for_OpenCV.getValRight();
            telemetry.update();
            sleep(150);
            // 291 221
            if (valLeft == 255) {
                phoneCam.stopStreaming();
                phoneCam.closeCameraDevice();

            } else if (valRight == 255) {
                phoneCam.stopStreaming();
                phoneCam.closeCameraDevice();
            } else {
                phoneCam.stopStreaming();
                phoneCam.closeCameraDevice();

            }
        }
    }
}
