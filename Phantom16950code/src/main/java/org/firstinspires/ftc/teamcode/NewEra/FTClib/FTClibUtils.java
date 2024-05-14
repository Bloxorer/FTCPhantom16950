package org.firstinspires.ftc.teamcode.NewEra.FTClib;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.NewEra.FTClib.Mechanism.Actuator;
import org.firstinspires.ftc.teamcode.NewEra.FTClib.Mechanism.Napravlaushie;
import org.firstinspires.ftc.teamcode.NewEra.FTClib.Mechanism.Wheels;
import org.firstinspires.ftc.teamcode.NewEra.FTClib.Mechanism.Zaxvat;
import org.firstinspires.ftc.teamcode.NewEra.FTClib.Mechanism.ZaxvatLR;

@Disabled
public class FTClibUtils extends LinearOpMode {
    public Wheels wheels = new Wheels();
    public Actuator actuator = new Actuator();
    public Napravlaushie napravlaushie = new Napravlaushie();
    public Zaxvat zaxvat = new Zaxvat();
    public ZaxvatLR zaxvatLR = new ZaxvatLR();
    public void initall(){
        wheels.initWheels();
        actuator.initActu();
        napravlaushie.initNapr();
        zaxvat.initZaxvat();
        zaxvatLR.initZaxvatLR();
    }
    @Override
    public void runOpMode() throws InterruptedException {

    }


}
