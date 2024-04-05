package org.firstinspires.ftc.teamcode.NewEra.Opmode.Test;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.NewEra.Phantom;
import org.firstinspires.ftc.teamcode.NewEra.Utils.DashboardHelper;
import org.firstinspires.ftc.teamcode.NewEra.Utils.Camera.EasyCam;
import org.firstinspires.ftc.teamcode.NewEra.Utils.TelemetryOpModes;

@TeleOp
public class CamTest extends Phantom {
    private final ElapsedTime runtime = new ElapsedTime();
    @Override
    public void runOpMode() throws InterruptedException {
        EasyCam easyCam = new EasyCam(true, false, true, true);
        DashboardHelper dashboardHelper = new DashboardHelper();
        dashboardHelper.DashCam();
        TelemetryOpModes tom = new TelemetryOpModes();
        easyCam.cameraEasy();
        runtime.reset();
        waitForStart();
        while (opModeIsActive()){
            tom.telemetryCam();
            dashboardHelper.dashTelemetry();
        }
    }

}
