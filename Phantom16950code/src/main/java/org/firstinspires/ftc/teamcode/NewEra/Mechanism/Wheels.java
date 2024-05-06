package org.firstinspires.ftc.teamcode.NewEra.Mechanism;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotorEx;

@Disabled
public class Wheels extends LinearOpMode {
    private DcMotorEx leftF, rightF, leftB, rightB;
    public void initWheels(){
        leftB = hardwareMap.get(DcMotorEx.class, "lr");
        leftF = hardwareMap.get(DcMotorEx.class, "lf");
        rightB = hardwareMap.get(DcMotorEx.class, "rr");
        rightF = hardwareMap.get(DcMotorEx.class, "rf");
    }
    @Override
    public void runOpMode() throws InterruptedException {

    }
}
