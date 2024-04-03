package org.firstinspires.ftc.teamcode.old.methods;

import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.roadrunner.PoseVelocity2d;
import com.acmerobotics.roadrunner.Vector2d;
import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.hardware.bosch.JustLoggingAccelerationIntegrator;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.TouchSensor;
import com.qualcomm.robotcore.hardware.VoltageSensor;

import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.robotcore.external.navigation.Orientation;
import org.firstinspires.ftc.teamcode.old.Mechanism.Movement;
import org.firstinspires.ftc.teamcode.old.Mechanism.Motors;
import org.firstinspires.ftc.teamcode.old.Mechanism.Servos;
import org.firstinspires.ftc.teamcode.old.roadrunnernew.MecanumDrive;
import org.firstinspires.ftc.vision.VisionPortal;
import org.firstinspires.ftc.vision.apriltag.AprilTagDetection;
import org.firstinspires.ftc.vision.apriltag.AprilTagProcessor;
import org.openftc.easyopencv.OpenCvInternalCamera;
import org.openftc.easyopencv.OpenCvWebcam;

import java.util.List;



@Autonomous(name= "Methods", group="Autonomous")
public class Methods extends LinearOpMode {
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

    public Orientation angles;
    public VoltageSensor sensor;
    public double speed;
    public OpenCvWebcam phoneCam;
    int i = 0;
    int f = 0;
    int g = 0;
    int h = 0;
    public OpenCvInternalCamera phoneCam1, phoneCam2;
    Movement movement = new Movement();
    Motors motors = new Motors();
    Servos servos = new Servos();
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

    public Methods() {
    }
    public void plun(int mills, double power){
        zx.setPower(power);
        sleep(mills);
        zx.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        zx.setPower(0);
    }
    public void podem(int pos, double speed){
        pnap.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        pnap.setTargetPosition(pos);
        pnap.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        pnap.setPower(speed);
        while ((opModeIsActive() && (pnap.isBusy()))){
        }
        pnap.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        sleep(100);
        pnap.setPower(0);
    }
    //Rev2mDistanceSensor sensorTimeOfFlight = (Rev2mDistanceSensor)sensorRange;



    public void resetEncoders() {
        leftB.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        leftF.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightB.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightF.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        leftF.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightF.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        leftB.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightB.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }

