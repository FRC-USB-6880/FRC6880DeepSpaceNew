package frc.robot.jsonReaders;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class AttachmentsReader extends JsonReader{
    public AttachmentsReader(String attachmentName){
        super(JsonReader.attachmentsFile);
        JSONObject obj = getJSONObject(rootObj, attachmentName);
        setRootObj(obj);
    }

    public int[] getSolenoidPorts(){
        JSONArray portsJSON = getArray(rootObj, "solenoidPorts");
        int[] portsArr = new int[portsJSON.size()];
        for(int i=0;i<portsJSON.size();i++){
            portsArr[i] = (int) portsJSON.get(i);
        }
        return portsArr;
    }

    public int getMotorID(){
        return getInt(rootObj, "motorID");
    }

    public boolean isMotorInverted(){
        return getBoolean(rootObj, "isMotorInverted");
    }

    public double[] getMotorSpeeds(){
        JSONArray speedsJSON = getArray(rootObj, "motorSpeeds");
        double[] speedsArr = new double[speedsJSON.size()];
        for(int i=0;i<speedsJSON.size();i++){
            speedsArr[i] = (double) speedsJSON.get(i);
        }
        return speedsArr;
    }
}