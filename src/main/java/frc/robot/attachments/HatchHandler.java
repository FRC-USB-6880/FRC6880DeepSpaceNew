package main.java.frc.robot.attachments;

import frc.robot.jsonReaders.AttachmentsReader;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedController;
import frc.robot.Robot;


public class HatchHandler<FRCRobot> 
{
    FRCRobot robot;
    SpeedController controller;


    public HatchHandler (FRCRobot robot) 
    {
        this.robot = robot;
        controller = new Spark(6);
    }

    public void clampOn()
    {
        power(1);
    }

    public void clampOff()
    {
        power(-1);
    }

    public void idle()
    {
        power(0);
    }
}
