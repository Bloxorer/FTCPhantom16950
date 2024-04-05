package org.firstinspires.ftc.teamcode.old.opmodes.autonom.centerstage;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
/*
@TeleOp(name = "testgavno", group = "TeleOP")
public class testgavno extends OpMode {
    DcMotor leftF, rightF, leftB, rightB, pod,actu, drin;
    CRServo zaxvat, pisun, big;
    DigitalChannel knopka;
    private ElapsedTime runtime = new ElapsedTime(ElapsedTime.Resolution.MILLISECONDS);


   @Override
    public void init() {
        int i = 0;
        //visionPortall.initVisionPortal();
        try{

            actu = hardwareMap.dcMotor.get("ac");
            pod = hardwareMap.dcMotor.get("pod");
        } catch (Exception e){
            telemetry.addData("init error", " yes");
            throw new RuntimeException(e);
        }

    }

    public void loop() {

        if (gamepad1.dpad_up){
            actu.setPower(1);
            telemetry.addData("enc", actu.getCurrentPosition());
            telemetry.update();
        } else if(gamepad1.dpad_down){
            actu.setPower(-1);
            telemetry.addData("enc", actu.getCurrentPosition());
            telemetry.update();2
        } else {
            actu.setPower(0);
        }


    }
   */