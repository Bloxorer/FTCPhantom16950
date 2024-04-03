package org.firstinspires.ftc.teamcode.NewEra;

import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.roadrunner.Pose2d;
import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.TouchSensor;
import com.qualcomm.robotcore.hardware.VoltageSensor;

import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.teamcode.NewEra.Roadrunner.MecanumDrive;
import org.firstinspires.ftc.vision.VisionPortal;
import org.firstinspires.ftc.vision.apriltag.AprilTagProcessor;
import org.firstinspires.ftc.vision.tfod.TfodProcessor;
import org.openftc.easyopencv.OpenCvInternalCamera;
import org.openftc.easyopencv.OpenCvWebcam;

public class Phantom extends LinearOpMode {
    public TfodProcessor tfodProcessor;
    public AprilTagProcessor aprilTagProcessor;
    public VisionPortal visionPortal;
    public DcMotorEx leftF, rightF, leftB, rightB, pod, actu , zx, pnap;
    public CRServo zaxvat, pisun, big, zaxvatLeft, zaxvatRight, bros, kr, psk;
    private FtcDashboard dash = FtcDashboard.getInstance();
    public BNO055IMU imu;
    // public DigitalChannel knopka;
    public TouchSensor knopka;
    public double rightbump = 0;
    public double leftbump = 0;

    public VoltageSensor sensor;

    public OpenCvWebcam camera;
    public OpenCvInternalCamera phonecam;
    public MecanumDrive drive = new MecanumDrive(hardwareMap, new Pose2d(0,0,0));
    public double valLeft;
    public double valRight;
    @Override
    public void runOpMode() throws InterruptedException {

    }

    public void hardwareMapGetter(){
        leftF = hardwareMap.get(DcMotorEx.class, "lf");
        leftB = hardwareMap.get(DcMotorEx.class, "lr");
        rightF = hardwareMap.get(DcMotorEx.class, "rf");
        rightB = hardwareMap.get(DcMotorEx.class, "rr");
        pisun = hardwareMap.crservo.get("pis");
        pod = hardwareMap.get(DcMotorEx.class, "pod");
        big = hardwareMap.crservo.get("big");
        zaxvat = hardwareMap.crservo.get("zx");
    }
}
