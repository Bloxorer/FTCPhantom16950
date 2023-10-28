package org.firstinspires.ftc.teamcode.opmodes.autonom;


import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.tfod.Recognition;
import org.firstinspires.ftc.teamcode.methods.Methods;
import org.firstinspires.ftc.teamcode.methods.VisionPortall;
import org.firstinspires.ftc.vision.VisionPortal;

/**
 * Created by maryjaneb  on 11/13/2016.
 *
 * nerverest ticks
 * 60 1680
 * 40 1120
 * 20 560
 * <p>
 * monitor: 640 x 480
 *YES
 */
@Autonomous(name= "CamTestNew", group="Autonomous")

//
public class NewCamTest extends Methods {
    private final ElapsedTime runtime = new ElapsedTime();
    private double x,y;
    private VisionPortal visionPortal;
    @Override
    public void runOpMode() throws InterruptedException {

        VisionPortall visionPortall = new VisionPortall();
        x = visionPortall.getX();
        y = visionPortall.getY();
        Thread thread1 = new Thread(() -> {
            visionPortall.initVisionPortal();
        });
        thread1.start();


        // visionPortall.telemetryAprilTag();

        runtime.reset();

        waitForStart();

        while (opModeIsActive()) {
            telemetry.addData("", " ");
            telemetry.addData("- Position", "%.0f / %.0f", x, y);

            sleep (150);
            if (true) {
                sleep(30000);
            } else if (false) {
                sleep(30000);
            } else {
                sleep(30000);
            }
        }}
            /*
            if (valLeft == 255) {
            } else if (valRight == 255) {
            } else {
            }*/





}
