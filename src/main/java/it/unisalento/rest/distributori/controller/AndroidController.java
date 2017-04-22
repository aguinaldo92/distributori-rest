package it.unisalento.rest.distributori.controller;

import org.apache.struts2.rest.DefaultHttpHeaders;
import org.apache.struts2.rest.HttpHeaders;

import com.opensymphony.xwork2.ModelDriven;

import it.unisalento.rest.distributori.model.FCMToken;
import net.sf.json.JSONObject;

public class AndroidController implements ModelDriven<Object>{

	private FCMToken model = new FCMToken();
	JSONObject result;
	
	public HttpHeaders create(){
		
		System.out.println("Il token ottenuto è: "+model.getToken());
		
		result = new JSONObject();
		
		result.put("result", true);
		
		return new DefaultHttpHeaders("create").disableCaching();
		
	}
	
	@Override
	public Object getModel() {
		if (result == null)
			return model;
		else
			return result;
	}

}
