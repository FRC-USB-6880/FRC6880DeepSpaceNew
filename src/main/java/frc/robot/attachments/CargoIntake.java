package frc.robot.attachments;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import frc.robot.Robot;

public class CargoIntake{
    private Robot robot;
    private Spark motor;
    private DoubleSolenoid solenoid;

    public CargoIntake(Robot robot){
        this.robot = robot;
        motor = new Spark(0);
        solenoid = new DoubleSolenoid(0, 1);
    }

    public void in(){
        motor.set(1.0);
    }

    public void out(){
        motor.set(-1.0);
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