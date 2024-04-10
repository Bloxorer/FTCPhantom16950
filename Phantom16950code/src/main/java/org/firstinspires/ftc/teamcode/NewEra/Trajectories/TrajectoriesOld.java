package org.firstinspires.ftc.teamcode.NewEra.Trajectories;

import org.firstinspires.ftc.teamcode.NewEra.Mechanism.Actuator;
import org.firstinspires.ftc.teamcode.NewEra.Mechanism.Movement;
import org.firstinspires.ftc.teamcode.NewEra.Mechanism.Podem;
import org.firstinspires.ftc.teamcode.NewEra.Mechanism.Zaxvat;
import org.firstinspires.ftc.teamcode.NewEra.Phantom;
import org.firstinspires.ftc.teamcode.NewEra.Utils.Utility;

public class TrajectoriesOld extends Utility {
    Movement movement = new Movement();
    Actuator actuator = new Actuator();
    Podem podem = new Podem();
    Zaxvat zaxvat = new Zaxvat();
    public void pramo(){
        movement.old_move("pramo", 1000, 0.5);
        stop_all();
        sleep(30000);
    }
}
