package org.matrix.security.jwt;

import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class TokenAuthenticationService {

	private long EXPIRATIONTIME = 1000 * 60 * 60 * 24 * 3; // 3 days
	//private long EXPIRATIONTIME = 1000 * 60 * 30; // 30 mins
	private String secret = "sshuush"; /* TODO : get it from configuration file*/
	private static final String TOKEN_PREFIX = "Bearer";
	private static final String HEADER_STR = "Authorization";
	private static final String WHITE_SPACE = " "; 

	public void addAuthentication(HttpServletResponse response, String username) throws IOException {
		// We generate a token now.
		String JWT = Jwts.builder().setSubject(username)
				.setExpiration(new Date(System.currentTimeMillis() + EXPIRATIONTIME))
				.signWith(SignatureAlgorithm.HS512, secret).compact();

		response.setHeader(HEADER_STR, TOKEN_PREFIX + " " + JWT);
		response.setContentType("application/json");
		// writes directly to response body
		response.getWriter().write(this.JSONize(JWT));	}

	public Authentication getAuthentication(HttpServletRequest request) {
		String headerStringValue = request.getHeader(HEADER_STR);
		if(headerStringValue == null) return null;

		String token = null;
		if(headerStringValue.contains(WHITE_SPACE)) {
			token = headerStringValue.substring(headerStringValue.indexOf(WHITE_SPACE));
		}else {
			token = headerStringValue;
		}

		if (token != null) {
			// parse the token.
			String username = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody().getSubject();
			if (username != null) // we managed to retrieve a user
			{
				return new AuthenticatedUser(username);
			}
		}
		return null;
	}
	/* wraps the token inside a JSON object like
	 * 
	 * {"token": "generated_token"}
	 * 
	 */
	private String JSONize(String JWT) {
		StringBuffer JSON_JWT = new StringBuffer();
		JSON_JWT.append("{\"token\"").append(":").append("\"").append(JWT).append("\"}");
		return JSON_JWT.toString();
	}
}