package org.firstinspires.ftc.teamcode.opmodes.drive;

import android.util.Size;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.hardware.DigitalChannel;

import org.firstinspires.ftc.robotcore.external.hardware.camera.BuiltinCameraDirection;
import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.robotcore.external.tfod.Recognition;
import org.firstinspires.ftc.teamcode.methods.Methods;
import org.firstinspires.ftc.teamcode.methods.VisionPortall;
import org.firstinspires.ftc.vision.VisionPortal;
import org.firstinspires.ftc.vision.apriltag.AprilTagProcessor;
import org.firstinspires.ftc.vision.tfod.TfodProcessor;

import java.util.List;


//TODO: РџР РћР›Р•РўРђР РР™, РџР•Р Р•Р” РўР•РњР¬, РљРђРљ РњР•РќРЇРўР¬ Р§РўРћ-РўРћ Р’ Р“РђРњРђРџР•Р”Р•, РџР РћР’Р•Р Р¬ РЎРќРђР§РђР›Рђ РњРђРўР¬ РђР“РђРџРђ!!!
@TeleOp(name = "Gamepad_test", group = "TeleOP")
public class a_Gamepad_test extends OpMode {
    public VisionPortal visionPortal;
    public TfodProcessor tfod, tfod1;
    public AprilTagProcessor aprilTag;
    private WebcamName webcam1;
    private static final String TFOD_MODEL_ASSET1 = "CenterStageobh.tflite";
    private static final String TFOD_MODEL_ASSET2 = "CenterStageBlue.tflite";
    private static final String[] LABELS = {
            "red allience",
            "blue allience"
    };
    private static final boolean USE_WEBCAM = true;
    DcMotor leftF, rightF, leftB, rightB, pod, ryka, actu;
    CRServo zaxvatLeft, zaxvatRight, bros, big;
    DigitalChannel knopka;
    int motorPosition;
    private ElapsedTime runtime = new ElapsedTime(ElapsedTime.Resolution.MILLISECONDS);
    VisionPortall visionPortall = new VisionPortall();
    @Override
    public void init() {
        int i = 0;
        //visionPortall.initVisionPortal();
        try{
            leftF = hardwareMap.dcMotor.get("lf");
            leftB = hardwareMap.dcMotor.get("lr");
            rightF = hardwareMap.dcMotor.get("rf");
            rightB = hardwareMap.dcMotor.get("rr");
            bros = hardwareMap.crservo.get("bs");
            zaxvatLeft = hardwareMap.crservo.get("zxl");
            zaxvatRight = hardwareMap.crservo.get("zxr");
            ryka = hardwareMap.dcMotor.get("rk");
            actu = hardwareMap.dcMotor.get("ac");
            pod = hardwareMap.dcMotor.get("pod");
        } catch (Exception e){
            telemetry.addData("init error", " yes");
            throw new RuntimeException(e);
        }

    }


    @Override

    public void loop() {

        Methods methods = new Methods();
        // Get a reference to the motor controller and cast it as an extended functionality controller.
        // We assume it's a REV Robotics Expansion Hub, which supports the extended controller functions.

        // Get the port number of our configured motor.

        Thread tmovement = new Thread(() -> {
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
                    leftF.setPower(0.2);
                    rightB.setPower(0.2);
                    rightF.setPower(0.2);
                    leftB.setPower(0.2);
                } else if (gamepad1.right_bumper) {
                    leftF.setPower(-0.2);
                    rightB.setPower(-0.2);
                    rightF.setPower(-0.2);
                    leftB.setPower(-0.2);
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

        // actuactor
        Thread tactu = new Thread(() -> {
            if (gamepad1.dpad_up){
                actu.setPower(1);
            } else if(gamepad1.dpad_down){
                actu.setPower(-1);
            } else {
                actu.setPower(0);
            }
        });
        // sbros pixel autonom
        Thread tsbros = new Thread(() -> {
            if(gamepad1.b){
                bros.setPower(1);
            }
        });

        // zaxvat na ryke
        Thread tzaxvat = new Thread(() -> {
        if (gamepad2.left_bumper){
            zaxvatLeft.setPower(-0.2);
        } else{
            zaxvatLeft.setPower(0.05);
        }
        if (gamepad2.right_bumper){
            zaxvatRight.setPower(1);
        } else{
            zaxvatRight.setPower(0.75);
        }});
        // ryka
        Thread tryka = new Thread(() -> {
            if(gamepad2.dpad_up){
                ryka.setPower(0.55);
            } else if (gamepad2.dpad_down) {
                ryka.setPower(-0.55);
            } else{
                ryka.setPower(-0.085);
            }
        });
        //podtmnik actuatora
        Thread tpod = new Thread(() -> {
            if (gamepad1.y){
                pod.setPower(0.3);
            } else if (gamepad1.a) {
                pod.setPower(-0.3);
            } else {
                pod.setPower(0);
            }
        });
        //Starting threads

        tsbros.start();
        tpod.start();
        tmovement.start();
        tactu.start();
        tzaxvat.start();
        tryka.start();





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