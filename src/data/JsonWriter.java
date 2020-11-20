package data;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedHashMap; 
import java.util.Map; 
import org.json.simple.JSONArray; 
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

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
    

    public static void writeEvent(TimelineEvent newEvent) throws IOException, ParseException {
    	File eventsFile = new File(Main.PROJECT_PATH + "\\events.json");
    	JSONArray jsonArray = new JSONArray();
    	JSONObject jo = new JSONObject(); 
    	
    	
    	//If the File exists, then set the json array to the one from the file 
    	if(eventsFile.exists()) {
    		Object parser = new JSONParser().parse(new FileReader(Main.PROJECT_PATH + "\\events.json")); 
        	JSONObject jsonObjParser = (JSONObject) parser;
        	jsonArray = (JSONArray) jsonObjParser.get("events");
    	}
    	       
    	//Map for event data  	
    	Map event = new LinkedHashMap(4);
    	
        // putting data to JSONObject 
    	event.put("eventTitle", newEvent.getTitle()); 
    	event.put("eventLocation", newEvent.getLocation()); 
    	event.put("eventDate", newEvent.getDate()); 
    	event.put("eventDescription", newEvent.getDescription()); 
    	
    	jsonArray.add(event);
        jo.put("events", jsonArray);
        
        PrintWriter pw = new PrintWriter(Main.PROJECT_PATH + "\\events.json"); 
        pw.write(jo.toJSONString()); 
        pw.flush(); 
        pw.close();
    }
    
    public static void writeEvent(String eventTitle, String eventLocation, String eventDate, String eventDescription, ArrayList<File> files) {
    	
    }
    
    
    
    
    
    
    
    
    
    
    
} 