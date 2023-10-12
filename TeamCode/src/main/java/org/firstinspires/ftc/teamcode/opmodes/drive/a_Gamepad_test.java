package org.firstinspires.ftc.teamcode.opmodes.drive;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorControllerEx;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.PIDFCoefficients;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.hardware.DigitalChannel;

import org.firstinspires.ftc.teamcode.methods.Methods;


//TODO: РџР РћР›Р•РўРђР РР™, РџР•Р Р•Р” РўР•РњР¬, РљРђРљ РњР•РќРЇРўР¬ Р§РўРћ-РўРћ Р’ Р“РђРњРђРџР•Р”Р•, РџР РћР’Р•Р Р¬ РЎРќРђР§РђР›Рђ РњРђРўР¬ РђР“РђРџРђ!!!
@TeleOp(name = "Gamepad_test", group = "TeleOP")
public class a_Gamepad_test extends OpMode {
    DcMotor leftF, rightF, leftB, rightB, pod, drin, motor;
    CRServo zaxvat, pisun, big;
    DigitalChannel knopka;
    private ElapsedTime runtime = new ElapsedTime(ElapsedTime.Resolution.MILLISECONDS);
    @Override
    public void init() {

        leftF = hardwareMap.dcMotor.get("lf");
        leftB = hardwareMap.dcMotor.get("lr");
        rightF = hardwareMap.dcMotor.get("rf");
        rightB = hardwareMap.dcMotor.get("rr");
        /*pisun = hardwareMap.crservo.get("pis");
        pod = hardwareMap.dcMotor.get("pod");
        drin = hardwareMap.dcMotor.get("drin");
        big = hardwareMap.crservo.get("big");
        zaxvat = hardwareMap.crservo.get("zx");
        knopka = hardwareMap.get(DigitalChannel.class, "knp");
        knopka.setMode(DigitalChannel.Mode.INPUT);*/
        zaxvat = hardwareMap.crservo.get("zaxvat");
        motor = hardwareMap.dcMotor.get("motor");

    }


    @Override

