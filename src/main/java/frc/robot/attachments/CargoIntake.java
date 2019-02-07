package frc.robot.attachments;

import frc.robot.jsonReaders.AttachmentsReader;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedController;
import frc.Robot.robot;


public class CargoIntake 
{
    SpeedController controller;


    public CargoIntake (Robot robot) 
    {
        this.robot = robot;
        controller = new Spark(6);
    }

    public void ballIntake()
    {
        controller.set(1);
    }

    public void in() 
    {
        power(1);
    }

    public void out()
    {
        power(-1);
    }

    public void idle()
    {
        power(0);
    }

}