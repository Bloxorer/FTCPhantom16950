package org.firstinspires.ftc.teamcode.NewEra;

import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.dashboard.config.Config;
import com.acmerobotics.roadrunner.Pose2d;
import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.TouchSensor;
import com.qualcomm.robotcore.hardware.VoltageSensor;

import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.teamcode.NewEra.Mechanism.Actuator;
import org.firstinspires.ftc.teamcode.NewEra.Mechanism.Wheels;
import org.firstinspires.ftc.teamcode.NewEra.Mechanism.ZaxvatLR;
import org.firstinspires.ftc.teamcode.NewEra.Roadrunner.MecanumDrive;
import org.firstinspires.ftc.vision.VisionPortal;
import org.firstinspires.ftc.vision.apriltag.AprilTagProcessor;
import org.firstinspires.ftc.vision.tfod.TfodProcessor;
import org.openftc.easyopencv.OpenCvInternalCamera;
import org.openftc.easyopencv.OpenCvWebcam;
@Config
@Disabled
public class Phantom extends LinearOpMode {
    //объявляем механизмы для последующего использования в коде
    Wheels wheels = new Wheels();
    Actuator actuator = new Actuator();
    ZaxvatLR zaxvatLR = new ZaxvatLR();


    //объявляем процессоры камеры и сами камеры
    public TfodProcessor tfod;
    public AprilTagProcessor aprilTagProcessor;
    public VisionPortal visionPortal;
    public OpenCvWebcam camera;
    public OpenCvInternalCamera phonecam;
    // объявляем перменные со значениями с камер
    public double valLeft;
    public double valRight;


    // числовые значения
    public int f,g,i,h;


    // перменные для использования в дэшборде
    private FtcDashboard dash = FtcDashboard.getInstance();

    public DcMotorEx pod, actu , zx, pnap;
    public CRServo zaxvatLeft, zaxvatRight, kr, psk;

    public BNO055IMU imu;
    // public DigitalChannel knopka;
    public TouchSensor knopka;
    public double rightbump = 0;
    public double leftbump = 0;

    public VoltageSensor sensor;





    @Override
    public void runOpMode() throws InterruptedException {

    }
    // инициализируем все механизмы
    public void hardwareMapGetter(){
        wheels.initWheels();
        actuator.initActu();
        zaxvatLR.initZaxvatLR();
        zx = hardwareMap.get(DcMotorEx.class, "zx");
        pnap = hardwareMap.get(DcMotorEx.class, "pnap");

        psk = hardwareMap.crservo.get("psk");
    }
}
