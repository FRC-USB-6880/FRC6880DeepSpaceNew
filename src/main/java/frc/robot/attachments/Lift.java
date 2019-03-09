package frc.robot.attachments;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import frc.robot.Robot;
import frc.robot.jsonReaders.AttachmentsReader;

public class Lift {
    private Robot robot;
    private WPI_TalonSRX liftMotor;
    private AttachmentsReader reader;
    private double[] rangePoints;
    private double[] speedMultipliers = {0.0, 0.8};

    public Lift(Robot robot){
        this.robot = robot;
        reader = new AttachmentsReader("Lift");
        liftMotor = new WPI_TalonSRX(reader.getMotorID());
        liftMotor.setInverted(reader.isMotorInverted());
        

        double[] rangePointsObj = {500, 1000};
        rangePoints = new double[rangePointsObj.length];
        // for(int i=0;i<rangePointsObj.length;i++)
        //     rangePoints[i] = (double)rangePointsObj[i];
    }

    public void move(double power){
        liftMotor.set(0.5*power);
    }

    public boolean isInLowRange(){
        double position = getEncoderCounts();
        if(position<rangePoints[0])
            return true;
        return false;
    }
    public boolean isInMidRange(){
        double position = getEncoderCounts();
        if(position>rangePoints[0] && position<rangePoints[1])
            return true;
        return false;
    }
    public boolean isInHighRange(){
        double position = getEncoderCounts();
        if(position>rangePoints[1])
            return true;
        return false;
    }

    public int getEncoderCounts(){
        return liftMotor.getSelectedSensorPosition();
    }
}