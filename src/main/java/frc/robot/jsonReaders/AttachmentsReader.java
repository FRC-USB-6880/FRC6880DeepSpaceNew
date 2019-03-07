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
        JSONArray solenoidsArray = getArray(rootObj, "solenoidPorts");
        int[] portsArr = new int[solenoidsArray.size()];
        System.out.print("frc6880: AttachmentsReader: solenoids Array dimension1 - " + solenoidsArray.size());
        for(int i=0;i<solenoidsArray.size();i++){
            long port = (long) solenoidsArray.get(i);
            portsArr[i] = (int) port;
        }
        return portsArr;
    }

    public int[][] getDoubleSolenoidPorts(){
        JSONArray solenoidsArray = getArray(rootObj, "doubleSolenoidPorts");
        int[][] portsArr = new int[solenoidsArray.size()][((JSONArray)solenoidsArray.get(0)).size()];
        System.out.print("frc6880: AttachmentsReader: solenoids Array dimension1 - " + solenoidsArray.size());
        System.out.print("frc6880: AttachmentsReader: solenoids Array dimension2 - " + ((JSONArray)solenoidsArray.get(0)).size());
        for(int i=0;i<solenoidsArray.size();i++){
            JSONArray portJSON = (JSONArray) solenoidsArray.get(i);
            for(int j=0;j<portJSON.size();j++){
                long port = (long) portJSON.get(j);
                portsArr[i][j] = (int) port;
            }
        }
        return portsArr;
    }

    public int getMotorID(){
        return getInt(rootObj, "motorID");
    }

    public int[] getEncoderPorts(){
        JSONArray portsJSON = getArray(rootObj, "encoderPorts");
        int[] portsArr = new int[portsJSON.size()];
        for(int i=0;i<portsJSON.size();i++){
            long temp = (long)portsJSON.get(i);
            portsArr[i] = (int)temp;
        }
        return portsArr;
    }

    public boolean isEncoderReversed(){
        return getBoolean(rootObj, "isEncoderReversed");
    }

    public double getDistancePerPulse(){
        return getDouble(rootObj, "distancePerPulse");
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