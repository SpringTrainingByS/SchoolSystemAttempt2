package pl.dn.security;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import pl.dn.security.config.JwtSettings;

@Component
public class JwtTokenFactory {
	
	private final JwtSettings settings;
	
	@Autowired
	public JwtTokenFactory(JwtSettings settings) {
		this.settings = settings;
	}

	public String createAccessJwtToken(String username, long userId, List<GrantedAuthority> authorities) {
		if (StringUtils.isBlank(username)) {
			throw new IllegalArgumentException("Cannot create JWT Token without username");
		}
		
		if (authorities == null || authorities.isEmpty()) {
			throw new IllegalArgumentException("User doesn't have any priviligies.");
		}
		
		Claims claims = Jwts.claims().setSubject(username);
		claims.put("scopes", authorities.stream().map(s -> s.getAuthority()).collect(Collectors.toList()));
		
		System.out.println("getTokenSigningKey()" + settings.getTokenSigningKey());
		
		String token = Jwts.builder()
				.setClaims(claims)
				.setIssuer(Long.toString(userId))
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + settings.getTokenExpirationTime() * 1000))
				.signWith(SignatureAlgorithm.HS512 , settings.getTokenSigningKey())
				.compact();
		
		return token;
	}
	
	public String createRefreshToken(String username, long userId, List<GrantedAuthority> authorities) {
		
		Claims claims = Jwts.claims().setSubject(username);
		claims.put("scopes", "REFRESH_TOKEN");
		
		String token = Jwts.builder()
				.setClaims(claims)
				.setIssuer(Long.toString(userId))
				.setId(UUID.randomUUID().toString())
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + settings.getRefreshTokenExpTime() * 1000))
				.signWith(SignatureAlgorithm.HS512, settings.getTokenSigningKey())
				.compact();
		
		return token;
		
	}
	
}
