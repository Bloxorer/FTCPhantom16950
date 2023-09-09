package org.firstinspires.ftc.teamcode.methods;

import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.robotcore.hardware.VoltageSensor;

import org.firstinspires.ftc.robotcore.external.navigation.Orientation;
import org.openftc.easyopencv.OpenCvWebcam;

public class Methods_move extends LinearOpMode {
    public DcMotor leftF, rightF, leftB, rightB, pod, drin;
    public CRServo zaxvat, pisun, big;
    public BNO055IMU imu;
    public DigitalChannel knopka;
    public Orientation angles;
    public VoltageSensor sensor;
    public double speed;
    public OpenCvWebcam phoneCam;

    //private DistanceSensor sensorRange;

    private static int valLeft = -1;
    private static int valRight = -1;
    private static float rectHeight = 0.7f / 8f;
    private static float rectWidth = 0.7f / 8f;
    private static float rectHeight1 = 0.7f / 8f;
    private static float rectWidth1 = 0.7f / 8f;

    private static float offsetX = 0f / 8f;//changing this moves the three rects and the three circles left or right, range : (-2, 2) not inclusive
    private static float offsetY = 0f / 8f;//changing this moves the three rects and circles up or down, range: (-4, 4) not inclusive

    private static float[] leftPos = {5.5f / 8f + offsetX, 4f / 8f + offsetY};
    private static float[] rightPos = {6.5f / 8f + offsetX, 4f / 8f + offsetY};

    private final int rows = 640;
    private final int cols = 480;
    public void razvarot(int pos, double speed) {
        leftF.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        leftB.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightB.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightF.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        leftF.setTargetPosition(pos);
        rightB.setTargetPosition(pos);
        rightF.setTargetPosition(pos);
        leftB.setTargetPosition(pos);
        leftF.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        leftB.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rightF.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rightB.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        leftF.setPower(speed);
        rightB.setPower(speed);
        rightF.setPower(speed);
        leftB.setPower(speed);
        while (opModeIsActive() && (leftF.isBusy()) && (rightF.isBusy()) && (rightB.isBusy()) && (leftB.isBusy())) {

            telemetry.addData("Path2", "Running at %7d :%7d : %7d :%7d",
                    leftF.getCurrentPosition(),
                    rightB.getCurrentPosition(), rightF.getCurrentPosition(), leftB.getCurrentPosition());
            telemetry.update();
        }
        rightB.setPower(0);
        leftB.setPower(0);
        rightF.setPower(0);
        leftF.setPower(0);
    }
    public void vpravo(int pos, double speed) {
        leftF.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        leftB.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightB.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightF.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        leftF.setTargetPosition(pos);
        rightB.setTargetPosition(-pos);
        rightF.setTargetPosition(pos);
        leftB.setTargetPosition(-pos);
        leftF.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        leftB.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rightF.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rightB.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        leftF.setPower(speed);
        rightB.setPower(speed);
        rightF.setPower(speed);
        leftB.setPower(speed);
        while (opModeIsActive() && (leftF.isBusy()) && (rightF.isBusy()) && (rightB.isBusy()) && (leftB.isBusy())) {

        }

        // Stop all motion;
        rightB.setPower(0);
        leftB.setPower(0);
        rightF.setPower(0);
        leftF.setPower(0);
        sleep(100);

    }
    public void vlevo(int pos, double speed) {
        vpravo(-pos, speed);
    }
    public void nazad(int pos, double speed) {
        vpered(-pos, speed);
    }

    public void vpered(int pos, double speed) {
        leftF.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        leftB.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightB.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightF.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        leftF.setTargetPosition(pos);
        rightB.setTargetPosition(-pos);
        rightF.setTargetPosition(-pos);
        leftB.setTargetPosition(pos);
        leftF.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        leftB.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rightF.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rightB.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        leftF.setPower(speed);
        rightB.setPower(speed);
        rightF.setPower(speed);
        leftB.setPower(speed);
        while (opModeIsActive() && (leftF.isBusy()) && (rightF.isBusy()) && (rightB.isBusy()) && (leftB.isBusy())) {

            telemetry.addData("Path2", "Running at %7d :%7d : %7d :%7d",
                    leftF.getCurrentPosition(), rightB.getCurrentPosition(), rightF.getCurrentPosition(), leftB.getCurrentPosition());
            telemetry.update();
        }
        rightB.setPower(0);
        leftB.setPower(0);
        rightF.setPower(0);
        leftF.setPower(0);
        sleep(100);
    }
    public void runOpMode() throws InterruptedException {}

}
