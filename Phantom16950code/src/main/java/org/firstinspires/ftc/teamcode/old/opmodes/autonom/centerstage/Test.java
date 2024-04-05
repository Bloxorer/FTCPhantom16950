package org.firstinspires.ftc.teamcode.old.opmodes.autonom.centerstage;



import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.util.ElapsedTime;


import org.firstinspires.ftc.teamcode.old.methods.Methods;

/**
 * Created by maryjaneb  on 11/13/2016.
 *
 * nerverest ticks
 * 60 1680
 * 40 1120
 * 20 560
 *
 * monitor: 640 x 480
 *YES
 */
@Autonomous(name= "Test1", group="Autonomous")
@Disabled
//
public class Test extends Methods {

    private final ElapsedTime runtime = new ElapsedTime();
    private static int valLeft = -1;
    private static int valRight = -1;

    private static float rectHeight = 0.5f / 8f;
    private static float rectWidth = 0.5f / 8f;
    private static float rectHeight1 = 0.5f / 8f;
    private static float rectWidth1 = 0.5f / 8f;

    private static float offsetX = 0f / 8f;//changing this moves the three rects and the three circles left or right, range : (-2, 2) not inclusive
    private static float offsetY = 0f / 8f;//changing this moves the three rects and circles up or down, range: (-4, 4) not inclusive

    private static float[] leftPos = {2.0f / 8f + offsetX, 4f / 8f + offsetY};
    private static float[] rightPos = {2.8f / 8f + offsetX, 4 / 8f + offsetY};

    public void runOpMode() throws InterruptedException {

        leftB = hardwareMap.dcMotor.get("lr");
        leftF = hardwareMap.dcMotor.get("lf");
        rightB = hardwareMap.dcMotor.get("rr");
        rightF = hardwareMap.dcMotor.get("rf");

        runtime.reset();
        waitForStart();
        while (opModeIsActive()) {
            // 291 221
            leftF.setPower(0.3);
            rightF.setPower(0.3);
            leftB.setPower(0.3);
            rightB.setPower(0.3);
            sleep(20000);
                stop_all();
                sleep(30000);


        }
    }
}
