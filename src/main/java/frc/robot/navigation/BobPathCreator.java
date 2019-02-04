//BobPathCreator.java
package frc.robot.navigation;

import com.team319.trajectory.AbstractBobPathCreator;
import com.team254.lib.trajectory.WaypointSequence.Waypoint;
import com.team319.trajectory.BobPath;
import com.team319.trajectory.SrxTranslatorConfig;
import java.util.List;
import frc.robot.Robot;
import frc.robot.jsonReaders.RobotConfigReader;

public class BobPathCreator extends AbstractBobPathCreator{
    
    Robot robot;
    private double x;
    private double y;
    private double theta;
    private double endVelocity;
    private double maxVelocity;
    private Waypoint startingPoint;
    private SrxTranslatorConfig config;

    private BobPathCreator(Robot robot, double x, double y, double theta, double endVelocity){
        this.x = x;
        this.y = y;
        this.theta = theta;
        this.endVelocity = endVelocity;
        maxVelocity = robot.navigationReader.getMaxVelocity();
        startingPoint = new Waypoint(x, y, theta, endVelocity, maxVelocity);
        config = new SrxTranslatorConfig();
        config.max_acc = robot.navigationReader.getMaxAccel();
        config.max_vel = maxVelocity;
        config.wheel_dia_inches = robot.robotConfigReader.getWheelDiameter();
		config.scale_factor = 1.0;
		config.encoder_ticks_per_rev = 4096;
		config.robotLength = robot.robotConfigReader.getRobotLength();
		config.robotWidth = robot.robotConfigReader.getRobotWidth();
		config.highGear = true;
    }
}
