package org.firstinspires.ftc.teamcode.NewEra.Mechanism;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotorEx;

public class Zaxvat extends LinearOpMode {
    private DcMotorEx zx;
    public void initZaxvat(){
        zx = hardwareMap.get(DcMotorEx.class, "zx");
    }
    @Override
    public void runOpMode() throws InterruptedException {

    }
}
