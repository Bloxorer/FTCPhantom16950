package org.firstinspires.ftc.teamcode.opmodes.drive;



import com.acmerobotics.roadrunner.Pose2d;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;


import org.firstinspires.ftc.teamcode.methods.Methods;

import org.firstinspires.ftc.teamcode.roadrunnernew.MecanumDrive;

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
@TeleOp(name = "a_Gamepad_based_lite", group="TeleOP")

//
public class a_Gamepad_based extends Methods {
    private final ElapsedTime runtime = new ElapsedTime();
    public void runOpMode() throws InterruptedException {
        MecanumDrive drive = new MecanumDrive(hardwareMap, new Pose2d(0, 0, 0));
        knopka = hardwareMap.touchSensor.get("knp");
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
        psk = hardwareMap.crservo.get("psk");
        runtime.reset();
        waitForStart();
        while (opModeIsActive()) {
            drive_psk();
            drive_tp();
            drive_pnap();
            drive_act();
            drive_pod();
            drive_zx();
            drive_zaxvat();
            drive_kr();
        }

    }
}
            /*
            if (valLeft == 255) {
            } else if (valRight == 255) {
            } else {
            }*/





