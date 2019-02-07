package frc.robot.driveSystem;

import edu.wpi.first.wpilibj.command.Subsystem;

public class DriveSystem extends Subsystem{
    enum Gears {LOW, HIGH};
    public void tankDrive(double leftSpeed, double rightSpeed){}
    public void arcadeDrive(double speed, double direction){}
    public void resetEncoders(){}
    public double getEncoderDist(){}
    public double getLeftEncoderDist(){}
    public double getRightEncoderDist(){}
    public void setLowSpeed(){}
    public void setHiSpeed(){}
    public boolean isMoving(){}
    public Gears getCurGear(){}
    public void changeMultiplier(double multiplier){}
    public double getWidth(){}
    public  
}