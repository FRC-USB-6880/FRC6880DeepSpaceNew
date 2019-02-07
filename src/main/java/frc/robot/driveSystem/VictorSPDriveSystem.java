package frc.robot.driveSystem;

import frc.robot.Robot;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class VictorSPDriveSystem extends DriveSystem{
    
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
        super(robot);
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
}