package frc.robot.jsonReaders;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class NavigationReader extends JsonReader{
    String navigationType;

    public NavigationReader(String navigationType){
        super(JsonReader.driveSysFile);
        JSONObject navigationObj = getJSONObject(rootObj, navigationType);
        setRootObj(navigationObj);
        this.navigationType = navigationType;
    }

    public double getMaxVelocity(){
        return getDouble(rootObj, "maxVel");
    }

    public double getMaxAccel(){
        return getDouble(rootObj, "maxAccel");
    }

}