    public void stop_all() {
        rightB.setPower(-0);
        leftB.setPower(0);
        rightF.setPower(-0);
        leftF.setPower(0);
    }
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
        leftF.setTargetPosition(-pos);
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
    public void robot(String name){
        switch (name){
            case "pnap":
                motors.pnap();
            case "psk":
                servos.kr();
            case "pod":
                motors.pod();
            case "act":
                motors.act();
            case "zx":
                servos.zaxvat();
            case "mzx":
                motors.zx();
            case "kr":
                servos.kr();
        }
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
    public void podAuto(int pos, double speed){
      pod.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
      pod.setTargetPosition(pos);
      pod.setMode(DcMotor.RunMode.RUN_TO_POSITION);
      pod.setPower(speed);
      while (opModeIsActive() && (pod.isBusy())){
        }
      pod.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
      pod.setPower(0);
    }
    public void movement(MecanumDrive drive){
        movement.drive_rr_speed(drive);
    }
    public void drive_psk(){
        if (gamepad2.left_stick_button && gamepad2.right_stick_button){
            h = 1;
        } else {
            h = 0;
        }
        if (h == 1){
            psk.setPower(-1);
        } else if (h == 0){
            psk.setPower(-0.3);//
        }
    }
    public void drive_rr_speed(MecanumDrive drive){
        double x =-gamepad1.left_stick_y -(gamepad1.right_stick_y * 0.4);
        double y = (-gamepad1.right_stick_x * 0.4) -gamepad1.left_stick_x;
        drive.setDrivePowers(new PoseVelocity2d(
                new Vector2d(
                        x, //- (gamepad1.right_stick_y * 0.75),
                        y //- (gamepad1.right_stick_x * 0.75)
                ),
                -gamepad1.right_trigger + gamepad1.left_trigger // + rightbump() + leftbump()
        ));
    }
    public void drive_pnap(){
        Thread tpnap = new Thread(()->{
            if (gamepad2.dpad_left){
                pnap.setPower(0.7);
            } else if (gamepad2.dpad_right) {
                pnap.setPower(-0.5);
            } else{
                pnap.setPower(0);
            }
        });
        tpnap.start();
    }


    public void pramo(){
        phoneCam.stopStreaming();
        phoneCam.closeCameraDevice();
        zx.setPower(0.05);
        nazad(1000,0.25);
        nazad(200,0.25);
        vpered(200, 0.25);
        plun(3000,0.4);
        vpered(200,0.25);
    }
    public void pravo(){
        phoneCam.stopStreaming();
        phoneCam.closeCameraDevice();
        zx.setPower(0.05);
        nazad(1000,0.25);
        razvarot(-750,0.25);
        nazad(100,0.25);
        plun(3000,0.4);
        vpered(100,0.25);
        razvarot(750,0.25);
    }
    public void levo(){
        phoneCam.stopStreaming();
        phoneCam.closeCameraDevice();
        zx.setPower(0.05);
        nazad(1000,0.25);
        razvarot(750,0.25);
        plun(3000,0.4);
        razvarot(-750,0.25);
    }
    public void  drive_tp(){
        Thread tmovement = new Thread(() -> {
            float StickX = (gamepad1.right_stick_x);
            float StickY = (gamepad1.right_stick_y);
            float pwrTrigger = (gamepad1.left_trigger);
            float pwrTrigger2 = (gamepad1.right_trigger);
            float pwrTrigger6 = (gamepad2.left_trigger);
            float pwrTrigger5 = (gamepad2.right_trigger);
            float pwrTrigger3 = (float) (gamepad2.left_trigger * 0.66);
            float pwrTrigger4 = (float) (gamepad2.right_trigger * 0.66);
            boolean Bumper_left = (gamepad1.left_bumper);
            boolean Bumper_right = (gamepad1.right_bumper);
            float Stick2X = (float) (gamepad1.left_stick_x * 0.3);
            float Stick2Y = (float) (gamepad1.left_stick_y * 0.3);
                if (StickY != 0 || StickX != 0) {
                    leftF.setPower((+StickY - StickX) + pwrTrigger);
                    leftB.setPower((+StickY + StickX) + pwrTrigger);
                    rightB.setPower((-StickY + StickX) + pwrTrigger2);
                    rightF.setPower((-StickY - StickX) - pwrTrigger2);
                } else if (Stick2Y != 0 || Stick2X != 0) {
                    leftF.setPower((+Stick2Y - Stick2X) + pwrTrigger);
                    rightB.setPower((-Stick2Y + Stick2X) + pwrTrigger2);
                    rightF.setPower((-Stick2Y - Stick2X) + pwrTrigger2);
                    leftB.setPower((+Stick2Y + Stick2X) + pwrTrigger);
                } else if (pwrTrigger != 0) {
                    leftF.setPower(0.6 * pwrTrigger);
                    rightB.setPower(0.6 * pwrTrigger);
                    rightF.setPower(0.6 * pwrTrigger);
                    leftB.setPower(0.6 * pwrTrigger);
                } else if (pwrTrigger2 != 0) {
                    leftF.setPower(-0.6 * pwrTrigger2);
                    rightB.setPower(-0.6 * pwrTrigger2);
                    rightF.setPower(-0.6 * pwrTrigger2);
                    leftB.setPower(-0.6 * pwrTrigger2);
                } else if (gamepad1.left_bumper) {
                    leftF.setPower(0.4);
                    rightB.setPower(0.4);
                    rightF.setPower(0.4);
                    leftB.setPower(0.4);
                } else if (gamepad1.right_bumper) {
                    leftF.setPower(-0.4);
                    rightB.setPower(-0.4);
                    rightF.setPower(-0.4);
                    leftB.setPower(-0.4);
                } else {
                    leftF.setPower(0);
                    rightB.setPower(0);
                    rightF.setPower(0);
                    leftB.setPower(0);
                }

        });
        tmovement.start();
    }
    public void drive_act(){
        Thread tactu = new Thread(() -> {
            if (gamepad2.dpad_up){
                actu.setPower(1);
            } else if(gamepad2.dpad_down){
                actu.setPower(-1);
            } else {
                actu.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
                actu.setPower(0.05);
            }
        });
        tactu.start();
    }
    public void drive_pod(){
        Thread tpod = new Thread(() ->{
            if(gamepad1.y){
                pod.setPower(0.5);
            } else if (gamepad1.a) {
                pod.setPower(-0.5);
            } else{
                pod.setPower(0);
            }
        });
        tpod.start();
    }
    public void drive_kr(){
        if (gamepad2.a){
            i = 1;
        } else if (gamepad2.y) {
            i = 0;
        }
        if (i == 1) {
            kr.setPower(Config.kr_pos1);
        } else if ( i == 0){
            kr.setPower(Config.kr_pos0);
        }
    }

    public void drive_zaxvat(){
        Thread tzaxvatL = new Thread(() -> {
            boolean knopk = knopka.isPressed();
            if (gamepad2.left_bumper){
                f = 1;
            } else if (gamepad2.left_trigger !=0){
                f = 0;
            } else if (knopk){
                f = 0;
            }
            if (f == 1){
                zaxvatLeft.setPower(Config.zxl_pos1);
            } else if(f == 0){
                zaxvatLeft.setPower(Config.zxl_pos0);
            }
        });
       Thread tzaxvatR = new Thread(()-> {
           if (gamepad2.right_bumper){
               g = 1;
           } else if (gamepad2.right_trigger !=0){
               g = 0;
           }
           if (g == 1){
                zaxvatRight.setPower(Config.zxr_pos1);
           } else if (g == 0){
                zaxvatRight.setPower(Config.zxr_pos0);
           }
        });
        tzaxvatL.start();
        tzaxvatR.start();
    }

    public void drive_zx(){
        Thread tzx = new Thread(() -> {
            if (gamepad2.x){
                zx.setPower(-Config.zx_zax);
            } else if (gamepad2.b) {
                zx.setPower(Config.zx_zax);
            } else {
                zx.setPower(0);
            }
        });
        tzx.start();
    }


    public void initGyro() {
        BNO055IMU.Parameters parameters = new BNO055IMU.Parameters();
        parameters.angleUnit = BNO055IMU.AngleUnit.DEGREES;
        parameters.accelUnit = BNO055IMU.AccelUnit.METERS_PERSEC_PERSEC;
        //parameters.calibrationDataFile = "GyroCal.json"; // see the calibration sample opmode
        parameters.loggingEnabled = true;
        parameters.loggingTag = "IMU";
        parameters.accelerationIntegrationAlgorithm = new JustLoggingAccelerationIntegrator();
        //
        imu = hardwareMap.get(BNO055IMU.class, "imu");
        imu.initialize(parameters);
    }


    double getBatteryVoltage() {
        double result = Double.POSITIVE_INFINITY;
        for (VoltageSensor sensor : hardwareMap.voltageSensor) {
            double voltage = sensor.getVoltage();
            if (voltage > 0) {
                result = Math.min(result, voltage);
            }
        }
        return result;

    }
    public void telemetryAprilTag() {
        List<AprilTagDetection> currentDetections = aprilTag.getDetections();
        telemetry.addData("# AprilTags Detected", currentDetections.size());
        // Step through the list of detections and display info for each one.
        for (AprilTagDetection detection : currentDetections) {
            if (detection.metadata != null) {
                telemetry.addLine(String.format("\n==== (ID %d) %s", detection.id, detection.metadata.name));
                telemetry.addLine(String.format("XYZ %6.1f %6.1f %6.1f  (inch)", detection.ftcPose.x, detection.ftcPose.y, detection.ftcPose.z));
                telemetry.addLine(String.format("PRY %6.1f %6.1f %6.1f  (deg)", detection.ftcPose.pitch, detection.ftcPose.roll, detection.ftcPose.yaw));
                telemetry.addLine(String.format("RBE %6.1f %6.1f %6.1f  (inch, deg, deg)", detection.ftcPose.range, detection.ftcPose.bearing, detection.ftcPose.elevation));
            } else {
                telemetry.addLine(String.format("\n==== (ID %d) Unknown", detection.id));
                telemetry.addLine(String.format("Center %6.0f %6.0f   (pixels)", detection.center.x, detection.center.y));
            }
        }   // end for() loop

        // Add "key" information to telemetry
        telemetry.addLine("\nkey:\nXYZ = X (Right), Y (Forward), Z (Up) dist.");
        telemetry.addLine("PRY = Pitch, Roll & Yaw (XYZ Rotation)");
        telemetry.addLine("RBE = Range, Bearing & Elevation");

    }   // end method telemetryAprilTag()


    public void runOpMode() throws InterruptedException {}




}
