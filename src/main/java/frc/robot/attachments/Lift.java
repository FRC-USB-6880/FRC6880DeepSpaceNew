package frc.robot.attachments;

import java.util.ArrayList;

import frc.robot.jsonReaders.AttachmentsReader;


public class Lift extends Attachment {

    public double curPos;
    public long targetPos;
    public Lift(ArrayList<Object[]> params){
        super(params);
        attachmentName = "Lift";
        curPos = 0;
    }

    
    public double getTargetPos()
    {
        return targetPos;
    }


    public double getCurPos() {
        return curPos;
    }

    public void move(double power) {
        if (targetPos < getCurPos()) {
            move(-power);
        } else if (targetPos > getCurPos()) {   
            move(power);
        }   
            
    }

    public void moveToHeight2(double power, double targetHeight){
        if(targetHeight < getCurPos()) {
            move(-power);
        } else if (targetHeight > getCurPos()) {
            move(power);
        }
    }
    public void moveToHeight3(double power){
        if (targetPos < getCurPos()) {
            move(-power);
        } else if (targetPos > getCurPos()) {
            move(power);
        }
    }
}