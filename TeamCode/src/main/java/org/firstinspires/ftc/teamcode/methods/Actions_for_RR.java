package org.firstinspires.ftc.teamcode.methods;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

import java.text.Format;

@Config
public class Actions_for_RR {
    public class Podem{
        private DcMotorEx pnap;
        public Podem(HardwareMap hardwareMap){
            pnap = hardwareMap.get(DcMotorEx.class, "pnap");
            pnap.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
            pnap.setDirection(DcMotorSimple.Direction.FORWARD);
        }
    }

}

