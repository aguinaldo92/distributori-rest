package it.unisalento.rest.distributori.controller;

import java.util.ArrayList;

import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.InterceptorRefs;
import org.apache.struts2.rest.DefaultHttpHeaders;
import org.apache.struts2.rest.HttpHeaders;

import com.opensymphony.xwork2.ModelDriven;

import it.unisalento.rest.distributori.domain.Distributore;
import it.unisalento.rest.distributori.domain.Persona;
import it.unisalento.rest.distributori.domain.SottoscrizioniDistributori;
import it.unisalento.rest.distributori.factory.FactoryDao;
import it.unisalento.rest.distributori.model.SottoscrizioneModel;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@InterceptorRefs({
	@InterceptorRef("LoginStack")})
public class SottoscrizioniController implements ModelDriven<Object> {
	
	private SottoscrizioneModel model = new SottoscrizioneModel();
	private JSONObject result;

	public HttpHeaders index(){
		
		if(model.getModality().equals("set")){//richiesta di setting di una nuova sottoscrizione
			
			Distributore distributore = FactoryDao.getIstance().getDistributoreDao().get(model.getIdDistributore(), Distributore.class);
			Persona persona = FactoryDao.getIstance().getPersonaDao().get(model.getIdPersona(), Persona.class);
			
			SottoscrizioniDistributori sottoscrizione = new SottoscrizioniDistributori(distributore, persona);
			sottoscrizione.setId(FactoryDao.getIstance().getPersonaDao().setSottoscrizioneDistributore(sottoscrizione));
			
			result = new JSONObject();
			result.put("result", true);
			result.put("id", sottoscrizione.getId());
			
		}
		
		else if(model.getModality().equals("get")){//richiesta di getting della lista di sottoscrizioni di una persona
			
			ArrayList<Distributore> sottoscrizioniDistributore = FactoryDao.getIstance().getPersonaDao().getSottoscrizioniByPersona(model.getIdPersona());
			
			JSONArray listDistributori_JSON = new JSONArray();
			JSONArray listTopics_JSON = new JSONArray();
			for (Distributore distributore : sottoscrizioniDistributore) {
				listDistributori_JSON.add(distributore.getId());
				listTopics_JSON.add("distributore_"+distributore.getId());
			}
			
			JSONObject sottoscrizioni = new JSONObject();
			sottoscrizioni.put("listDistributori", listDistributori_JSON);
			sottoscrizioni.put("listTopics", listTopics_JSON);
			result = new JSONObject();
			result.put("result", true);
			result.put("sottoscrizioni", sottoscrizioni);

		}
		else if(model.getModality().equals("del")){//richiesta di deleting di una sottoscrizione
			FactoryDao.getIstance().getPersonaDao().deleteSottoscrizione(model.getIdPersona(), model.getIdDistributore());
			
			result = new JSONObject();
			result.put("result", true);
		}
		
		if(result == null){
			result = new JSONObject();
			result.put("result", false);
			result.put("response", "Bad request");
		}
		
		return new DefaultHttpHeaders("create").disableCaching();
	}

	@Override
	public Object getModel() {
		if ( result != null)
			return result;
		return model;
	}
	
}
