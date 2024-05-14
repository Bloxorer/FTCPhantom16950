package org.firstinspires.ftc.teamcode.NewEra.FTClib.Mechanism;

import static com.arcrobotics.ftclib.hardware.motors.Motor.RunMode.VelocityControl;

import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.arcrobotics.ftclib.hardware.motors.MotorEx;
import com.arcrobotics.ftclib.hardware.motors.MotorGroup;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotorEx;

@Disabled
public class Wheels extends LinearOpMode {
    private MotorEx lf = new MotorEx(hardwareMap, "lf", Motor.GoBILDA.RPM_312);
    private MotorEx rf =new MotorEx(hardwareMap,"rf", Motor.GoBILDA.RPM_312);
    MotorGroup motorGroup1 = new MotorGroup(lf, rf);

    private DcMotorEx leftF, rightF, leftB, rightB;
    public void initWheels(){
        leftB = hardwareMap.get(DcMotorEx.class, "lr");
        leftF = hardwareMap.get(DcMotorEx.class, "lf");
        rightB = hardwareMap.get(DcMotorEx.class, "rr");
        rightF = hardwareMap.get(DcMotorEx.class, "rf");
    }
    @Override
    public void runOpMode() throws InterruptedException {
    lf.setRunMode(VelocityControl);
    
    }
}
