package frc.robot.attachments;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import frc.robot.Robot;
import frc.robot.jsonReaders.AttachmentsReader;

public class HatchMechanism {
    private Solenoid puncher;
    private DoubleSolenoid plunger;
    private WPI_TalonSRX slideMotor;
    private Encoder slideEncoder;
    private Robot robot;
    private AttachmentsReader reader;
    private double SPEED_LEFT, SPEED_RIGHT;
    private boolean puncherRetracted=true;
    private boolean plungerCompressed=true;

    public HatchMechanism(Robot robot){
        this.robot = robot;
        reader = new AttachmentsReader("HatchMechanism");
        slideMotor = new WPI_TalonSRX(reader.getMotorID());
        double[] speeds = reader.getMotorSpeeds();
        SPEED_LEFT = speeds[0];
        SPEED_RIGHT = speeds[1];
        slideMotor.setInverted(reader.isMotorInverted());

        int[] encoderPorts = reader.getEncoderPorts();
        slideEncoder = new Encoder(encoderPorts[0], encoderPorts[1], reader.isEncoderReversed(), EncodingType.k4X);

        int[][] solenoidPorts = reader.getSolenoidPorts();
        puncher = new Solenoid(solenoidPorts[0][0]);
        plunger = new DoubleSolenoid(solenoidPorts[1][0], solenoidPorts[1][1]);
    }

    public void punch(){
        puncher.set(true);
        puncherRetracted=false;
    }
    public void retract(){
        puncher.set(false);
        puncherRetracted=true;
    }

    public void grab(){
        plunger.set(DoubleSolenoid.Value.kReverse);
        plungerCompressed=true;
    }
    public void release(){
        plunger.set(DoubleSolenoid.Value.kForward);
        plungerCompressed=false;
    }
    public void idlePlunger(){
        plunger.set(DoubleSolenoid.Value.kOff);
        plungerCompressed=true;
    }

    public void slide(double power){
        slideMotor.set(power);
    }
    public void slideLeft(){
        slideMotor.set(SPEED_LEFT);
    }
    public void slideRight(){
        slideMotor.set(SPEED_RIGHT);
    }

    public boolean slideToPosition(double position){
        double tolerance = (double)reader.getParameter("slideTolerance");
        double lowerBound = slideEncoder.getDistance() - tolerance;
        double upperbound = slideEncoder.getDistance() + tolerance;
        boolean isAtPosition = (lowerBound<=position) && (upperbound>=position);
        if(!isAtPosition){
            if(position<lowerBound)
                slideLeft();
            else if(position>upperbound)
                slideRight();
            return false;
        }
        slide(0.0);
        return true;
    }

    public boolean isPlungerCompressed(){
        return plungerCompressed;
    }

    public boolean isPuncherRetracted(){
        return puncherRetracted;
    }
}