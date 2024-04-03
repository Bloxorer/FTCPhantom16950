package org.firstinspires.ftc.teamcode;

import com.acmerobotics.dashboard.FtcDashboard;
import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.TouchSensor;
import com.qualcomm.robotcore.hardware.VoltageSensor;

import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.vision.VisionPortal;
import org.firstinspires.ftc.vision.apriltag.AprilTagProcessor;
import org.openftc.easyopencv.OpenCvWebcam;

public class Phantom extends LinearOpMode {
    public AprilTagProcessor aprilTag;
    public VisionPortal visionPortal;
    public DcMotor leftF, rightF, leftB, rightB, pod, actu , zx, pnap;
    public CRServo zaxvat, pisun, big, zaxvatLeft, zaxvatRight, bros, kr, psk;
    public WebcamName webcam1,webcam;
    private FtcDashboard dash = FtcDashboard.getInstance();
    public BNO055IMU imu;
    // public DigitalChannel knopka;
    public TouchSensor knopka;
    public double rightbump = 0;
    public double leftbump = 0;

    public VoltageSensor sensor;

    public OpenCvWebcam phoneCam;


    @Override
    public void runOpMode() throws InterruptedException {

    }

    public void hardwareMapGetter(){
        leftF = hardwareMap.dcMotor.get("lf");
        leftB = hardwareMap.dcMotor.get("lr");
        rightF = hardwareMap.dcMotor.get("rf");
        rightB = hardwareMap.dcMotor.get("rr");
        pisun = hardwareMap.crservo.get("pis");
        pod = hardwareMap.dcMotor.get("pod");
        big = hardwareMap.crservo.get("big");
        zaxvat = hardwareMap.crservo.get("zx");
    }
}
