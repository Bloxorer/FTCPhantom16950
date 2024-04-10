package org.firstinspires.ftc.teamcode.NewEra.Mechanism;

import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.NewEra.Phantom;

public class Actuator extends Phantom {
        public void drive_act(){
            boolean dpadup = gamepad2.dpad_up;
            boolean dpaddown = gamepad2.dpad_down;
            Thread tactu = new Thread(() -> {
                if (dpadup){
                    actu.setPower(1);
                } else if(dpaddown){
                    actu.setPower(-1);
                } else {
                    actu.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
                    actu.setPower(0.05);
                }
            });
            tactu.start();
        }

    }

