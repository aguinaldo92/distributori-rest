package it.unisalento.rest.distributori.controller;

import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.InterceptorRefs;
import org.apache.struts2.rest.DefaultHttpHeaders;
import org.apache.struts2.rest.HttpHeaders;

import com.opensymphony.xwork2.ModelDriven;
import it.unisalento.rest.distributori.domain.Persona;
import it.unisalento.rest.distributori.factory.FactoryDao;
import it.unisalento.rest.distributori.model.ClienteModel;
import net.sf.json.JSONObject;

@InterceptorRefs({
	@InterceptorRef("LoginStack")})
public class ProfiloController implements ModelDriven<Object> {

	private Object model_GET;
	private Integer idPersona;
	private ClienteModel model_POST = new ClienteModel();
	private JSONObject result_POST;
	
	public HttpHeaders index(){
		
		model_GET = new Object();
		
		JSONObject persona_JSON = new JSONObject();
		
		Persona persona = FactoryDao.getIstance().getPersonaDao().get(idPersona, Persona.class);
		
		persona_JSON.put("idPersona", persona.getId());
		persona_JSON.put("nome", persona.getNome());
		persona_JSON.put("cognome", persona.getCognome());
		persona_JSON.put("email", persona.getEmail());
		
		model_GET = persona_JSON;
		
		return new DefaultHttpHeaders("index").disableCaching();
	}
	
	public HttpHeaders create(){//update del profilo utente
		
		Persona persona = FactoryDao.getIstance().getPersonaDao().get(model_POST.getId(), Persona.class);
		
		persona.setCognome(model_POST.getCognome());
		persona.setEmail(model_POST.getEmail());
		persona.setNome(model_POST.getNome());
		persona.setPassword(model_POST.getPassword());
		
		
		//aggiorno l'utente sul DB
		FactoryDao.getIstance().getPersonaDao().update(persona);
		
		result_POST = new JSONObject();
		result_POST.put("result", true);
		
		return new DefaultHttpHeaders("index").disableCaching();
	}
	
	@Override
	public Object getModel() {
		
		if(model_GET != null){//Se la chiamata � una GET delle informazioni di profilo
			return model_GET;//IN - OUT
		}
		else if (result_POST != null) {//Se la chiamata � una POST per settare le informazioni di profilo aggiornate
			return result_POST;//OUT
		}
		
		return model_POST;//IN
	}

	public void setIdPersona(Integer idPersona) {
		this.idPersona = idPersona;
	}

}
