package org.firstinspires.ftc.teamcode.NewEra.Mechanism;

import com.qualcomm.robotcore.hardware.DcMotor;

public class Actuator extends Zaxvat {
    public class OLD extends Actuator{
        public void drive_act(){
            Thread tactu = new Thread(() -> {
                if (gamepad2.dpad_up){
                    actu.setPower(1);
                } else if(gamepad2.dpad_down){
                    actu.setPower(-1);
                } else {
                    actu.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
                    actu.setPower(0.05);
                }
            });
            tactu.start();
        }

    }

}
