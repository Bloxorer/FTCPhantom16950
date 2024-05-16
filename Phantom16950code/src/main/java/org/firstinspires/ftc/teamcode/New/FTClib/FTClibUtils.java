package org.firstinspires.ftc.teamcode.New.FTClib;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.New.FTClib.Mechanism.Actuator;
import org.firstinspires.ftc.teamcode.New.FTClib.Mechanism.Napravlaushie;
import org.firstinspires.ftc.teamcode.New.FTClib.Mechanism.Wheels;
import org.firstinspires.ftc.teamcode.New.FTClib.Mechanism.Zaxvat;
import org.firstinspires.ftc.teamcode.New.FTClib.Mechanism.ZaxvatLR;

@Disabled
public class FTClibUtils extends LinearOpMode {
    // создаем объекты классов механизмов
    public Wheels wheels = new Wheels();
    public Actuator actuator = new Actuator();
    public Napravlaushie napravlaushie = new Napravlaushie();
    public Zaxvat zaxvat = new Zaxvat();
    public ZaxvatLR zaxvatLR = new ZaxvatLR();

    /**
     * Инициализация всех механизмов робота
     */
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
