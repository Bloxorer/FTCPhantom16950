package org.firstinspires.ftc.teamcode.NewEra.FTClib.Mechanism;

import com.arcrobotics.ftclib.geometry.Rotation2d;
import com.arcrobotics.ftclib.hardware.GyroEx;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotorEx;
@Disabled
public class Actuator extends LinearOpMode {

    private DcMotorEx pod, actu;
    public void initActu(){
        pod = hardwareMap.get(DcMotorEx.class, "pod");
        actu = hardwareMap.get(DcMotorEx.class, "act");
    }

    @Override
    public void runOpMode() throws InterruptedException {

    }
}
