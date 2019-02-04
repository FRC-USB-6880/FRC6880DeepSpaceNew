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
}