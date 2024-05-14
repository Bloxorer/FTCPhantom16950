package org.firstinspires.ftc.teamcode.NewEra.FTClib.Mechanism;

import com.arcrobotics.ftclib.hardware.ServoEx;
import com.arcrobotics.ftclib.hardware.SimpleServo;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.CRServo;

public class ZaxvatLR extends LinearOpMode {

    private ServoEx kr = new SimpleServo(hardwareMap, "kr", 0, 270);
    private CRServo zaxvatLeft, zaxvatRight;
    public void initZaxvatLR(){
        zaxvatLeft = hardwareMap.crservo.get("zxl");
        zaxvatRight = hardwareMap.crservo.get("zxr");

    }
    public void driveKr(){
        Thread thread = new Thread(()->{
            kr.setPosition(0);
        });
    }
    @Override
    public void runOpMode() throws InterruptedException {

    }
}
