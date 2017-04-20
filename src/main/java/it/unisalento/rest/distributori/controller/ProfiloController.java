package it.unisalento.rest.distributori.controller;

import org.apache.struts2.rest.DefaultHttpHeaders;
import org.apache.struts2.rest.HttpHeaders;

import com.opensymphony.xwork2.ModelDriven;
import it.unisalento.rest.distributori.domain.Persona;
import it.unisalento.rest.distributori.factory.FactoryDao;
import net.sf.json.JSONObject;

public class ProfiloController implements ModelDriven<Object> {

	private Object model = new Object();
	private Integer idPersona;
	
	public HttpHeaders index(){
		
		JSONObject persona_JSON = new JSONObject();
		
		Persona persona = FactoryDao.getIstance().getPersonaDao().get(idPersona, Persona.class);
		
		persona_JSON.put("IdPersona", persona.getId());
		persona_JSON.put("Nome", persona.getNome());
		persona_JSON.put("Cognome", persona.getCognome());
		persona_JSON.put("Email", persona.getEmail());
		
		model = persona_JSON;
		
		return new DefaultHttpHeaders("index").disableCaching();
	}
	
	public HttpHeaders put(){
		//TODO: Da vedere al momento della creazione dell'activity per la modifica del profilo utente Android
		return null;
	}
	
	@Override
	public Object getModel() {
		return model;
	}

	public void setIdPersona(Integer idPersona) {
		this.idPersona = idPersona;
	}

}
