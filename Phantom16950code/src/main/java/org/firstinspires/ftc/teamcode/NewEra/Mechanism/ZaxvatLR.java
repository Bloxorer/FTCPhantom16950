package org.firstinspires.ftc.teamcode.NewEra.Mechanism;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.CRServo;

public class ZaxvatLR extends LinearOpMode {
    private CRServo zaxvatLeft, zaxvatRight, kr;
    public void initZaxvatLR(){
        zaxvatLeft = hardwareMap.crservo.get("zxl");
        zaxvatRight = hardwareMap.crservo.get("zxr");
        kr = hardwareMap.crservo.get("kr");
    }
    @Override
    public void runOpMode() throws InterruptedException {

    }
}
