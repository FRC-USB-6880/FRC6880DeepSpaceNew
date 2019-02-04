package frc.robot.attachments;

import edu.wpi.first.wpilibj.VictorSP;
import frc.robot.Robot;
import frc.robot.jsonReaders.AttachmentsReader;

public class CargoIntake implements Attachment{
    private Robot robot;
    private VictorSP cargoIntake;

    public CargoIntake(Robot robot, AttachmentsReader reader){
        cargoIntake = new VictorSP(reader.getMotorID());
    }

    public void engage(){
        cargoIntake.set(1.0);
    }

    public void disengage(){
        cargoIntake.set(0.0);
    }

    public void reverse(){
        cargoIntake.set(-1.0);
    }
}