package frc.robot.jsonReaders;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JsonReader {
    public static final String baseDir = "/home/lvuser/team6880/";
    public static final String robotConfigFile = baseDir + "robots.json";
    public static final String driveSysFile = baseDir + "driveSystems.json";
    public static final String encoderSpecsFile = baseDir + "specs/encoderSpecs.json";
    public static final String attachmentsFile = baseDir + "attachments.json";
    private JSONParser parser;
    protected JSONObject rootObj;
    private File file;

    public JsonReader(String filePath){
        file = new File(filePath);
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        parser = new JSONParser();
        try{
            fileReader = new FileReader(file);
        } catch (Exception e){
            System.out.println("frc6880: JsonReader: Error loading file " + filePath);
            e.printStackTrace();
        }
        try{
            rootObj = (JSONObject) parser.parse(fileReader);
            fileReader.close();
        } catch (Exception e){
            System.out.println("frc6880: JsonReader: Error parsing fileReader for file " + filePath);
            e.printStackTrace();
        }
    }

    protected void setRootObj(JSONObject obj){
        rootObj = obj;
    }

    protected String getString(JSONObject obj, String key){
        String value = null;

        try{
            value = (String) obj.get(key);
        } catch (Exception e){
            e.printStackTrace();;
            System.out.println("frc6880:JsonReader: Error getting String for the key "+key);
        }
        return value;
    }

    protected double getDouble(JSONObject obj, String key){
        double value = 0.0;

        try{
            value = (double) obj.get(key);
        } catch (Exception e){
            e.printStackTrace();
            System.out.println("frc6880:JsonReader: Error getting double for the key "+key);
        }
        return value;
    }

    protected boolean getBoolean(JSONObject obj, String key){
        boolean value = false;
        
        try{
            value = (boolean) obj.get(key);
        } catch(Exception e){
            e.printStackTrace();
            System.out.println("frc6880:JsonReader: Error getting boolean for the key "+key);
        }
        return value;
    }

    protected int getInt(JSONObject obj, String key){
        int value = 0;

        try{
            value = (int) ((Long)obj.get(key)).intValue();
        } catch (Exception e){
            e.printStackTrace();
            System.out.println("frc6880:JsonReader: Error getting int for the key "+key);
        }
        return value;
    }

    protected JSONArray getArray(JSONObject obj, String key){
        JSONArray array = null;
        try{
            array = (JSONArray) obj.get(key);
        } catch (Exception e){
            e.printStackTrace();
            System.out.println("frc6880:JsonReader: Error getting JSONArray for the key "+key);
        }
        return array;
    }

    protected JSONObject getJSONObject(JSONObject rootObj, String key){
        JSONObject obj = null;
        try{
            obj = (JSONObject) rootObj.get(key);
        } catch (Exception e){
            e.printStackTrace();
            System.out.println("frc6880:JsonReader: Error getting JSONObject for the key "+key);
        }
        return obj;
    }

    protected Object getObject(JSONObject rootObj, String key){
        Object obj = null;
        try {
            obj = (Object) rootObj.get(key);
        } catch (Exception e){
            e.printStackTrace();
            System.out.println("frc6880:JsonReader: Error getting Object for key "+key);
        }
        return obj;
    }
}