package pl.dn.security.ajax;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.fasterxml.jackson.databind.ObjectMapper;

import pl.dn.security.common.LoginRequest;
import pl.dn.security.common.WebUtil;

public class AjaxLoginProcessingFilter extends AbstractAuthenticationProcessingFilter {

	private final AuthenticationSuccessHandler successHandler;
	private final AuthenticationFailureHandler failureHandler;
	
	private final ObjectMapper objectMapper;
	
	public AjaxLoginProcessingFilter(String defaultProcessUrl, AuthenticationSuccessHandler successHandler, AuthenticationFailureHandler failureHandler, 
			ObjectMapper mapper) {
		super(defaultProcessUrl);
		
		this.successHandler = successHandler;
		this.failureHandler = failureHandler;
		this.objectMapper = mapper;
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException, IOException, ServletException {
		
		System.out.println("AjaxLoginProcessingFilter: attemptAuthentication()");
		
		
		if (!HttpMethod.POST.name().equals(request.getMethod()) || !WebUtil.isContentTypeJson(request)) {
			System.out.println("This is not ajax Requests");
			throw new AuthenticationServiceException("Authentication method not supported");
		}
		
		if (objectMapper == null) {
			System.out.println("objectMapper jest nullem");
		}
		
		LoginRequest loginRequest = objectMapper.readValue(request.getReader(), LoginRequest.class);
		
		System.out.println("Pobranie usera: " + loginRequest.toString());
		
		if (StringUtils.isBlank(loginRequest.getUsername()) || StringUtils.isBlank(loginRequest.getPassword())) {
			System.out.println("Username or Password not provided");
			throw new AuthenticationServiceException("Username or Password not provided");
		}
		
		UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword());
		
		System.out.println("przesy�am dane do authManagera: ");
		return this.getAuthenticationManager().authenticate(token);
	}

	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {

		System.out.println("AjaxLoginProcessingFilter: successfulAuthentication()");
			
		successHandler.onAuthenticationSuccess(request, response, authResult);
	}

	@Override
	protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException failed) throws IOException, ServletException {
		
		System.out.println("AjaxLoginProcessingFilter: unsuccessfulAuthentication()");
		
		failureHandler.onAuthenticationFailure(request, response, failed);

	}
	
	
	
	
	
}
