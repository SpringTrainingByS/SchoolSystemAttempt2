package pl.dn.security.jwt;

import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import pl.dn.exception.JwtException;
import pl.dn.request.UserContext;
import pl.dn.security.Role;
import pl.dn.security.config.JwtSettings;

@Component
public class JwtAuthenticationProvider implements AuthenticationProvider {
	
	private final JwtSettings jwtSettings;
	
	private UserContext userContext;
	
	@Autowired
	public JwtAuthenticationProvider(JwtSettings jwtSettings, @Qualifier("userContextRequest") UserContext userContext) {
		this.jwtSettings = jwtSettings;
		this.userContext = userContext;
	}

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		
		System.out.println("JwtAuthenticationProvider: authenticate");
		
		String token = (String) authentication.getPrincipal();
		System.out.println("Token: " + token);

		String username = "";
		List<Role> authorities = null;
		long userId = 0L;
		
		try {
			
			Jws<Claims> jwsClaims = Jwts.parser().setSigningKey(jwtSettings.getTokenSigningKey()).parseClaimsJws(token);
			username = jwsClaims.getBody().getSubject();
			userId = Long.parseLong(jwsClaims.getBody().getIssuer());
			System.out.println("Token: " + token); 
			List<String> scopes = jwsClaims.getBody().get("scopes", List.class); 
		
			System.out.println("Scopes: ");
			for (String scope : scopes) {
				System.out.println("Scope: " + scope);
			}
			
			authorities = scopes.stream()
					.map(Role::new)
					.collect(Collectors.toList());
			
			System.out.println("Prawa u¿ytkownika.");
			for (Role gr : authorities) {
				System.out.println(gr.getName());
			}
			
			userContext.setUserId(userId);
		}
		catch (MalformedJwtException | ExpiredJwtException | IllegalArgumentException e) {
			throw new JwtException(e.getMessage());
		}
		
		return new UsernamePasswordAuthenticationToken(username, null, authorities);
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
	}
	
	
	
	
}
