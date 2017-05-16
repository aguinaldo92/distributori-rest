package it.unisalento.rest.distributori.util;

import java.io.UnsupportedEncodingException;
import java.util.Calendar;
import java.util.Date;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

public abstract class TokenUtils {
	public static String tokenBuilder(int days) throws IllegalArgumentException, UnsupportedEncodingException{
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date()); // Now use today date.
		calendar.add(Calendar.DATE, days);
		Algorithm algorithm = Algorithm.HMAC256("secret"); // scegliere un secret affidabile
		String token = JWT.create()
				.withIssuer("distributori")
				.withExpiresAt(calendar.getTime()) // issuer è la compagnia
				.sign(algorithm);
		return token;
		
	}

}
