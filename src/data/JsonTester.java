package data;

import java.io.FileNotFoundException; 
import java.io.PrintWriter; 
import java.util.LinkedHashMap; 
import java.util.Map; 
import org.json.simple.JSONArray; 
import org.json.simple.JSONObject; 
  
public class JsonTester 
{ 
    public static void main(String[] args) throws FileNotFoundException  
    { 
        // creating JSONObject 
        JSONObject jo = new JSONObject(); 
          
        // putting data to JSONObject 
        jo.put("firstName", "Jinn"); 
        jo.put("lastName", "Smith"); 
        jo.put("age", 25); 
          

          
        
          
        // writing JSON to file:"JSONExample.json" in cwd 
        PrintWriter pw = new PrintWriter("JSONExample.json"); 
        pw.write(jo.toJSONString()); 
          
        pw.flush(); 
        pw.close(); 
    } 
} 