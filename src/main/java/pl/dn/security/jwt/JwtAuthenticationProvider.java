package pl.dn.security.jwt;

import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import pl.dn.exception.JwtException;
import pl.dn.security.role.Role;
import pl.dn.security.config.JwtSettings;

@Component
public class JwtAuthenticationProvider implements AuthenticationProvider {
	
	private final JwtSettings jwtSettings;
	
	private HttpServletRequest request;
	
	@Autowired
	public JwtAuthenticationProvider(JwtSettings jwtSettings, HttpServletRequest request) {
		this.jwtSettings = jwtSettings;
		this.request = request;
	}

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {

		String token = (String) authentication.getPrincipal();

		String username = "";
		List<Role> authorities = null;
		long userId = 0L;
		
		try {
			
			Jws<Claims> jwsClaims = Jwts.parser().setSigningKey(jwtSettings.getTokenSigningKey()).parseClaimsJws(token);
			username = jwsClaims.getBody().getSubject();
			userId = Long.parseLong(jwsClaims.getBody().getIssuer());
			List<String> scopes = jwsClaims.getBody().get("scopes", List.class);

			
			authorities = scopes.stream()
					.map(Role::new)
					.collect(Collectors.toList());
			
			request.setAttribute("userId", userId);
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
