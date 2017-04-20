package it.unisalento.rest.distributori.controller;

import org.apache.struts2.rest.DefaultHttpHeaders;
import org.apache.struts2.rest.HttpHeaders;

import com.opensymphony.xwork2.ModelDriven;

import it.unisalento.rest.distributori.domain.Persona;
import it.unisalento.rest.distributori.factory.FactoryDao;
import net.sf.json.JSONObject;

public class ProfiloController implements ModelDriven<Object> {

	private Object model = new Object();
	private Integer IdPersona;
	
	public HttpHeaders index(){
		
		JSONObject persona_JSON = new JSONObject();
		
		Persona persona = FactoryDao.getIstance().getPersonaDao().get(IdPersona, Persona.class);
		
		persona_JSON.put("IdPersona", persona.getId());
		persona_JSON.put("Nome", persona.getNome());
		persona_JSON.put("Cognome", persona.getCognome());
		persona_JSON.put("Email", persona.getEmail());
		
		model = persona_JSON;
		
		return new DefaultHttpHeaders("index").disableCaching();
	}
	
	@Override
	public Object getModel() {
		return model;
	}

	public void setIdPersona(Integer idPersona) {
		IdPersona = idPersona;
	}

}
