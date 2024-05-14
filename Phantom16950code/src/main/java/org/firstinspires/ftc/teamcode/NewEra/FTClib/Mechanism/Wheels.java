package org.firstinspires.ftc.teamcode.NewEra.FTClib.Mechanism;



import com.acmerobotics.roadrunner.PoseVelocity2d;
import com.acmerobotics.roadrunner.Vector2d;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.arcrobotics.ftclib.hardware.motors.MotorEx;
import com.arcrobotics.ftclib.hardware.motors.MotorGroup;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.NewEra.Roadrunner.MecanumDrive;

@Autonomous(name = "move tester", group = "TEST")
public class Wheels extends LinearOpMode {
    int posWheel;
    double[] coeffs;
    double[] ffCoeffs;
    double kP, kI, kD, kS, kA, kV;

    private final ElapsedTime runtime = new ElapsedTime();
    private MotorEx leftF, rightF, leftB, rightB;
    private MotorGroup movement = new MotorGroup(leftF, leftB, rightB, rightF);

    /**
     * инициализация всех моторов колесной базы
     */
    public void initWheels(){
        leftB = new MotorEx(hardwareMap, "lr", Motor.GoBILDA.RPM_312);
        leftF = new MotorEx(hardwareMap, "lf", Motor.GoBILDA.RPM_312);
        rightB = new MotorEx(hardwareMap, "rr", Motor.GoBILDA.RPM_312);
        rightF = new MotorEx(hardwareMap, "rf", Motor.GoBILDA.RPM_312);
        rightB.setInverted(true);
        rightF.setInverted(true);
        movement.setRunMode(Motor.RunMode.VelocityControl);
        movement.setZeroPowerBehavior(Motor.ZeroPowerBehavior.BRAKE);
    }

    /**
     * Передвижение вперед используя FTCLIB
     * @param pos расстояние, которое проедет робот
     * @param speed скорость вращения моторов
     */
    public void vperedNEW(int pos, double speed) {
        posWheel = pos;
        movement.stopAndResetEncoder();
        movement.setDistancePerPulse(0);
        movement.setTargetDistance(pos);
        movement.set(speed);
        while(opModeIsActive() && !movement.atTargetPosition()){
            telemetry.addData("Position", movement.getPositions());
            telemetry.update();
        }
        movement.stopMotor();
    }

    /**
     * Передвижение в телеопе при помощи роадраннера
     * @param drive объект класса MecanumDrive
     */
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

    /**
     * Телеметрия для настройки колес
     */
    private void telemetry(){
        coeffs = movement.getVeloCoefficients();
        ffCoeffs = movement.getFeedforwardCoefficients();
        kP = coeffs[0];
        kI = coeffs[1];
        kD = coeffs[2];
        kS = ffCoeffs[0];
        kV = ffCoeffs[1];
        kA = ffCoeffs[2];
        Thread thread = new Thread(() -> {
            telemetry.addData("Необходимая позиция", posWheel);
            telemetry.addData("Текущая позиция", movement.getPositions());
            telemetry.update();
        });
        thread.start();
    }
    @Override
    public void runOpMode() throws InterruptedException {
        runtime.reset();
        waitForStart();
        while(opModeIsActive()){
            telemetry();
            vperedNEW(100, 0.5);
            vperedNEW(-100, 0.5);
        }
    }
}
