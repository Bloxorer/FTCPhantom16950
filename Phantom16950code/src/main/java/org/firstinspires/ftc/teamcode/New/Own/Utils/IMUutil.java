package org.firstinspires.ftc.teamcode.New.Own.Utils;

import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.IMU;

public class IMUutil extends LinearOpMode {
    IMU.Parameters imuparam;
    public void initIMU(){
        imuparam = new IMU.Parameters(
                new RevHubOrientationOnRobot(
                        RevHubOrientationOnRobot.LogoFacingDirection.BACKWARD,
                        RevHubOrientationOnRobot.UsbFacingDirection.BACKWARD
                )
        );
    }

    @Override
    public void runOpMode() throws InterruptedException {

    }
}
