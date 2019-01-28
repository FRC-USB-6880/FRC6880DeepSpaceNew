package frc.robot.driveSystem;

import frc.robot.Robot;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.Talon;

public class TalonSRX2spdDriveSystem implements DriveSystem {
    Robot robot;
    Encoder leftEnc;
    Encoder rightEnc;
    Talon leftMotor1;
    Talon leftMotor2;
    Talon leftMotor3;
    Talon rightMotor1;
    Talon rightMotor2;
    Talon rightMotor3;
    DifferentialDrive driveSys;
    SpeedControllerGroup leftMotors;
    SpeedControllerGroup rightMotors;
    boolean isMoving;
    double multiplier;
    private Gears curGear;
    private double width;


    public TalonSRX2spdDriveSystem (){
        
        leftEnc = new Encoder(0, 1, false, Encoder.EncodingType.k4X);
        rightEnc = new Encoder(2, 3, false, Encoder.EncodingType.k4X);
        leftMotor1 = new Talon(0);
        leftMotor2 = new Talon(1);
        leftMotor3 = new Talon(2);
        rightMotor1 = new Talon(3);
        rightMotor2 = new Talon(4);
        rightMotor3 = new Talon(5);
        leftMotors = new SpeedControllerGroup(leftMotor1, leftMotor2, leftMotor3);
        rightMotors = new SpeedControllerGroup(rightMotor1, rightMotor2, rightMotor3);
        driveSys = new DifferentialDrive(leftMotors, rightMotors);
        curGear = Gears.LOW;
        multiplier = 0;
        width = 10.75;
        isMoving = false;
    }

    public void tankDrive(double leftSpeed, double rightSpeed){
        driveSys.tankDrive(multiplier*leftSpeed, multiplier*rightSpeed);
    }

    public void arcadeDrive(double speed, double direction){
        driveSys.arcadeDrive(multiplier*speed, direction);
    }

    public void resetEncoders(){
        leftEnc.reset();
        rightEnc.reset();
    }

    public double getEncoderDist(){
        return (leftEnc.getDistance()+rightEnc.getDistance())/2.0;
    }

    public double getLeftEncoderDist(){
        return leftEnc.getDistance();
    }

    public double getRightEncoderDist(){
        return rightEnc.getDistance();
    }

    public void setLowSpeed(){
        
    }
    public void setHiSpeed(){

    }
    public boolean isMoving(){
        
        if(driveSys.isAlive()) return true;
        return false;
    }
    public Gears getCurGear(){
        return curGear;
    }
    public void changeMultiplier(double multiplier){
        this.multiplier = multiplier;
    }
    public double getWidth(){
        return width;
    }
}