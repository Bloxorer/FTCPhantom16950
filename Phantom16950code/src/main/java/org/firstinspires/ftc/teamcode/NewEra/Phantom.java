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
    // Объявляем общие переменные
    public TfodProcessor tfod;
    public int f,g,i,h;
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
    public MecanumDrive drive;
    public double valLeft;
    public double valRight;
    @Override
    public void runOpMode() throws InterruptedException {

    }
    // присваеваем моторам имена
    public void hardwareMapGetter(){
        drive = new MecanumDrive(hardwareMap, new Pose2d(0,0,0));
        zaxvatLeft = hardwareMap.crservo.get("zxl");
        zaxvatRight = hardwareMap.crservo.get("zxr");
        leftB = hardwareMap.get(DcMotorEx.class, "lr");
        leftF = hardwareMap.get(DcMotorEx.class, "lf");
        rightB = hardwareMap.get(DcMotorEx.class, "rr");
        rightF = hardwareMap.get(DcMotorEx.class, "rf");
        pod = hardwareMap.get(DcMotorEx.class, "pod");
        actu = hardwareMap.get(DcMotorEx.class, "act");
        zx = hardwareMap.get(DcMotorEx.class, "zx");
        pnap = hardwareMap.get(DcMotorEx.class, "pnap");
        kr = hardwareMap.crservo.get("kr");
        psk = hardwareMap.crservo.get("psk");
    }
}
