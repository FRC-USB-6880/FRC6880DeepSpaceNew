package frc.robot.driveSystem;

import frc.robot.Robot;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class TalonSRX2spdDriveSystem implements DriveSystem {
    Robot robot;
    Encoder leftEnc;
    Encoder rightEnc;
    WPI_TalonSRX leftMotor1, leftMotor2, rightMotor1;
    WPI_VictorSPX leftMotor3, rightMotor2;
    WPI_TalonSRX rightMotor3;
    DifferentialDrive driveSys;
    boolean isMoving;
    double speedMultiplier, directionMultiplier;
    private Gears curGear;
    public double width;
    private DoubleSolenoid solenoid;

    public TalonSRX2spdDriveSystem (Robot robot){
        
        leftEnc = new Encoder(0, 1, false, Encoder.EncodingType.k4X);
        rightEnc = new Encoder(2, 3, false, Encoder.EncodingType.k4X);
        leftMotor1 = new WPI_TalonSRX(robot.driveSysReader.getDeviceID("motorL1"));
        leftMotor2 = new WPI_TalonSRX(robot.driveSysReader.getDeviceID("motorL2"));
        leftMotor3 = new WPI_VictorSPX(robot.driveSysReader.getDeviceID("motorL3"));
        leftMotor2.follow(leftMotor1);
        leftMotor3.follow(leftMotor1);


        rightMotor1 = new WPI_TalonSRX(robot.driveSysReader.getDeviceID("motorR1"));
        rightMotor2 = new WPI_VictorSPX(robot.driveSysReader.getDeviceID("motorR2"));
        rightMotor3 = new WPI_TalonSRX(robot.driveSysReader.getDeviceID("motorR3"));
        rightMotor2.follow(rightMotor1);
        rightMotor3.follow(rightMotor1);

        driveSys = new DifferentialDrive(leftMotor1, rightMotor1);
        curGear = Gears.LOW;
        speedMultiplier = robot.driveSysReader.getSpeedMultiplier();
        directionMultiplier = robot.driveSysReader.getDirectionMultiplier();
        width = robot.driveSysReader.getWidth();
        isMoving = false;

        solenoid = new DoubleSolenoid(5, 4);

        System.out.println("frc6880: TalonSRX2spdDriveSystem: initialized");
    }

    public void tankDrive(double leftSpeed, double rightSpeed){
        driveSys.tankDrive(speedMultiplier*leftSpeed, speedMultiplier*rightSpeed);
    }

    public void arcadeDrive(double speed, double direction){
        driveSys.arcadeDrive(speedMultiplier*speed, directionMultiplier*direction);
    }

    public void resetEncoders(){
        leftEnc.reset();
        rightEnc.reset();
    }

    public void reverse(){
        speedMultiplier *= -1;
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

    public void setLowGear(){
        solenoid.set(DoubleSolenoid.Value.kReverse);
    }
    public void setHighGear(){
        solenoid.set(DoubleSolenoid.Value.kForward);
    }

    public void brake(){
        leftMotor1.setNeutralMode(NeutralMode.Brake);
        leftMotor2.setNeutralMode(NeutralMode.Brake);
        leftMotor3.setNeutralMode(NeutralMode.Brake);

        rightMotor1.setNeutralMode(NeutralMode.Brake);
        rightMotor2.setNeutralMode(NeutralMode.Brake);
        rightMotor3.setNeutralMode(NeutralMode.Brake);
    }

    public void coast(){
        leftMotor1.setNeutralMode(NeutralMode.Coast);
        leftMotor2.setNeutralMode(NeutralMode.Coast);
        leftMotor3.setNeutralMode(NeutralMode.Coast);

        rightMotor1.setNeutralMode(NeutralMode.Coast);
        rightMotor2.setNeutralMode(NeutralMode.Coast);
        rightMotor3.setNeutralMode(NeutralMode.Coast);
    }
    public boolean isMoving(){
        
        if(driveSys.isAlive()) return true;
        return false;
    }
    public Gears getCurGear(){
        return curGear;
    }
    public void setSpeedMultiplier(double multiplier){
        this.speedMultiplier = multiplier;
    }
    public void setDirectionMultiplier(double multiplier){
        this.directionMultiplier = multiplier;
    }
    public double getWidth(){
        return width;
    }

    public double getSpeedMultiplier(){
        return speedMultiplier;
    }
}