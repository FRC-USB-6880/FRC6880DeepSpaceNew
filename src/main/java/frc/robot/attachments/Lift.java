package frc.robot.attachments;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import frc.robot.Robot;
import frc.robot.jsonReaders.AttachmentsReader;

public class Lift {
    private Robot robot;
    private WPI_TalonSRX liftMotor;
    private AttachmentsReader reader;

    public Lift(Robot robot){
        this.robot = robot;
        reader = new AttachmentsReader("Lift");
        liftMotor = new WPI_TalonSRX(reader.getMotorID());
        liftMotor.setInverted(reader.isMotorInverted());
    }

    public void move(double power){
        liftMotor.set(power);
    }

    public int getEncoderCounts(){
        return liftMotor.getSelectedSensorPosition();
    }
}