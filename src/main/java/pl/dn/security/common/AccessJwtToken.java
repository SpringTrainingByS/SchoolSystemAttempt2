package pl.dn.security.common;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.jsonwebtoken.Claims;

public class AccessJwtToken {
	private final String rawToken;
	@JsonIgnore private Claims claims;
	
	public AccessJwtToken(String rawToken, Claims claims) {
		this.rawToken = rawToken;
		this.claims = claims;
	}

	public Claims getClaims() {
		return claims;
	}

	public String getRawToken() {
		return rawToken;
	}
	
	
	
	
}
