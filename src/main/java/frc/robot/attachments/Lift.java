package frc.robot.attachments;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import frc.robot.Robot;

public class Lift {
    private Robot robot;
    private WPI_TalonSRX liftMotor;

    public Lift(Robot robot){
        this.robot = robot;
        liftMotor = new WPI_TalonSRX(9);
        liftMotor.setInverted(true);
    }

    public void move(double power){
        liftMotor.set(power);
    }

    public int getEncoderCounts(){
        return liftMotor.getSelectedSensorPosition();
    }
}