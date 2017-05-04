package it.unisalento.rest.distributori.interceptor;

import java.io.UnsupportedEncodingException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.StrutsStatics;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class LoginInterceptor implements Interceptor{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void init() {
		// TODO Auto-generated method stub

	}

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		try {
			System.out.println("intercettato");
			final ActionContext actionContext = invocation.getInvocationContext();
			HttpServletRequest request =  (HttpServletRequest) actionContext.get(StrutsStatics.HTTP_REQUEST);
			String authorizationValue = request.getHeader("Authorization");
			if( authorizationValue != null){
				String[] parts =  authorizationValue.split(" ");
				String token = parts[2];
				Algorithm algorithm = Algorithm.HMAC256("secret");
				JWTVerifier verifier = JWT.require(algorithm)
						.withIssuer("distributori")
						.build(); //Reusable verifier instance
				DecodedJWT jwt = verifier.verify(token);
				String issuer  = jwt.getIssuer();
				Date expiresAt = jwt.getExpiresAt(); 
				Date now = new Date();
				if ( issuer.compareToIgnoreCase("distributori") == 0 && expiresAt.after(now)) {
					System.out.println("tutto ok");
					return invocation.invoke();
				} 
			}
			HttpServletResponse response = ServletActionContext.getResponse();
			response.addHeader("Authorization","");

			//HttpServletResponse response = (HttpServletResponse) actionContext.get(StrutsStatics.HTTP_RESPONSE); risposta corretta da interceptor
		} catch (UnsupportedEncodingException exception){
			//UTF-8 encoding not supported
		} catch (JWTVerificationException exception){
		}
		return null;
	}

}

/*

package it.unisalento.distributori.interceptor;

import it.unisalento.distributori.domain.Persona;
import it.unisalento.distributori.util.PermissionsHashMap;

import java.util.HashMap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.dispatcher.SessionMap;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;


public class LoginInterceptor implements Interceptor {

	private static final long serialVersionUID = -1301649202050082833L;
	private SessionMap<String, Object> personaSession;
	private Integer ruolo;
	private String namespaceAction;
	private String nameAction;
	private PermissionsHashMap permissionsHashMap;
	private HashMap<Integer, String> ruolo_namespace;
	private Logger logger = LogManager.getLogger(LoginInterceptor.class.getName());

	@Override
	public void destroy() {
	}

	@Override
	public void init() {
		permissionsHashMap = new PermissionsHashMap();
		ruolo_namespace = permissionsHashMap.getRuolo_namespace();
	}

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		personaSession = (SessionMap<String, Object>) invocation.getInvocationContext().getSession();
		logger.debug("LoginInterceptor: intercept");

		if (personaSession.containsKey("persona")) {
			namespaceAction = invocation.getProxy().getNamespace();
			nameAction = invocation.getProxy().getActionName();
			logger.debug("LoginInterceptor: Namespace: " + namespaceAction + "; Action name:" + nameAction);

			ruolo = ((Persona) personaSession.get("persona")).getRuolo();
			if (ruolo_namespace.get(ruolo).equals(namespaceAction)) {
				logger.debug("Permessi OK: sei nel namespace: " + namespaceAction + " action:  " + nameAction + " poichè hai il ruolo " + ruolo);
				return invocation.invoke();
			} else {
				logger.debug("LoginInterceptor: permessi Insufficienti: hai provato ad entrare nel namespace " + namespaceAction + " action:  " + nameAction + " ma il tuo ruolo è" + ruolo);
				return Action.LOGIN;
			}
		} else {
			logger.debug("L'utente deve essere loggato per arrivare alla pagina ");
			return Action.LOGIN;
		}

	}

}
 */