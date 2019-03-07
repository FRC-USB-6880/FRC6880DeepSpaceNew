package frc.robot.attachments;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import frc.robot.Robot;
import frc.robot.jsonReaders.AttachmentsReader;

public class CargoIntake{
    private Robot robot;
    private WPI_TalonSRX motor;
    private DoubleSolenoid solenoid;
    private AttachmentsReader reader;
    private double SPEED_IN, SPEED_OUT;

    public CargoIntake(Robot robot){
        this.robot = robot;
        reader = new AttachmentsReader("CargoIntake");
        motor = new WPI_TalonSRX(reader.getMotorID());
        motor.setInverted(reader.isMotorInverted());
        int[][] solenoidPorts = reader.getDoubleSolenoidPorts();
        solenoid = new DoubleSolenoid(solenoidPorts[0][0], solenoidPorts[0][1]);

        double[] speeds = reader.getMotorSpeeds();
        SPEED_IN = speeds[0];
        SPEED_OUT = speeds[1];
    }

    public void in(){
        motor.set(SPEED_IN);
    }

    public void out(){
        motor.set(SPEED_OUT);
    }

    public void idleMotor(){
        motor.set(0.0);
    }

    public void down(){
        solenoid.set(Value.kForward);
    }

    public void up(){
        solenoid.set(Value.kReverse);
    }

    public void idleLinkage(){
        solenoid.set(Value.kOff);
    }
}