package data;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator; 
import java.util.Map; 
  
import org.json.simple.JSONArray; 
import org.json.simple.JSONObject; 
import org.json.simple.parser.*;

import application.Main; 
  
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
    
    public static ArrayList<TimelineEvent> getEventsFromJson() throws FileNotFoundException, IOException, ParseException{
    	ArrayList<TimelineEvent> eventArrayList = new ArrayList<TimelineEvent>();
    	Object obj = new JSONParser().parse(new FileReader(Main.PROJECT_PATH + "\\events.json")); 
    	JSONObject jsonObject = (JSONObject) obj;
    	JSONArray jsonArray = (JSONArray) jsonObject.get("events"); 
    	Map event;
    	
    	Iterator i = jsonArray.iterator();
    	while(i.hasNext()) {
    		event = (Map) i.next();
    		TimelineEvent newTimlineEvent = new TimelineEvent(
    				(String) event.get("eventTitle"),
    				(String) event.get("eventLocation"),
    				(String) event.get("eventDate"),
    				(String) event.get("eventDescription"));
    		eventArrayList.add(newTimlineEvent);
    		//Metadata.EVENT_LIST.add(newTimlineEvent);
    	}
    	Metadata.EVENT_LIST = eventArrayList;
    	return eventArrayList;
    	
    }
    
    public static void loadEvents() throws FileNotFoundException, IOException, ParseException {
    	ArrayList<TimelineEvent> eventArrayList = new ArrayList<TimelineEvent>();
    	Object obj = new JSONParser().parse(new FileReader(Main.PROJECT_PATH + "\\events.json")); 
    	JSONObject jsonObject = (JSONObject) obj;
    	JSONArray jsonArray = (JSONArray) jsonObject.get("events"); 
    	Map event;
    	
    	Iterator i = jsonArray.iterator();
    	while(i.hasNext()) {
    		event = (Map) i.next();
    		TimelineEvent newTimlineEvent = new TimelineEvent(
    				(String) event.get("eventTitle"),
    				(String) event.get("eventTitle"),
    				(String) event.get("eventTitle"),
    				(String) event.get("eventTitle"));
    		eventArrayList.add(newTimlineEvent);
    		//Metadata.EVENT_LIST.add(newTimlineEvent);
    	}
    	Metadata.EVENT_LIST = eventArrayList;
    }
    
    
    
    
    
} 