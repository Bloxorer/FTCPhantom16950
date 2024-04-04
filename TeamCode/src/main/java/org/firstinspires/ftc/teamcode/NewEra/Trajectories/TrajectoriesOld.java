package org.firstinspires.ftc.teamcode.NewEra.Trajectories;

import org.firstinspires.ftc.teamcode.NewEra.Mechanism.Podem;

public class TrajectoriesOld extends Podem {
    public void pramo(){
        old_move("pramo", 1000, 0.5);
        stop_all();
        sleep(30000);
    }
}
