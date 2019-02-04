package frc.robot.driveSystem;

import frc.robot.Robot;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class VictorSPDriveSystem implements DriveSystem{
    
    Robot robot;
    VictorSP leftMotor1, leftMotor2;
    VictorSP rightMotor1, rightMotor2;
    Encoder leftEnc;
    Encoder rightEnc;
    SpeedControllerGroup leftMotors;
    SpeedControllerGroup rightMotors;
    DifferentialDrive driveSys;
    public double multiplier;
    public boolean isMoving;
    public double width;

    public VictorSPDriveSystem(Robot robot){
        this.robot = robot;
        leftMotor1 = new VictorSP(robot.driveSysReader.getDeviceID("motorL1"));
        leftMotor2 = new VictorSP(robot.driveSysReader.getDeviceID("motorL2"));
        rightMotor1 = new VictorSP(robot.driveSysReader.getDeviceID("motorR1"));
        rightMotor2 = new VictorSP(robot.driveSysReader.getDeviceID("motorR2"));
        leftEnc = new Encoder(2, 3, false, Encoder.EncodingType.k4X);
        rightEnc = new Encoder(0, 1, false, Encoder.EncodingType.k4X);
        leftMotors = new SpeedControllerGroup(leftMotor1, leftMotor2);
        rightMotors = new SpeedControllerGroup(rightMotor1, rightMotor2);
        driveSys = new DifferentialDrive(leftMotors, rightMotors);
        multiplier = 0;
        isMoving = false;
        width = robot.driveSysReader.getWidth();

        System.out.println("frc6880: VictorSPDriveSystem: initialized");
    }

    @Override
    public void tankDrive(double leftSpeed, double rightSpeed){
        driveSys.tankDrive(leftSpeed, rightSpeed);
        isMoving = true;
    }

    @Override
    public void arcadeDrive(double speed, double direction){
        driveSys.arcadeDrive(speed, direction);
        isMoving = true;
    }

    public void resetEncoders(){
        leftEnc.reset();
        rightEnc.reset();
    }

    public double getEncoderDist(){
        return (leftEnc.getDistance() + rightEnc.getDistance())/2.0;
    }

    public double getLeftEncoderDist(){
        return leftEnc.getDistance();
    }

    public double getRightEncoderDist(){
        return rightEnc.getDistance();
    }
    
    public void setLowSpeed(){    }

    public void setHiSpeed(){    }

    public void changeMultiplier(double multiplier){
        this.multiplier = multiplier;
    }

    public boolean isMoving()
    {
        if(driveSys.isAlive()) return true;
        return false;
    }

    public Gears getCurGear()
    {
        return Gears.LOW;
    }

    public double getWidth()
    {
        return width;
    }
}