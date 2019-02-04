package frc.robot.jsonReaders;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

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

    public boolean isTankControl(){
        return getBoolean(baseObj, "tankDriveStationConfig");
    }

    public String[] getAttachments(){
        JSONArray attachmentsJson = getArray(baseObj, "attachments");
        String[] attachments = new String[attachmentsJson.size()];
        for(int i=0;i<attachmentsJson.size();i++){
            attachments[i] = (String) attachmentsJson.get(i);
        }
        return attachments;
    }
}