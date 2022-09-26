package utils;

import org.json.JSONObject;

public class JsonUtils {

	
	public JSONObject getJsonObject(String inputData) {
		
		 JSONObject obj = new JSONObject(inputData);
		 return obj;
	}
	
	}
