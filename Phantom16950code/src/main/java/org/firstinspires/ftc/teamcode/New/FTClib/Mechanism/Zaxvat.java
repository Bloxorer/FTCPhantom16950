package org.firstinspires.ftc.teamcode.New.FTClib.Mechanism;

import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.arcrobotics.ftclib.hardware.motors.MotorEx;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

public class Zaxvat extends LinearOpMode {
    private MotorEx zx;

    /**
     * инициализация мотора захвата
     */
    public void initZaxvat(){
        zx = new MotorEx(hardwareMap, "zx", Motor.GoBILDA.RPM_312);
    }
    @Override
    public void runOpMode() throws InterruptedException {

    }
}
