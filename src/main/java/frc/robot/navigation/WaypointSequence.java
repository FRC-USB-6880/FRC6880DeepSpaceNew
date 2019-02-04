//WaypointSequence.java created by FRC 254 in 2014
//modifications made by FRC 6880 in 2019

package frc.robot.navigation;

public class WaypointSequence {

	public static class Waypoint {

		public Waypoint(double x, double y, double theta, double endVelocity, double maxVelocity) {
			this.x = x;
			this.y = y;
			this.theta = theta;
			this.endVelocity = endVelocity;
			this.maxVelocity = maxVelocity;
		}

		public Waypoint(Waypoint tocopy) {
			this.x = tocopy.x;
			this.y = tocopy.y;
			this.theta = tocopy.theta;
			this.endVelocity = tocopy.endVelocity;
			this.maxVelocity = tocopy.maxVelocity;
		}

		public double x;
		public double y;
		public double theta;
		public double endVelocity;
		public double maxVelocity;
	}

	Waypoint[] waypoints;
	int numWaypoints;

	public WaypointSequence(int max_size) {
		waypoints = new Waypoint[max_size];
	}

	public void addWaypoint(Waypoint w) {
		if (numWaypoints < waypoints.length) {
			waypoints[numWaypoints] = w;
			++numWaypoints;
		}
	}

	public int getNumWaypoints() {
		return numWaypoints;
	}

	public Waypoint getWaypoint(int index) {
		if (index >= 0 && index < getNumWaypoints()) {
			return waypoints[index];
		} else {
			return null;
		}
	}

	public WaypointSequence invertY() {
		WaypointSequence inverted = new WaypointSequence(waypoints.length);
		inverted.numWaypoints = numWaypoints;
		double angle = 0;
		for (int i = 0; i < numWaypoints; ++i) {
			inverted.waypoints[i] = waypoints[i];
			inverted.waypoints[i].y *= -1;
			angle = 2 * Math.PI - inverted.waypoints[i].theta;
			while (angle >= 360.0) {
				angle -= 360.0;
			}
			while (angle < 0.0) {
				angle += 360.0;
			}	
		}
		return inverted;
	}
	
	public WaypointSequence reversed() {
		WaypointSequence inverted = new WaypointSequence(waypoints.length);
		for(int i = waypoints.length; i > 0; i--)
		{
			if (waypoints[i-1] != null) {
				inverted.addWaypoint(waypoints[i-1]);
			}
		}
		return inverted;
	}
}