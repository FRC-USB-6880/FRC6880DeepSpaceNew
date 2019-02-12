package frc.robot.driveSystem;

import frc.robot.Robot;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.RemoteSensorSource;
import com.ctre.phoenix.motorcontrol.StatusFrame;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class TalonSRXDriveSystem extends DriveSystem implements FollowsArc {
    Robot robot;
    Encoder leftEnc;
    Encoder rightEnc;
    TalonSRX leftMotor1, leftMotor2;
    TalonSRX rightMotor1, rightMotor2;
    DifferentialDrive driveSys;
    boolean isMoving;
    double multiplier;
    private Gears curGear;
    public double width;


    public TalonSRXDriveSystem (Robot robot){
        super(robot);
        leftEnc = new Encoder(0, 1, false, Encoder.EncodingType.k4X);
        rightEnc = new Encoder(2, 3, false, Encoder.EncodingType.k4X);
        leftMotor1 = new TalonSRX(robot.driveSysReader.getDeviceID("motorL1"));
        leftMotor2 = new TalonSRX(robot.driveSysReader.getDeviceID("motorL2"));
        leftMotor2.follow(leftMotor1);


        rightMotor1 = new TalonSRX(robot.driveSysReader.getDeviceID("motorR1"));
        rightMotor2 = new TalonSRX(robot.driveSysReader.getDeviceID("motorR2"));
        rightMotor2.follow(rightMotor1);

        leftMotor1.setSensorPhase(false);
        rightMotor1.setSensorPhase(false);
        leftMotor1.setInverted(false);
        rightMotor1.setInverted(true);
        leftMotor1.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder);
        leftMotor1.setStatusFramePeriod(StatusFrame.Status_2_Feedback0, 5, 0);
        rightMotor1.configRemoteFeedbackFilter(leftMotor1.getDeviceID(), RemoteSensorSource.TalonSRX_SelectedSensor, 0, 0);

        curGear = Gears.LOW;
        multiplier = 1;
        width = robot.driveSysReader.getWidth();
        isMoving = false;
        
        System.out.println("frc6880: TalonSRXDriveSystem: initialized");
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
        double left = speed + direction;
        double right = speed - direction;

        leftMotor1.set(ControlMode.PercentOutput, left);
        rightMotor1.set(ControlMode.PercentOutput, right);
    }

    public void tankDrive(double left, double right){
        leftMotor1.set(ControlMode.PercentOutput, left);
        rightMotor1.set(ControlMode.PercentOutput, right);
    }

}