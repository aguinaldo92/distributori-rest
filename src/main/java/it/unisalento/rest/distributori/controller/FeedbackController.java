package it.unisalento.rest.distributori.controller;

import java.util.Date;

import org.apache.struts2.rest.DefaultHttpHeaders;
import org.apache.struts2.rest.HttpHeaders;

import com.opensymphony.xwork2.ModelDriven;

import it.unisalento.rest.distributori.domain.Feedback;
import it.unisalento.rest.distributori.domain.Persona;
import it.unisalento.rest.distributori.factory.FactoryDao;
import it.unisalento.rest.distributori.model.FeedbackModel;
import net.sf.json.JSONObject;

public class FeedbackController implements ModelDriven<Object> {
	
	private FeedbackModel model = new FeedbackModel();
	private JSONObject result;
	
	public HttpHeaders create(){
		
		Persona persona = FactoryDao.getIstance().getPersonaDao().get(model.getIdPersona(), Persona.class);
		
		Feedback feedback = new Feedback();
		feedback.setData(new Date());
		feedback.setLetto(Byte.valueOf("0"));
		feedback.setPersona(persona);
		feedback.setTesto(model.getTesto());
		
		//salvataggio feedback nel DB
		feedback.setId(FactoryDao.getIstance().getFeedbackDao().set(feedback));
		result = new JSONObject();
		result.put("result", true);
		result.put("id", feedback.getId());
		
		return new DefaultHttpHeaders("create").disableCaching();
	}

	@Override
	public Object getModel() {
		if ( result != null)
			return result;
		return model;
	}
	
}
