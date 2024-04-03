package org.firstinspires.ftc.teamcode.NewEra.Mechanism;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.gamepad1;

import com.acmerobotics.roadrunner.PoseVelocity2d;
import com.acmerobotics.roadrunner.Vector2d;

import org.firstinspires.ftc.teamcode.NewEra.Utils.PID;

public class Movement extends PID {
    //TODO: здесь хочу самодельные пиды для колес с отладкой в дэщборде
    PID pid = new PID();
    public void move_withPID(){

    }

    //старое передвижение используемое много сезонов
    public void old_move(){

    }
    // передвижение через методы роадраннера
    public void moveTeleOP(){
        double x =-gamepad1.left_stick_y -(gamepad1.right_stick_y * 0.4); //
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
