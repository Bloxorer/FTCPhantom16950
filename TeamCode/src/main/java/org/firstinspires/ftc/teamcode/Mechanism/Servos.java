package org.firstinspires.ftc.teamcode.Mechanism;

import org.firstinspires.ftc.teamcode.methods.Config;
import org.firstinspires.ftc.teamcode.methods.Methods;

public class Servos extends Methods {
    int i = 0;
    int f = 0;
    int g = 0;
    public void kr(){
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
    public void zaxvat(){
        Thread tzaxvatL = new Thread(() -> {
            boolean knopk = knopka.isPressed();
            if (gamepad2.left_bumper){
                f = 1;
            } else if (gamepad2.left_trigger !=0){
                f = 0;
            } else if (knopk){
                f = 0;
            }
            if (f == 1){
                zaxvatLeft.setPower(Config.zxl_pos1);
            } else if(f == 0){
                zaxvatLeft.setPower(Config.zxl_pos0);
            }
        });
        Thread tzaxvatR = new Thread(()-> {
            if (gamepad2.right_bumper){
                g = 1;
            } else if (gamepad2.right_trigger !=0){
                g = 0;
            }
            if (g == 1){
                zaxvatRight.setPower(Config.zxr_pos1);
            } else if (g == 0){
                zaxvatRight.setPower(Config.zxr_pos0);
            }
        });
        tzaxvatL.start();
        tzaxvatR.start();
    }
}
