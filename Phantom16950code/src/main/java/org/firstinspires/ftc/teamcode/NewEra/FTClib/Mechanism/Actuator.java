package org.firstinspires.ftc.teamcode.NewEra.FTClib.Mechanism;

import com.arcrobotics.ftclib.geometry.Rotation2d;
import com.arcrobotics.ftclib.hardware.GyroEx;
import com.arcrobotics.ftclib.hardware.motors.MotorEx;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotorEx;
@Disabled
public class Actuator extends LinearOpMode {

    private MotorEx pod, actu;
    public void initActu(){
        pod = new MotorEx(hardwareMap, "pod");
        actu = new MotorEx(hardwareMap, "act");
    }

    @Override
    public void runOpMode() throws InterruptedException {

    }
}
