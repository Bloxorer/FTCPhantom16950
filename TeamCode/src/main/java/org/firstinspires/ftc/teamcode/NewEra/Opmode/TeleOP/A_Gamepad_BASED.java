package org.firstinspires.ftc.teamcode.NewEra.Opmode.TeleOP;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.NewEra.Mechanism.Podem;
import org.firstinspires.ftc.teamcode.NewEra.Utils.Camera.EasyCam;

@TeleOp
public class A_Gamepad_BASED extends Podem {
    private final ElapsedTime runtime = new ElapsedTime();
    @Override
    public void runOpMode() throws InterruptedException {
        hardwareMapGetter();
        EasyCam cam = new EasyCam(true, true, false, false);
        runtime.reset();
        waitForStart();
        while(opModeIsActive()){
            moveTeleOP();
        }
    }
}
