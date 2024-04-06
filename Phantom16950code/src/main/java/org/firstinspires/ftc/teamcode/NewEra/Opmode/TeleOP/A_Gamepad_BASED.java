package org.firstinspires.ftc.teamcode.NewEra.Opmode.TeleOP;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Util;

import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.teamcode.NewEra.Mechanism.Podem;
import org.firstinspires.ftc.teamcode.NewEra.Utils.Camera.EasyCam;
import org.firstinspires.ftc.teamcode.NewEra.Utils.Utility;

@TeleOp
public class A_Gamepad_BASED extends Utility {
    private final ElapsedTime runtime = new ElapsedTime();
    @Override
    public void runOpMode() throws InterruptedException {
        hardwareMapGetter();

        EasyCam easyCam = new EasyCam(hardwareMap.get(WebcamName.class, "Webcam 1"), true, true, false, false);
        runtime.reset();
        waitForStart();
        while(opModeIsActive()){

        }
    }
}
