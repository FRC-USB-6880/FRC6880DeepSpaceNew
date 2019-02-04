package frc.robot.navigation;

import frc.robot.Robot;

public class CoordSys {
    Robot robot;
    double[] pos = new double[3];
    double[] prevPos = new double[3];
    public CoordSys(Robot robot, double x, double y, double angle) {
        this.robot = robot;
        prevPos[0] = pos[0] = x;
        prevPos[1] = pos[1] = y;
        prevPos[2] = pos[2] = angle;
    }

    public void updatePos(){
        double distance = robot.driveSys.getEncoderDist();
        double distanceLeft = robot.driveSys.getLeftEncoderDist();
        double distanceRight = robot.driveSys.getRightEncoderDist();   
        
        pos[2] = prevPos[2] + ((distanceRight - distanceLeft) / robot.driveSys.getWidth());
        pos[0] = prevPos[0] + Math.cos(prevPos[2]);
        pos[1] = prevPos[1] + distance * Math.sin(prevPos[2]);

        for(int i = 0; i < 3; i++) {
            prevPos[i] = pos[i];
        }
        robot.driveSys.resetEncoders();
    }

    public double getX() {
        return pos[0];
    }

    public double getY() {
        return pos[1];
    }
    
    public double getAngle() {
        return pos[2];
    }
}