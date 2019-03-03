package frc.robot.jsonReaders;

public class RobotConfigReader extends JsonReader{
    public RobotConfigReader(String robotName){
        super(JsonReader.robotConfigFile);
        setRootObj(getJSONObject(baseObj, robotName));
    }

    public String getDriveSysName(){
        return getString(baseObj, "driveSystem");
    }

    public String getNavigationOption(){
        return getString(baseObj, "navigation");
    }

    public String getAutoPosition(){
        return getString(baseObj, "autonomousPosition");
    }

    public String getAutoOption(){
        return getString(baseObj, "autonomousOption");
    }

    public double getRobotWidth(){
        return getDouble(baseObj, "robotWidth");
    }

    public double getRobotLength(){
        return getDouble(baseObj, "robotLength");
    }
    
    public double getWheelDiameter(){
        return getDouble(baseObj, "wheelDiameter");
    }

    public boolean isTankControl(){
        return getBoolean(baseObj, "tankDriveStationConfig");
    }

    public double getMaxAcceleration(){
        return getDouble(baseObj, "maxAccel");
    }
}