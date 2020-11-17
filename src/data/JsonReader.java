package data;

import java.io.FileReader; 
import java.util.Iterator; 
import java.util.Map; 
  
import org.json.simple.JSONArray; 
import org.json.simple.JSONObject; 
import org.json.simple.parser.*;

import application.Main;
import application.PersonalInfo; 
  
public class JsonReader  
{ 
    public static void fillPersonalInfoClassFromJson() throws Exception  
    { 
        // parsing file "PersonalInfo.json" 
        Object obj = new JSONParser().parse(new FileReader(Main.PROJECT_PATH + "\\personalInfo.json")); 
          
        JSONObject jo = (JSONObject) obj; 

        String firstName = (String) jo.get("firstName"); 
        String lastName = (String) jo.get("lastName"); 
        String birthplace = (String) jo.get("birthplace");
        String birthday = (String) jo.get("birthday");
        String currentHome = (String) jo.get("currentHome");
        String father = (String) jo.get("father");
        String mother = (String) jo.get("mother");
        String adoptiveParent1 = (String) jo.get("adoptiveParent1");
        String adoptiveParent2 = (String) jo.get("adoptiveParent2");
        //Test 
        //System.out.println(firstName); 
        //System.out.println(lastName); 
          
        PersonalInfo.setFIRST_NAME(firstName); 
        PersonalInfo.setLAST_NAME(lastName); 
        PersonalInfo.setBIRTHPLACE(birthplace);
        PersonalInfo.setBIRTHDAY(birthday);
        PersonalInfo.setCURRENT_HOME(currentHome);
        PersonalInfo.setFATHER(father);
        PersonalInfo.setMOTHER(mother);
        //PersonalInfo.setAdopted(adopted);
    } 
    
    
    
    
    
} 