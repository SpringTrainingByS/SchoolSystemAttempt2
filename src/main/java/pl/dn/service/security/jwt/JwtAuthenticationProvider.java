package pl.dn.service.security.jwt;

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
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import pl.dn.service.security.config.JwtSettings;

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
		List<GrantedAuthority> authorities = null;
		
		try {
			Jws<Claims> jwsClaims = Jwts.parser().setSigningKey(jwtSettings.getTokenSigningKey()).parseClaimsJws(token);
			username = jwsClaims.getBody().getSubject();
			System.out.println("Token: " + token); 
			List<String> scopes = jwsClaims.getBody().get("scopes", List.class); 
		
			authorities = scopes.stream()
					.map(SimpleGrantedAuthority::new)
					.collect(Collectors.toList());
			
			System.out.println("Prawa u¿ytkownika.");
			for (GrantedAuthority gr : authorities) {
				System.out.println(gr.getAuthority());
			}
		}
		catch (Exception e) {
			throw new JwtException(e.getMessage());
		}
		
		return new UsernamePasswordAuthenticationToken(username, null, authorities);
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
	}
	
	
	
	
}
