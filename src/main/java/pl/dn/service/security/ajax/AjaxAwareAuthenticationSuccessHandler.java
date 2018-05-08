package pl.dn.service.security.ajax;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

import pl.dn.model.security.Role;
import pl.dn.service.security.JwtTokenFactory;

@Component
public class AjaxAwareAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
	
	private final ObjectMapper mapper;
	private final JwtTokenFactory tokenFactory;
	
	@Autowired
	public AjaxAwareAuthenticationSuccessHandler(ObjectMapper mapper, JwtTokenFactory tokenFactory) {
		this.mapper = mapper;
		this.tokenFactory = tokenFactory;
	}

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		
		System.out.println("AjaxAwareAuthenticationSuccessHandler: onAuthenticationSuccess");
		
		String username = (String) authentication.getPrincipal();
		List<GrantedAuthority> authorities = (List<GrantedAuthority>) authentication.getAuthorities();
		System.out.println("Username: " + username);
		
		List<String> rolesNames = authorities.stream()
				.map(x -> x.getAuthority())
				.collect(Collectors.toList()); 
		
		System.out.println("Role przed dodaniem do tokenów: ");
		for (String authority : rolesNames) {
			System.out.println("Rola: "  + authority);
		}
		
		String accessToken = tokenFactory.createAccessJwtToken(username, authorities);
		String refreshToken = tokenFactory.createRefreshToken(username, authorities);
		
		Map<String, Object> responseMap = new HashMap<String, Object>();
		responseMap.put("token", accessToken);
		responseMap.put("refreshToken", refreshToken);
		responseMap.put("roles", rolesNames);

		
		
		response.setStatus(HttpStatus.OK.value());
		response.setContentType(MediaType.APPLICATION_JSON_VALUE);
		mapper.writeValue(response.getWriter(), responseMap);
	}
	
	protected final void clearAuthenticationAttributes(HttpServletRequest request) {
		HttpSession session = request.getSession();
		
		if (session == null) {
			return;
		}
		
		session.removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
	}
	
	

}
