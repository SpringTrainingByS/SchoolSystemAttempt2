package pl.dn.security.jwt;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import pl.dn.exception.JwtException;
import pl.dn.security.Role;
import pl.dn.security.config.JwtSettings;

@Component
public class JwtAuthenticationProvider implements AuthenticationProvider {
	
	private final JwtSettings jwtSettings;
	
	@Autowired
	public JwtAuthenticationProvider(JwtSettings jwtSettings) {
		this.jwtSettings = jwtSettings;
	}

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		
		System.out.println("JwtAuthenticationProvider: authenticate");
		
		String token = (String) authentication.getPrincipal();
		System.out.println("Token: " + token);

		String username = "";
		List<Role> authorities = null;
		
		try {
			
			Jws<Claims> jwsClaims = Jwts.parser().setSigningKey(jwtSettings.getTokenSigningKey()).parseClaimsJws(token);
			username = jwsClaims.getBody().getSubject();
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
