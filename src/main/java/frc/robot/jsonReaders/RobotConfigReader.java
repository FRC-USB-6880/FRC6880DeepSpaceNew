package frc.robot.jsonReaders;

public class RobotConfigReader extends JsonReader{
    public RobotConfigReader(String robotName){
        super(JsonReader.robotConfigFile);
        setRootObj(getJSONObject(rootObj, robotName));
    }

    public String getDriveSysName(){
        return getString(rootObj, "driveSystem");
    }

    public String getNavigationOption(){
        return getString(rootObj, "navigation");
    }

    public String getAutoPosition(){
        return getString(rootObj, "autonomousPosition");
    }

    public String getAutoOption(){
        return getString(rootObj, "autonomousOption");
    }

    public double getRobotWidth(){
        return getDouble(rootObj, "robotWidth");
    }

    public boolean isTankControl(){
        return getBoolean(rootObj, "tankDriveStationConfig");
    }
}