package org.firstinspires.ftc.teamcode.NewEra.Own.Utils;

import org.firstinspires.ftc.teamcode.NewEra.Own.Phantom;

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
}
