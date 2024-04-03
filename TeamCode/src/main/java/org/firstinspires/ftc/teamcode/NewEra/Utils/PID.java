package org.firstinspires.ftc.teamcode.NewEra.Utils;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;

import org.firstinspires.ftc.teamcode.NewEra.Phantom;
@Config
public class PID extends Phantom {
    public double P;
    public double I;
    public double D;
    public double errorP;
    public double errorI;
    public double errorD;

}
