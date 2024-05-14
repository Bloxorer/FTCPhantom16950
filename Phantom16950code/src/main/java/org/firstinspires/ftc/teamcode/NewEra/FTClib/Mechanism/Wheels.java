package org.firstinspires.ftc.teamcode.NewEra.FTClib.Mechanism;



import com.acmerobotics.roadrunner.PoseVelocity2d;
import com.acmerobotics.roadrunner.Vector2d;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.arcrobotics.ftclib.hardware.motors.MotorEx;
import com.arcrobotics.ftclib.hardware.motors.MotorGroup;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotorEx;

import org.firstinspires.ftc.teamcode.NewEra.Roadrunner.MecanumDrive;

@Disabled
public class Wheels extends LinearOpMode {

    private MotorEx leftF, rightF, leftB, rightB;

    public void initWheels(){
        leftB = new MotorEx(hardwareMap, "lr", Motor.GoBILDA.RPM_312);
        leftF = new MotorEx(hardwareMap, "lf", Motor.GoBILDA.RPM_312);
        rightB = new MotorEx(hardwareMap, "rr", Motor.GoBILDA.RPM_312);
        rightF = new MotorEx(hardwareMap, "rf", Motor.GoBILDA.RPM_312);
    }
    @Override
    public void runOpMode() throws InterruptedException {
    }
    public void drive_rr_speed(MecanumDrive drive){
        double x =-gamepad1.left_stick_y -(gamepad1.right_stick_y * 0.4);
        double y = (-gamepad1.right_stick_x * 0.4) -gamepad1.left_stick_x;
        drive.setDrivePowers(new PoseVelocity2d(
                new Vector2d(
                        x, //- (gamepad1.right_stick_y * 0.75),
                        y //- (gamepad1.right_stick_x * 0.75)
                ),
                -gamepad1.right_trigger + gamepad1.left_trigger // + rightbump() + leftbump()
        ));
    }
}
