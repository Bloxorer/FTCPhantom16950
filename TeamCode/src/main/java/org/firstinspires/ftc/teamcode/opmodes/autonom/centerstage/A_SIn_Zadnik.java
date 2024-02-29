package org.firstinspires.ftc.teamcode.opmodes.autonom.centerstage;



import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.util.ElapsedTime;


import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.teamcode.methods.Methods;
import org.firstinspires.ftc.teamcode.methods.Methods_for_OpenCV;

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
@Autonomous(name= "A_SIn_Zadnik", group="Autonomous")

//
public class A_SIn_Zadnik extends Methods {

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
        webcam1 = hardwareMap.get(WebcamName.class, "Webcam 1");
        zaxvatLeft = hardwareMap.crservo.get("zxl");
        zaxvatRight = hardwareMap.crservo.get("zxr");
        leftB = hardwareMap.dcMotor.get("lr");
        leftF = hardwareMap.dcMotor.get("lf");
        rightB = hardwareMap.dcMotor.get("rr");
        rightF = hardwareMap.dcMotor.get("rf");
        pod = hardwareMap.dcMotor.get("pod");
        actu = hardwareMap.dcMotor.get("act");
        zx = hardwareMap.dcMotor.get("zx");
        pnap = hardwareMap.dcMotor.get("pnap");
        kr = hardwareMap.crservo.get("kr");
        Methods_for_OpenCV methodsForOpenCV = new Methods_for_OpenCV();
        methodsForOpenCV.startOpenCV();
        Thread thread = new Thread(() -> {
            while (opModeInInit()){
                valLeft = Methods_for_OpenCV.getValLeft();
                valRight = Methods_for_OpenCV.getValRight();
                telemetry.update();
            }
        });
        thread.start();
        runtime.reset();
        waitForStart();
        while (opModeIsActive()) {
            telemetry.update();
            valLeft = Methods_for_OpenCV.getValLeft();
            valRight = Methods_for_OpenCV.getValRight();
            telemetry.update();
            sleep(150);
            // 291 221
            if (valLeft == 255) {
                pod.setPower(0.05);
                podAuto(100, 0.25);
                pramo();
                nazad(1000,0.25);
                razvarot(-750, 0.25);
                vpered(3800,0.3);
                vpravo(400,0.25);
                podem(1000,0.25);
                kr.setPower(1);
                zaxvatLeft.setPower(0);
                nazad(100, 0.25);
                vpravo(800,0.25);
                vpered(600,0.25);
                stop_all();
                sleep(30000);
            } else if (valRight == 255) {
                pod.setPower(0.05);
                pravo();
                stop_all();
                sleep(30000);
            } else {
                pod.setPower(0.05);
                levo();
                stop_all();
                sleep(30000);
            }
        }
    }
}
