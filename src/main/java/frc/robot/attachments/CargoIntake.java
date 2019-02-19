package frc.robot.attachments;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import frc.robot.Robot;

public class CargoIntake{
    private Robot robot;
    private WPI_TalonSRX motor;
    private DoubleSolenoid solenoid;

    public CargoIntake(Robot robot){
        this.robot = robot;
        motor = new WPI_TalonSRX(22);
        solenoid = new DoubleSolenoid(0, 1);
    }

    public void in(){
        motor.set(-0.3);
    }

    public void out(){
        motor.set(0.3);
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