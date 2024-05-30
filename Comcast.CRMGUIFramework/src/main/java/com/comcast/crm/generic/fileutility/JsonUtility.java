package com.comcast.crm.generic.fileutility;

import java.io.FileNotFoundException;
import java.io.FileReader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonUtility {
	
	public String getDataFromJsonFile(String key) throws FileNotFoundException, ParseException {
		FileReader frd = new FileReader("./configAppData/AppCommonDataforJson.json");
		JSONParser parser= new JSONParser();
		Object obj=parser.parse("frd");
        
		//step-2 : transferring the data from java object to json object by using map using down casting
		JSONObject map= (JSONObject)obj;
		String data= (String) map.get(key);
		return data;
		
		
	}
	

}
