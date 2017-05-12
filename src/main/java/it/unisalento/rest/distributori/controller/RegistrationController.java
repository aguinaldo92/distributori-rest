package it.unisalento.rest.distributori.controller;

import java.util.Calendar;
import java.util.Date;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.rest.DefaultHttpHeaders;
import org.apache.struts2.rest.HttpHeaders;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.opensymphony.xwork2.ModelDriven;

import it.unisalento.rest.distributori.domain.Persona;
import it.unisalento.rest.distributori.factory.FactoryDao;
import it.unisalento.rest.distributori.model.ClienteModel;
import it.unisalento.rest.distributori.util.GeneraPwd;
import it.unisalento.rest.distributori.util.PasswordUtils;
import it.unisalento.rest.distributori.util.ResultDispatcher;
import it.unisalento.rest.distributori.util.TokenUtils;
import net.sf.json.JSONObject;

public class RegistrationController implements ModelDriven<Object> {
	private ClienteModel model = new ClienteModel();
	private JSONObject result;
	private String token;
	final int dim_pw = 6;
	final int days = 5;


	public HttpHeaders create(){
		try{

			if(!FactoryDao.getIstance().getPersonaDao().emailExists(model.getEmail())){
				Persona persona = new Persona();
				persona.setEmail(model.getEmail());
				
				GeneraPwd pw_generator = new GeneraPwd(dim_pw);//generatore di password lunghe 6 caratteri
				String passwordInChiaro = pw_generator.getPWD();
				String hashedPassword = PasswordUtils.getSha256(passwordInChiaro);
				persona.setPassword(hashedPassword);
				FactoryDao.getIstance().getPersonaDao().set(persona);
				token = TokenUtils.tokenBuilder(days);
				HttpServletResponse response = ServletActionContext.getResponse();
				response.addHeader("Authorization: Bearer ", token);
				result = new JSONObject();
				result.put("result", true);


			} else {
				result = ResultDispatcher.jsonError("Indirizzo email già in uso, sceglierne un altro.");
			}
		} catch (UnsupportedEncodingException exception){
			//UTF-8 encoding not supported
			result = ResultDispatcher.jsonErrorUtf8Encoding();
		} catch (JWTCreationException exception){
			//Invalid Signing configuration / Couldn't convert Claims.
			result = ResultDispatcher.jsonErrorJWTCreation();
		} catch (Exception e) {
			result = ResultDispatcher.jsonError(e.getLocalizedMessage());
		}
		finally {
			return new DefaultHttpHeaders("create").disableCaching();
		}


	}

	@Override
	public Object getModel() {
		if ( result != null)
			return result;
		return model;
	}

	private 

}
