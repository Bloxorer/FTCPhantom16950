package org.firstinspires.ftc.teamcode.NewEra.Opmode.TeleOP;

import com.acmerobotics.roadrunner.Pose2d;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Util;

import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.teamcode.NewEra.Mechanism.Actuator;
import org.firstinspires.ftc.teamcode.NewEra.Mechanism.Movement;
import org.firstinspires.ftc.teamcode.NewEra.Mechanism.Podem;
import org.firstinspires.ftc.teamcode.NewEra.Mechanism.Zaxvat;
import org.firstinspires.ftc.teamcode.NewEra.Phantom;
import org.firstinspires.ftc.teamcode.NewEra.Roadrunner.MecanumDrive;
import org.firstinspires.ftc.teamcode.NewEra.Utils.Camera.EasyCam;
import org.firstinspires.ftc.teamcode.NewEra.Utils.Utility;

@TeleOp
public class A_Gamepad_BASED extends Phantom {
    private final ElapsedTime runtime = new ElapsedTime();
    @Override
    public void runOpMode() throws InterruptedException {
        MecanumDrive drive = new MecanumDrive(hardwareMap, new Pose2d(0,0,0));
        Movement movement = new Movement();
        Actuator actuator = new Actuator();
        Podem podem = new Podem();
        Zaxvat zaxvat = new Zaxvat();
        Thread xy = new Thread(()->{
            x =-gamepad1.left_stick_y -(gamepad1.right_stick_y * 0.4);
            y = (-gamepad1.right_stick_x * 0.4) -gamepad1.left_stick_x;
            g1rt = -gamepad1.right_trigger;
            g1lt = gamepad1.left_trigger;
        });
        hardwareMapGetter();

       // EasyCam easyCam = new EasyCam(hardwareMap.get(WebcamName.class, "Webcam 1"), true, true, false, false);
        runtime.reset();
        waitForStart();
        while(opModeIsActive()){
            xy.start();
           // x =-gamepad1.left_stick_y -(gamepad1.right_stick_y * 0.4);
            //y = (-gamepad1.right_stick_x * 0.4) -gamepad1.left_stick_x;
            movement.moveTeleOP(drive);
            actuator.drive_act();
            podem.drive_pnap();
            podem.drive_pod();
            podem.drive_psk();
            zaxvat.drive_zaxvat();
            zaxvat.drive_kr();
            zaxvat.drive_zx();


        }
    }
}
