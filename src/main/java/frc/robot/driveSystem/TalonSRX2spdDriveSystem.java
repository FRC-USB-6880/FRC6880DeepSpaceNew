package frc.robot.driveSystem;

import frc.robot.Robot;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.RemoteSensorSource;
import com.ctre.phoenix.motorcontrol.SensorTerm;
import com.ctre.phoenix.motorcontrol.StatusFrame;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class TalonSRX2spdDriveSystem extends DriveSystem implements FollowsArc{
    Robot robot;
    Encoder leftEnc;
    Encoder rightEnc;
    TalonSRX leftMotor1, leftMotor2, rightMotor1;
    VictorSPX leftMotor3, rightMotor2, rightMotor3;
    DifferentialDrive driveSys;
    boolean isMoving;
    double multiplier;
    private Gears curGear;
    public double width;

    public TalonSRX2spdDriveSystem(Robot robot){
        super(robot);
        leftEnc = new Encoder(0, 1, false, Encoder.EncodingType.k4X);
        rightEnc = new Encoder(2, 3, false, Encoder.EncodingType.k4X);
        leftMotor1 = new TalonSRX(robot.driveSysReader.getDeviceID("motorL1"));
        leftMotor2 = new TalonSRX(robot.driveSysReader.getDeviceID("motorL2"));
        leftMotor3 = new VictorSPX(robot.driveSysReader.getDeviceID("motorL3"));
        leftMotor2.follow(leftMotor1);
        leftMotor3.follow(leftMotor1);

        rightMotor1 = new TalonSRX(robot.driveSysReader.getDeviceID("motorR1"));
        rightMotor2 = new VictorSPX(robot.driveSysReader.getDeviceID("motorR2"));
        rightMotor3 = new VictorSPX(robot.driveSysReader.getDeviceID("motorR3"));
        rightMotor2.follow(rightMotor1);
        rightMotor3.follow(rightMotor1);

        curGear = Gears.LOW;
        multiplier = 1;
        width = super.getWidth();
        isMoving = false;
        System.out.println("frc6880: TalonSRX2spdDriveSystem: initialized");

        leftMotor1.setSensorPhase(false);
        rightMotor1.setSensorPhase(false);
        leftMotor1.setInverted(true);
        leftMotor2.setInverted(true);
        leftMotor3.setInverted(true);
        rightMotor1.setInverted(false);
        leftMotor1.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder);
        leftMotor1.setStatusFramePeriod(StatusFrame.Status_2_Feedback0, 5, 0);
        rightMotor1.configRemoteFeedbackFilter(leftMotor1.getDeviceID(), RemoteSensorSource.TalonSRX_SelectedSensor, 0, 0);
        rightMotor1.configRemoteFeedbackFilter(leftMotor1.getDeviceID(), RemoteSensorSource.GadgeteerPigeon_Yaw, 1, 0);

        rightMotor1.configSensorTerm(SensorTerm.Sum0, FeedbackDevice.RemoteSensor0, 0);
        rightMotor1.configSensorTerm(SensorTerm.Sum1, FeedbackDevice.QuadEncoder, 0);
        rightMotor1.configSelectedFeedbackSensor(FeedbackDevice.SensorSum, 0, 0);
        rightMotor1.configSelectedFeedbackCoefficient(0.5, 0, 0);

        rightMotor1.configSelectedFeedbackSensor(FeedbackDevice.RemoteSensor1, 1, 0);
        rightMotor1.configSelectedFeedbackCoefficient((3600.0 / 8192.0), 1, 0);
    }

    @Override
    public TalonSRX getLeft() {
        return leftMotor1; 
    }

    // This should return your right talon object
    @Override
    public TalonSRX getRight() {
        return rightMotor1; 
    }

    // This should return the current value of your sum sensor that will be configured in a future step
    @Override
    public double getDistance() {
        return rightMotor1.getSelectedSensorPosition();
    }
  
    // This should return the instance of your drive train
    @Override
    public Subsystem getRequiredSubsystem() {
        return this;
    }

    public void arcadeDrive(double speed, double direction){
        double leftSpeed = speed + direction;
        double rightSpeed = speed - direction;

        leftMotor1.set(ControlMode.PercentOutput, leftSpeed);
        rightMotor1.set(ControlMode.PercentOutput, rightSpeed);
    }

    public void tankDrive(double left, double right){
        leftMotor1.set(ControlMode.PercentOutput, left);
        rightMotor1.set(ControlMode.PercentOutput, right);
    }
}