package org.firstinspires.ftc.teamcode.NewEra.Mechanism;

import org.firstinspires.ftc.teamcode.NewEra.Phantom;
import org.firstinspires.ftc.teamcode.old.methods.Config;
import org.firstinspires.ftc.teamcode.old.methods.Methods;

public class Zaxvat extends Phantom {

        public void drive_zx(){
            Thread tzx = new Thread(() -> {
                if (gamepad2.x){
                    zx.setPower(-Config.zx_zax);
                } else if (gamepad2.b) {
                    zx.setPower(Config.zx_zax);
                } else {
                    zx.setPower(0);
                }
            });
            tzx.start();
        }
        public void drive_kr(){
            if (gamepad2.a){
                i = 1;
            } else if (gamepad2.y) {
                i = 0;
            }
            if (i == 1) {
                kr.setPower(Config.kr_pos1);
            } else if ( i == 0){
                kr.setPower(Config.kr_pos0);
            }
        }
        public void drive_zaxvat() {
            Thread tzaxvatL = new Thread(() -> {
                boolean knopk = knopka.isPressed();
                if (gamepad2.left_bumper) {
                    f = 1;
                } else if (gamepad2.left_trigger != 0) {
                    f = 0;
                } else if (knopk) {
                    f = 0;
                }
                if (f == 1) {
                    zaxvatLeft.setPower(Config.zxl_pos1);
                } else if (f == 0) {
                    zaxvatLeft.setPower(Config.zxl_pos0);
                }
            });
            Thread tzaxvatR = new Thread(() -> {
                if (gamepad2.right_bumper) {
                    g = 1;
                } else if (gamepad2.right_trigger != 0) {
                    g = 0;

                }

            });
            tzaxvatR.start();
            tzaxvatL.start();
        }
    }


