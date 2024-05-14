package org.firstinspires.ftc.teamcode.NewEra.FTClib.Mechanism;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotorEx;

public class Napravlaushie extends LinearOpMode {
    private DcMotorEx pnap;
    public void initNapr(){
        pnap = hardwareMap.get(DcMotorEx.class, "pnap");
    }
    @Override
    public void runOpMode() throws InterruptedException {

    }
}
