package it.unisalento.rest.distributori.controller;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.rest.DefaultHttpHeaders;
import org.apache.struts2.rest.HttpHeaders;

import com.auth0.jwt.exceptions.JWTCreationException;
import com.opensymphony.xwork2.ModelDriven;

import it.unisalento.rest.distributori.domain.Persona;
import it.unisalento.rest.distributori.factory.FactoryDao;
import it.unisalento.rest.distributori.model.ClienteModel;
import it.unisalento.rest.distributori.util.ResultDispatcher;
import it.unisalento.rest.distributori.util.TokenUtils;
import net.sf.json.JSONObject;

public class LoginController implements ModelDriven<Object> {
	//	private String email;
	//	private String password;
	private ClienteModel model = new ClienteModel();
	private JSONObject result;
	private String token;
	final int days = 5;

	public HttpHeaders create(){
		try{
			Persona utente = FactoryDao.getIstance().getPersonaDao().getPersonaByCredentials(model.getEmail(),model.getPassword());
			if( utente != null){
				token = TokenUtils.tokenBuilder(days);
				HttpServletResponse response = ServletActionContext.getResponse();
				response.addHeader("Authorization: Bearer ", token);
				result = new JSONObject();
				result.put("result", true);
				result.put("token", token);
				result.put("idUtente",utente.getId());
				
			} else {
				result = ResultDispatcher.jsonError("Credenziali errate");
			}
		} catch (UnsupportedEncodingException exception){
			//UTF-8 encoding not supported
			result = ResultDispatcher.jsonErrorUtf8Encoding();
		} catch (JWTCreationException exception){
			//Invalid Signing configuration / Couldn't convert Claims.
			result = ResultDispatcher.jsonErrorJWTCreation();
		} catch (Exception e) {
			result = ResultDispatcher.jsonError(e.getMessage());
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
