package data;

import java.io.FileNotFoundException; 
import java.io.PrintWriter; 
import java.util.LinkedHashMap; 
import java.util.Map; 
import org.json.simple.JSONArray; 
import org.json.simple.JSONObject;

import application.Main; 
  
public class JsonWriter 
{ 
    public static void addPersonalInfoToJson(
    		String firstName,
    		String lastName,
    		String birthday,
    		String birthplace,
    		String currentHome,
    		String father,
    		String mother,
    		String adoptiveParent1,
    		String adoptiveParent2) throws FileNotFoundException  
    { 
        // creating JSONObject 
        JSONObject jo = new JSONObject(); 
          
        // putting data to JSONObject 
        jo.put("firstName", firstName); 
        jo.put("lastName", lastName); 
        jo.put("birthday", birthday); 
        jo.put("birthplace", birthplace); 
        jo.put("currentHome", currentHome); 
        jo.put("father", father);
        jo.put("mother", mother); 
        jo.put("adoptiveParent1", adoptiveParent1); 
        jo.put("adoptiveParent2", adoptiveParent2);
          
                
        PrintWriter pw = new PrintWriter(Main.PROJECT_PATH + "\\personalInfo.json"); 
        pw.write(jo.toJSONString()); 
        pw.flush(); 
        pw.close(); 
    } 
} 