    public void loop() {
        Methods methods = new Methods();
        final double NEW_P = 0;
        final double NEW_I = 0;
        final double NEW_D = 0;
        final double NEW_F = 0;
        DcMotor vverx = hardwareMap.get(DcMotor.class, "motor");
        // Get a reference to the motor controller and cast it as an extended functionality controller.
        // We assume it's a REV Robotics Expansion Hub, which supports the extended controller functions.
        DcMotorControllerEx motorControllerEx = (DcMotorControllerEx)vverx.getController();
        // Get the port number of our configured motor.
        int motorIndex = ((DcMotorEx)vverx).getPortNumber();

        PIDFCoefficients pidfOrig = motorControllerEx.getPIDFCoefficients(motorIndex, DcMotor.RunMode.RUN_USING_ENCODER);
        PIDFCoefficients pidfModified = new PIDFCoefficients();
        //change coefficients
        PIDFCoefficients pidfNew = new PIDFCoefficients(NEW_P, NEW_I, NEW_D, NEW_F);
        Thread thread1 = new Thread(() -> {
            float StickX = (gamepad1.right_stick_x);
            float StickY = (gamepad1.right_stick_y);
            float pwrTrigger = (gamepad1.left_trigger);
            float pwrTrigger2 = (gamepad1.right_trigger);
            float pwrTrigger6 = (gamepad2.left_trigger);
            float pwrTrigger5 = (gamepad2.right_trigger);
            float pwrTrigger3 = (float) (gamepad2.left_trigger * 0.66);
            float pwrTrigger4 = (float) (gamepad2.right_trigger * 0.66);
            boolean Bumper_left = (gamepad1.left_bumper);
            boolean Bumper_right = (gamepad1.right_bumper);

            float Stick2X = (float) (gamepad1.left_stick_x * 0.3);
            float Stick2Y = (float) (gamepad1.left_stick_y * 0.3);
            try {
                if (StickY != 0 || StickX != 0) {
                    leftF.setPower((+StickY - StickX) + pwrTrigger);
                    leftB.setPower((+StickY + StickX) + pwrTrigger);
                    rightB.setPower((-StickY + StickX) + pwrTrigger2);
                    rightF.setPower((-StickY - StickX) - pwrTrigger2);
                } else if (Stick2Y != 0 || Stick2X != 0) {
                    leftF.setPower((+Stick2Y - Stick2X) + pwrTrigger);
                    rightB.setPower((-Stick2Y + Stick2X) + pwrTrigger2);
                    rightF.setPower((-Stick2Y - Stick2X) + pwrTrigger2);
                    leftB.setPower((+Stick2Y + Stick2X) + pwrTrigger);
                } else if (pwrTrigger != 0) {
                    leftF.setPower(0.6 * pwrTrigger);
                    rightB.setPower(0.6 * pwrTrigger);
                    rightF.setPower(0.6 * pwrTrigger);
                    leftB.setPower(0.6 * pwrTrigger);
                } else if (pwrTrigger2 != 0) {
                    leftF.setPower(-0.6 * pwrTrigger2);
                    rightB.setPower(-0.6 * pwrTrigger2);
                    rightF.setPower(-0.6 * pwrTrigger2);
                    leftB.setPower(-0.6 * pwrTrigger2);
                } else if (gamepad1.left_bumper) {
                    leftF.setPower(0.4);
                    rightB.setPower(0.4);
                    rightF.setPower(0.4);
                    leftB.setPower(0.4);
                } else if (gamepad1.right_bumper) {
                    leftF.setPower(-0.4);
                    rightB.setPower(-0.4);
                    rightF.setPower(-0.4);
                    leftB.setPower(-0.4);
                } else {
                    leftF.setPower(0);
                    rightB.setPower(0);
                    rightF.setPower(0);
                    leftB.setPower(0);
                }
            } catch (Exception e) {
                telemetry.addData("Motion error", "yes");
                throw new RuntimeException(e);
            }

        });
        thread1.start();
        //korob.setTargetPosition(720);
        telemetry.addData("Encoder ", motor.getCurrentPosition());
        telemetry.update();
        double power = -1;
        if (gamepad1.a){
            zaxvat.setPower(0.2);
        } else if (gamepad1.b){
            zaxvat.setPower(-0.2);
        } else{
            zaxvat.setPower(0);
        }
        Thread thread2 = new Thread(() -> {
            if (gamepad1.dpad_down){
                vverx.setPower(0.4);
            } else if (gamepad1.dpad_up) {
                vverx.setPower(-0.4);
            } else{
                if (motor.getCurrentPosition() >= -1700){
                    vverx.setPower(-0.02);
                } else {
                    vverx.setPower(0.02);
                }

            }
        });
        thread2.start();
        // pid controlled
        Thread thread = new Thread(() -> {
            if (gamepad1.dpad_left){
                vverx.setPower(0.4);
            } else if (gamepad1.dpad_right) {
                vverx.setPower(-0.4);
            } else{
                int motorPosition = motor.getCurrentPosition();
                vverx.setTargetPosition(motorPosition);
                motorControllerEx.setPIDFCoefficients(motorIndex, DcMotor.RunMode.RUN_USING_ENCODER, pidfNew);

            }
        });
        //thread.start();
        telemetry.addData("Runtime (sec)", "%.01f", getRuntime());
        telemetry.addData("P,I,D,F (orig)", "%.04f, %.04f, %.04f, %.04f",
                pidfOrig.p, pidfOrig.i, pidfOrig.d, pidfOrig.f);
        telemetry.addData("P,I,D,F (modified)", "%.04f, %.04f, %.04f, %.04f",
                pidfModified.p, pidfModified.i, pidfModified.d, pidfModified.f);
        telemetry.update();



        }
       /* if (knopka.getState() == true) {
            telemetry.addData("Digital Touch", "Is Not Pressed");
            telemetry.update();
        } else {
            telemetry.addData("Digital Touch", "Is Pressed");
            telemetry.update();
        }
        // Р·Р°РЅСЏС‚Рѕ 1 РіРµР№РјРїР°Рґ: СЃС‚РёРєРё , С‚СЂРёРіРіРµСЂС‹ , Р±Р°РјРїРµСЂР°
        // Р·Р°РЅСЏС‚Рѕ 2 РіРµР№РјРїР°Рґ: РєСЂРµСЃС‚РѕРІРёРЅР° РІРІРµСЂС… Рё РІРЅРёР·, Р±Р°РјРїРµСЂР°, Р±СѓРєРІС‹, С‚СЂРёРіРіРµСЂС‹
        // идея для поворота в движении
        */


}

        /*if (gamepad2.dpad_down){
            pod.setPower(0.7);
        } else if (gamepad2.dpad_up) {
            pod.setPower(-1);
        } else if (gamepad2.dpad_left) {
            pod.setPower(-0.01);
        }else if(gamepad2.dpad_right){
            pod.setPower(-0.1);
        } else {
            pod.setPower(0);
            pod.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        }
        if (gamepad2.left_bumper){
            pisun.setPower(-0.15);
        } else {
            pisun.setPower(0.25);
        }

        if (gamepad2.a) {
            drin.setPower(1);
        }  else if (gamepad2.y){
            drin.setPower(-1);
        } else {
            drin.setPower(0);
        }
        if (gamepad2.b){
            zaxvat.setPower(0.18);
        }
        else if (knopka.getState() == false){
            zaxvat.setPower(0.18);
        }
        else {
            zaxvat.setPower(-0.24);
        }

        if (gamepad2.x){
            big.setPower(-0.86);
        } else {
            big.setPower(0.86);*/
       // }

        /*if (pwrTrigger5 != 0) {
            vobla.setPower(0.5 * pwrTrigger5);
        } else if (pwrTrigger6 != 0) {
            vobla.setPower(-0.5 * pwrTrigger6);
        }  else {
            vobla.setPower(0);
        }*/

       /* if (gamepad2.dpad_left) {
            krut.setPower(0.9);
        }
        else if (gamepad2.dpad_right){
            krut.setPower(-0.9);
        }
        else {
            krut.setPower(0);
        }*/

      /*  if (gamepad1.start) {
            runtime.reset();
            while (runtime.time() <= 450) {
                tolk.setPower(0.75);
            }
            runtime.reset();
            while (runtime.time() <= 450) {
                tolk.setPower(0);
            }
            runtime.reset();
            while (runtime.time() <= 450) {
                tolk.setPower(0.75);
            }
            runtime.reset();
            while (runtime.time() <= 450) {
                tolk.setPower(0);
            }
            runtime.reset();
            while (runtime.time() <= 450) {
                tolk.setPower(0.75);
            }
            runtime.reset();
            while (runtime.time() <= 450) {
                tolk.setPower(0);
            }
            runtime.reset();
            while (runtime.time() <= 450) {
                tolk.setPower(0.75);
            }
            runtime.reset();
            while (runtime.time() <= 450) {
                tolk.setPower(0);
            }
        }
*/