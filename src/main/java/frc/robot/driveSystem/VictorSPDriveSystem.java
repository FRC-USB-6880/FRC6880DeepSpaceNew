package frc.robot.driveSystem;

import frc.robot.Robot;

import javax.sound.sampled.AudioFormat.Encoding;

//import frc.robot.jsonReaders.DriveSysReader;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class VictorSPDriveSystem implements DriveSystem{
    
    Robot robot;
    VictorSP leftMotor1;
    VictorSP leftMotor2;
    VictorSP rightMotor1;
    VictorSP rightMotor2;
    Encoder leftEnc;
    Encoder rightEnc;
    SpeedControllerGroup leftMotors;
    SpeedControllerGroup rightMotors;
    DifferentialDrive driveSys;
    public double mult;
    public boolean isMoving;

    public VictorSPDriveSystem(Robot robot){
        this.robot = robot;
        leftMotor1 = new VictorSP(2);
        leftMotor2 = new VictorSP(3);
        rightMotor1 = new VictorSP(0);
        rightMotor2 = new VictorSP(1);
        leftEnc = new Encoder(2, 3, false, Encoder.EncodingType.k4X);
        rightEnc = new Encoder(0, 1, false, Encoder.EncodingType.k4X);
        leftMotors = new SpeedControllerGroup(leftMotor1, leftMotor2);
        rightMotors = new SpeedControllerGroup(rightMotor1, rightMotor2);
        driveSys = new DifferentialDrive(leftMotors, rightMotors);
        mult = 0;
        isMoving = false;
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

    public void setLowSpeed(){    }

    public void setHiSpeed(){    }

    public void changeMultiplier(double multiplier){
        mult = multiplier;
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
        return 10.75;
    }
}