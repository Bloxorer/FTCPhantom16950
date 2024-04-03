package org.firstinspires.ftc.teamcode.NewEra.Utils;

import com.acmerobotics.dashboard.FtcDashboard;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.NewEra.Phantom;

public class DashboardHelper extends Phantom {
    FtcDashboard dashboard = FtcDashboard.getInstance();
    public void DashCam(){
        dashboard.startCameraStream(camera, 100);
    }
    public void dashTelemetry(){
       Telemetry telemetry1 = dashboard.getTelemetry();
       telemetry1.addData("valLeft", valLeft);
       telemetry1.addData("valRight", valRight);
       telemetry1.update();

    }

}
