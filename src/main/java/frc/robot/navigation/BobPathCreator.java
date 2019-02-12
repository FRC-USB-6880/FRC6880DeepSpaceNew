//BobPathCreator.java
package frc.robot.navigation;

import com.team319.trajectory.AbstractBobPathCreator;
import com.team254.lib.trajectory.WaypointSequence.Waypoint;
import com.team319.trajectory.BobPath;
import com.team319.trajectory.SrxTranslatorConfig;
import java.util.List;
import frc.robot.Robot;
import frc.robot.jsonReaders.RobotConfigReader;
import static java.util.Arrays.asList;

import java.util.ArrayList;


public class BobPathCreator extends AbstractBobPathCreator implements Navigation{
    
    Robot robot;
    private double x;
    private double y;
    private double theta;
    private double endVelocity;
    private double maxVelocity;
    private Waypoint startingPoint;
    private SrxTranslatorConfig config;

    public static void main(String[] args) {
		new BobPathCreator().generatePaths();
	}

    public BobPathCreator(){
        x = 0;
        y = 0;
        theta = 0;
        endVelocity = 0;
        maxVelocity = 12;
        startingPoint = new Waypoint(x, y, theta, endVelocity, maxVelocity);
        config = new SrxTranslatorConfig();
        config.max_acc = 8;
        config.max_vel = maxVelocity;
        config.wheel_dia_inches = 6;
		config.scale_factor = 1.0;
		config.encoder_ticks_per_rev = 4096;
		config.robotLength = 32;
		config.robotWidth = 28;
		config.highGear = true;
    }

    @Override
    protected List<BobPath> getArcs() {
		List<BobPath> paths = new ArrayList<>();
		paths.addAll(getConfigArcs());
		paths.addAll(generateTeamPaths());
        return paths;
	}

    private List<BobPath> generateTeamPaths() {
        // Create a path with the name of "Example", this will generate a file named ExampleArc
        // BobPath exampleArc = new BobPath(config, "Example");
        // // Set the first point to the starating point, this be done with any of the addWaypoint methods
        // // positive X is forward, positive Y is left, units are in feet and degrees
        // exampleArc.addWaypoint(startingPoint);
        // // Add the next point that 3 ft forward, and doesn't turn, it also has a max speed of 5 FPS, 
        // // it will arrive at this location going 2 FPS
        // exampleArc.addWaypointRelative(2, 0, 89.99, 0, 5);
        // // Add the next point to be an additional 5 feet forward and 5 feet to the left with max speed of 2 FPS,
        // // it  will arrive at this locaton going 0 FPS 
        // exampleArc.addWaypointRelative(0, 2, 89.99, 0, 5);
        // exampleArc.addWaypointRelative(2, 0, 89.99, 0, 5);
        // exampleArc.addWaypointRelative(0, 2, 89.99, 0, 5);

        // BobPath square = new BobPath(config, "Square");
        // square.addWaypoint(startingPoint);
        // square.addWaypointRelative(15,0,270,2,12);
        // square.addWaypointRelative(0,1,180,2,12);
        // square.addWaypointRelative(1,0,90,2,12);
        // square.addWaypointRelative(0,1,0,2,12);
        // square.addWaypointRelative(1,0,0,2,12);
        // square.addWaypointRelative(2, 0, 90, 2, 12);
        // square.addWaypointRelative(0, 2, 90, 2, 12);
        // square.addWaypointRelative(2, 0, 90, 2, 12);

        // BobPath flower = new BobPath(config, "Flower");
        // flower.addWaypoint(10, 10, 0, 0, 0);
        // flower.addWaypoint(12, 12, 45, 2, 2);
        // flower.addWaypoint(14, 14, 90, 2, 2);
        // flower.addWaypoint(12, 16, 135, 2, 2);
        // flower.addWaypoint(10, 18, 180, 2, 2);
        // flower.addWaypoint(8, 16, 225, 2, 2);
        // flower.addWaypoint(6, 14, 270, 2, 2);
        // flower.addWaypoint(8, 12, 315, 2, 2);
        // flower.addWaypoint(10, 10, 0, 0, 2);

        // BobPath imageCalibrator = new BobPath(config, "ImageCalibrator");
        // imageCalibrator.addWaypoint(0, 10, 0, 0, 0);
        // imageCalibrator.addWaypoint(27, 10, 0, 0, 10);
        
        BobPath r2rRocket = new BobPath(config, "R2RRocket"); //right loading station to right rocket
        r2rRocket.addWaypoint(new Waypoint(2, 13.5, 0, 0, 12));
        // r2rRocket.addWaypoint(10, 3.79166, 90, 0, 12);

        return asList(r2rRocket); // return asList(path1, path2, path3, ...);
        // return asList(square);
    }

    private List<BobPath> getConfigArcs() {
		BobPath distanceScaling = new BobPath(config, "DistanceScaling");
		distanceScaling.addWaypoint(new Waypoint(2, 13.5, 0, 0, 0));
		distanceScaling.addWaypointRelative(3, 0, 0, 0, 3);

		BobPath turnScaling = new BobPath(config, "TurnScaling");
		turnScaling.addWaypoint(new Waypoint(2, 13.5, 0, 0, 0));
		turnScaling.addWaypointRelative(3, 3, 89.99, 0, 3);


		BobPath speedTesting = new BobPath(config, "SpeedTesting");
		speedTesting.addWaypoint(new Waypoint(2, 13.5, 0, 0, 0));
		speedTesting.addWaypointRelative(3, 3, 89.99, 1, 3);
		speedTesting.addWaypointRelative(-3, 3, 89.99, 0, 1);

		return asList(distanceScaling, turnScaling, speedTesting);
	}
    public String returnNavigationType(){
        return "BobTrajectory";
    }
}
