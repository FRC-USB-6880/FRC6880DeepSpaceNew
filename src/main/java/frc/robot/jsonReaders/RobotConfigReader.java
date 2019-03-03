package frc.robot.jsonReaders;

import org.json.simple.JSONArray;

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

    public String[] getAttachments(){
        JSONArray jsonArr = getArray(rootObj, "attachments");
        String[] arr = new String[jsonArr.size()];
        for(int i=0;i<jsonArr.size();i++){
            String val = (String) jsonArr.get(i);
            arr[i] = val;
        }

        return arr;
    }
}