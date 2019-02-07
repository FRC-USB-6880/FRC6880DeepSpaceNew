package frc.robot.driveSystem;

import frc.robot.Robot;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class DriveSystem extends Subsystem{

    Robot robot;
    Encoder leftEnc;
    Encoder rightEnc;
    DifferentialDrive driveSys;
    boolean isMoving;
    double multiplier;
    enum Gears {LOW, HIGH};

    private Gears curGear;
    private double width;

    public DriveSystem(Robot robot){
        this.robot = robot;
        width = robot.driveSysReader.getWidth();
    }
    
    public void tankDrive(double leftSpeed, double rightSpeed){
        driveSys.tankDrive(leftSpeed, rightSpeed);
        isMoving = true;
    }

    public void arcadeDrive(double speed, double direction){
        driveSys.arcadeDrive(speed, direction);
        isMoving = true;
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

    public void initDefaultCommand(){

    }
    
}