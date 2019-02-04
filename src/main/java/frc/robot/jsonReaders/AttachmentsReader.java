package frc.robot.jsonReaders;

import org.json.simple.JSONObject;

public class AttachmentsReader extends JsonReader{

    public AttachmentsReader(String attachmentName){
        super(JsonReader.attachmentsFile);

        JSONObject attachmentObj = getJSONObject(baseObj, attachmentName);
        setRootObj(attachmentObj);
    }

    public int getMotorID(){
        return getInt(baseObj, "motorID");
    }
}