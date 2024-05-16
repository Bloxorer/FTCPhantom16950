package org.firstinspires.ftc.teamcode.New.Own;

import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.New.FTClib.Mechanism.Actuator;
import org.firstinspires.ftc.teamcode.New.FTClib.Mechanism.Napravlaushie;
import org.firstinspires.ftc.teamcode.New.FTClib.Mechanism.Wheels;
import org.firstinspires.ftc.teamcode.New.FTClib.Mechanism.Zaxvat;
import org.firstinspires.ftc.teamcode.New.FTClib.Mechanism.ZaxvatLR;
import org.firstinspires.ftc.vision.VisionPortal;
import org.firstinspires.ftc.vision.apriltag.AprilTagProcessor;
import org.firstinspires.ftc.vision.tfod.TfodProcessor;
import org.openftc.easyopencv.OpenCvInternalCamera;
import org.openftc.easyopencv.OpenCvWebcam;
/**
 * общий класс со всеми основными переменными
 */
@Config
@Disabled
public class Phantom extends LinearOpMode {
    public RevHubOrientationOnRobot.LogoFacingDirection logoFacingDirection =
            RevHubOrientationOnRobot.LogoFacingDirection.LEFT;
    public RevHubOrientationOnRobot.UsbFacingDirection usbFacingDirection =
            RevHubOrientationOnRobot.UsbFacingDirection.UP;
    //объявляем механизмы для последующего использования в коде
    public Wheels wheels = new Wheels();
    public Actuator actuator = new Actuator();
    public ZaxvatLR zaxvatLR = new ZaxvatLR();
    public Napravlaushie napravlaushie = new Napravlaushie();
    public Zaxvat zaxvat = new Zaxvat();



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

    @Override
    public void runOpMode() throws InterruptedException {

    }
}
