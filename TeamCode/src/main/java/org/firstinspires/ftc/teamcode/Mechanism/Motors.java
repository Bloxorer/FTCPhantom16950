package org.firstinspires.ftc.teamcode.Mechanism;

import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.methods.Config;
import org.firstinspires.ftc.teamcode.methods.Methods;

public class Motors extends Methods {

    public void pnap(){
        Thread tpnap = new Thread(()->{
            if (gamepad2.dpad_left){
                pnap.setPower(0.7);
            } else if (gamepad2.dpad_right) {
                pnap.setPower(-0.5);
            } else{
                pnap.setPower(0);
            }
        });
        tpnap.start();
    }
    public void act(){
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
    public void pod(){
        Thread tpod = new Thread(() ->{
            if(gamepad1.y){
                pod.setPower(0.5);
            } else if (gamepad1.a) {
                pod.setPower(-0.5);
            } else{
                pod.setPower(0);
            }
        });
        tpod.start();
    }
    public void zx(){
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
}
