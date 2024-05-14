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
    double[] coeffs;
    double[] ffCoeffs;
    private final ElapsedTime runtime = new ElapsedTime();
    private MotorEx leftF, rightF, leftB, rightB;
    private MotorGroup movement = new MotorGroup(leftF, leftB, rightB, rightF);
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


    public void vperedNEW(int pos, double speed) {
        movement.stopAndResetEncoder();
        movement.setTargetPosition(pos);
        movement.set(speed);
        while(opModeIsActive() && !movement.atTargetPosition()){
            telemetry.addData("Position", movement.getPositions());
            telemetry.update();
        }
        movement.stopMotor();
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
    private void telemetry(){
        coeffs = movement.getVeloCoefficients();
        double kP = coeffs[0];
        double kI = coeffs[1];
        double kD = coeffs[2];
        ffCoeffs = movement.getFeedforwardCoefficients();
        double kS = ffCoeffs[0];
        double kV = ffCoeffs[1];
        double kA = ffCoeffs[2];

    }
    @Override
    public void runOpMode() throws InterruptedException {

        runtime.reset();
        waitForStart();
        while(opModeIsActive()){

        }
    }
}
