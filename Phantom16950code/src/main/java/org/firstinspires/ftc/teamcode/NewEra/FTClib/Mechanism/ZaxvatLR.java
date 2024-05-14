package org.firstinspires.ftc.teamcode.NewEra.FTClib.Mechanism;

import com.arcrobotics.ftclib.hardware.ServoEx;
import com.arcrobotics.ftclib.hardware.SimpleServo;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.CRServo;

public class ZaxvatLR extends LinearOpMode {
    private ServoEx kr, zaxvatLeft, zaxvatRight;

    /**
     * Инициализация сервомотров захвата
     */
    public void initZaxvatLR(){
        zaxvatLeft = new SimpleServo(hardwareMap,"zxl", 0, 270);
        zaxvatRight = new SimpleServo(hardwareMap,"zxr", 0, 270);
        kr = new SimpleServo(hardwareMap, "kr", 0, 270);
    }

    @Override
    public void runOpMode() throws InterruptedException {

    }
}
