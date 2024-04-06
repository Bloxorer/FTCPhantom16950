package org.firstinspires.ftc.teamcode.NewEra.Mechanism;

public class Podem extends Actuator{
    public class OLD{
        public void drive_pod(){
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
        public void drive_pnap(){
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
        public void drive_psk(){
            if (gamepad2.left_stick_button && gamepad2.right_stick_button){
                h = 1;
            } else {
                h = 0;
            }
            if (h == 1){
                psk.setPower(-1);
            } else if (h == 0){
                psk.setPower(-0.3);//
            }
        }
    }
}
