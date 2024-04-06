package org.firstinspires.ftc.teamcode.NewEra.Utils;

import org.firstinspires.ftc.teamcode.NewEra.Mechanism.Actuator;
import org.firstinspires.ftc.teamcode.NewEra.Mechanism.Podem;
import org.firstinspires.ftc.teamcode.NewEra.Mechanism.Zaxvat;
import org.firstinspires.ftc.teamcode.NewEra.Phantom;
import org.firstinspires.ftc.teamcode.NewEra.Mechanism.Movement;

public class Utility extends Phantom {
    Movement movement = new Movement();
    Actuator actuator = new Actuator();
    Podem podem= new Podem();
    Zaxvat zaxvat = new Zaxvat();
    public void movement(){
        movement.moveTeleOP();
    }
    public void actuator(){}


    public void stop_all(){
        rightF.setPower(0);
        rightB.setPower(0);

    }
}
