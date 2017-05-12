package it.unisalento.rest.distributori.util;

import net.sf.json.JSONObject;

public abstract class ResultDispatcher {
	public static JSONObject jsonError(String message){
		JSONObject result = new JSONObject();
		result.put("result", false);
		result.put("message", message);
		return result;
	}
	
	public static JSONObject jsonErrorUtf8Encoding() {
		JSONObject result = new JSONObject();
		result.put("result", false);
		result.put("message", "utf-8 encoding not supported");
		return result;
	}
	
	public static JSONObject jsonErrorJWTCreation(){
		JSONObject result = new JSONObject();
		result.put("result", false);
		result.put("message", "Invalid Signing configuration / Couldn't convert Claims");
		return result;
	}

}
