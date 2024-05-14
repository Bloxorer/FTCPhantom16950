package org.firstinspires.ftc.teamcode.NewEra.FTClib.Mechanism;

import com.arcrobotics.ftclib.hardware.motors.MotorEx;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotorEx;

public class Napravlaushie extends LinearOpMode {
    private MotorEx pnap;

    /**
     * Инициализация подъёмника
     */
    public void initNapr(){
        pnap = new MotorEx(hardwareMap, "pnap");
    }
    @Override
    public void runOpMode() throws InterruptedException {

    }
}
