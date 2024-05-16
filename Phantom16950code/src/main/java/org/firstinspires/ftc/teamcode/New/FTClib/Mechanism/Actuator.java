package org.firstinspires.ftc.teamcode.New.FTClib.Mechanism;

import com.arcrobotics.ftclib.hardware.motors.MotorEx;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Disabled
public class Actuator extends LinearOpMode {

    private MotorEx pod, actu;

    /**
     * Инициализация моторов актуатора
     */
    public void initActu(){
        pod = new MotorEx(hardwareMap, "pod");
        actu = new MotorEx(hardwareMap, "act");
    }

    @Override
    public void runOpMode() throws InterruptedException {

    }
}
