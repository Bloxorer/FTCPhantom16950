package org.firstinspires.ftc.teamcode.Mechanism;

import com.acmerobotics.roadrunner.PoseVelocity2d;
import com.acmerobotics.roadrunner.Vector2d;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.methods.Methods;
import org.firstinspires.ftc.teamcode.roadrunnernew.MecanumDrive;

public class Movement extends Methods {
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
