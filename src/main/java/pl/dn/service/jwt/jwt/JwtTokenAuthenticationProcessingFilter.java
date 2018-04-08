package pl.dn.service.jwt.jwt;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.util.matcher.RequestMatcher;

import pl.dn.service.jwt.common.TokenExtractor;

public class JwtTokenAuthenticationProcessingFilter extends AbstractAuthenticationProcessingFilter {
	
	private final AuthenticationFailureHandler failureHandler;
	
	public final String JWT_TOKEN_HEADER_PARAM = "Authorization";
	
	@Autowired
	public JwtTokenAuthenticationProcessingFilter(AuthenticationFailureHandler failureHandler, String defaultUrl) {
		super(defaultUrl);
		this.failureHandler = failureHandler;
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException, IOException, ServletException {
		
		System.out.println("JwtTokenAuthenticationProcessingFilter: attemptAuthentication");
		
		String tokenPayload = request.getHeader(JWT_TOKEN_HEADER_PARAM);
		System.out.println("tokenPayload: " + tokenPayload);

		String token = tokenPayload.substring("Bearer ".length(), tokenPayload.length());
		System.out.println("token: " + token);

		UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(token, null);
		
		return getAuthenticationManager().authenticate(authToken);
	}

	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {
		
		System.out.println("JwtTokenAuthenticationProcessingFilter: successfulAuthentication");
		
		SecurityContext context = SecurityContextHolder.createEmptyContext();
		context.setAuthentication(authResult);
		SecurityContextHolder.setContext(context);
		
		chain.doFilter(request, response);
	}

	@Override
	protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException failed) throws IOException, ServletException {
		
		System.out.println("JwtTokenAuthenticationProcessingFilter: unsuccessfulAuthentication");
		
		SecurityContextHolder.clearContext();
		failureHandler.onAuthenticationFailure(request, response, failed);
	}
	
	

}
