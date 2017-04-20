package it.unisalento.rest.distributori.controller;

import java.io.UnsupportedEncodingException;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.rest.DefaultHttpHeaders;
import org.apache.struts2.rest.HttpHeaders;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.opensymphony.xwork2.ModelDriven;

import it.unisalento.rest.distributori.factory.FactoryDao;
import it.unisalento.rest.distributori.model.ClienteModel;
import net.sf.json.JSONObject;

public class LoginController implements ModelDriven<Object> {
	//	private String email;
	//	private String password;
	private ClienteModel model = new ClienteModel();
	private JSONObject result;
	private String token;

	public HttpHeaders create(){
		try{
			if( FactoryDao.getIstance().getPersonaDao().getPersonaByCredentials(model.getEmail(),model.getPassword()) != null){
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(new Date()); // Now use today date.
				calendar.add(Calendar.DATE, 5);
				Algorithm algorithm = Algorithm.HMAC256("secret"); // scegliere un secret affidabile
				token = JWT.create()
						.withIssuer("distributori")
						.withExpiresAt(calendar.getTime()) // issuer è la compagnia
						.sign(algorithm);
				HttpServletResponse response = ServletActionContext.getResponse();
				response.addHeader("Authorization: Bearer ", token);
				result = new JSONObject();
				result.put("result", true);
				return new DefaultHttpHeaders("create").disableCaching();


			} 
		} catch (UnsupportedEncodingException exception){
			//UTF-8 encoding not supported
		} catch (JWTCreationException exception){
			//Invalid Signing configuration / Couldn't convert Claims.
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
