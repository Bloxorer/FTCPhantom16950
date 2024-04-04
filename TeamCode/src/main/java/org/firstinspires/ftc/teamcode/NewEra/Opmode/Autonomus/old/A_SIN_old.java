package org.firstinspires.ftc.teamcode.NewEra.Opmode.Autonomus.old;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.NewEra.Phantom;
import org.firstinspires.ftc.teamcode.NewEra.Trajectories.TrajectoriesOld;

@Autonomous
public class A_SIN_old extends TrajectoriesOld {
    private final ElapsedTime runtime = new ElapsedTime();
    @Override
    public void runOpMode() throws InterruptedException {
        hardwareMapGetter();
        runtime.reset();
        waitForStart();
        while(opModeIsActive()){
            if(valLeft == 255){ //центр
                pramo();
            } else if (valRight == 255) { // право
                pramo();
            } else { //лево
                pramo();
            }
        }
    }
}
