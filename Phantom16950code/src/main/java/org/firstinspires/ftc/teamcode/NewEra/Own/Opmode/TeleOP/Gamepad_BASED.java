package org.firstinspires.ftc.teamcode.NewEra.Own.Opmode.TeleOP;

import com.acmerobotics.roadrunner.Pose2d;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.teamcode.NewEra.FTClib.FTClibUtils;
import org.firstinspires.ftc.teamcode.NewEra.Own.Utils.Camera.EasyCam;
import org.firstinspires.ftc.teamcode.NewEra.Own.Utils.TelemetryOpModes;
import org.firstinspires.ftc.teamcode.NewEra.Roadrunner.MecanumDrive;

@TeleOp
public class Gamepad_BASED extends LinearOpMode {
    private final ElapsedTime runtime = new ElapsedTime();
    @Override
    public void runOpMode() throws InterruptedException {
        EasyCam cam = new EasyCam( hardwareMap.get(WebcamName.class, "Webcam 1"), true, true, false, true);
        cam.cameraEasy();
        TelemetryOpModes telemetry = new TelemetryOpModes();
        MecanumDrive drive = new MecanumDrive(hardwareMap, new Pose2d(0,0,0));
        FTClibUtils robot = new FTClibUtils();
        robot.initall();
        telemetry.telemetryCam();
        telemetry.dashTelemetry();
        telemetry.DashCam();
        runtime.reset();
        waitForStart();
        while(opModeIsActive()){
            robot.wheels.drive_rr_speed(drive);
        }
    }
}
