package org.firstinspires.ftc.teamcode.NewEra.Own.Utils;

import com.acmerobotics.dashboard.FtcDashboard;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.NewEra.Own.Phantom;

/**
 * класс телеметрии
 */
public class TelemetryOpModes extends Phantom {

    public void telemetryCam(){
        Thread thread = new Thread(() -> {
            while (opModeInInit()){
                telemetry.addData("valLeft", valLeft);
                telemetry.addData("valRight", valRight);
                telemetry.update();
            }
        });
        thread.start();
    }
    FtcDashboard dashboard = FtcDashboard.getInstance();
    public void DashCam(){
        dashboard.startCameraStream(camera, 100);
    }
    public void dashTelemetry(){
        Thread thread = new Thread(() -> {
            while (opModeInInit()){
                Telemetry telemetry1 = dashboard.getTelemetry();
                telemetry1.addData("valLeft", valLeft);
                telemetry1.addData("valRight", valRight);
                telemetry1.update();
            }
        });
        thread.start();
    }
}


