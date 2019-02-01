package frc.robot.attachments;

import frc.robot.Robot;


public class CargoIntake<FRCRobot> 
{
    FRCRobot robot;

    public CargoIntake (FRCRobot robot) 
    {
        this.robot = robot;
        cargoIntake = robot.pcmObj.initializeDoubleSolenoid(2, 3);
        cargoIntake.set(Value.kOff);
        open = false;
    }

    public void grabitems() 
    {
        cargoIntake.set(DoubleSolenoid.Value.kForward);
        open = false;
    }

    
    public void releaseitems() 
    {
        cargoIntake.set(DoubleSolenoid.Value.kReverse);
        open = true;
    }

    public void idle() 
    {
        cargoIntake.set(DoubleSolenoid.Value.kOff);
    }
}