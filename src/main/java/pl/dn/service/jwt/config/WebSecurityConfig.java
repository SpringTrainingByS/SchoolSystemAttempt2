package pl.dn.service.jwt.config;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.databind.ObjectMapper;

import pl.dn.service.jwt.RestAuthenticationEntryPoint;
import pl.dn.service.jwt.ajax.AjaxAuthenticationProvider;
import pl.dn.service.jwt.ajax.AjaxAwareAuthenticationFailureHandler;
import pl.dn.service.jwt.ajax.AjaxAwareAuthenticationSuccessHandler;
import pl.dn.service.jwt.ajax.AjaxLoginProcessingFilter;
import pl.dn.service.jwt.jwt.JwtAuthenticationProvider;
import pl.dn.service.jwt.jwt.JwtTokenAuthenticationProcessingFilter;
import pl.dn.service.jwt.jwt.SkipPathRequestMatcher;


@EnableWebSecurity
public class  WebSecurityConfig {

	public static final String AUTHENTICATION_HEADER_NAME = "Authorization";
    public static final String AUTHENTICATION_URL = "/api/auth/login";
    public static final String REFRESH_TOKEN_URL = "/api/auth/token";
    public static final String API_ROOT_URL = "/api/**";
	
	
	@Autowired private RestAuthenticationEntryPoint authenticationEntryPoint;
	@Autowired private AjaxAwareAuthenticationSuccessHandler successHandler;
	@Autowired private AjaxAwareAuthenticationFailureHandler failureHandler;
	@Autowired private AjaxAuthenticationProvider ajaxAuthenticationProvider;
	@Autowired private JwtAuthenticationProvider jwtAuthenticationProvider;
	
	@Autowired private AuthenticationManager authenticationManager;
	@Autowired private ObjectMapper objectMapper;
	
	protected  AjaxLoginProcessingFilter buildAjaxLoginProcessingFilter(String loginEntryPoint,
			AuthenticationManager  authManager) throws Exception {
		AjaxLoginProcessingFilter filter = 
				new AjaxLoginProcessingFilter(loginEntryPoint, successHandler, failureHandler, objectMapper);
		filter.setAuthenticationManager(authManager);
		return filter;
	}
	
	protected JwtTokenAuthenticationProcessingFilter buildJwtTokenAuthenticationProcessingFilter(List<String> pathsToSkip, String pattern,
			AuthenticationManager authManager) {
		SkipPathRequestMatcher matcher = new SkipPathRequestMatcher(pathsToSkip, pattern);
		JwtTokenAuthenticationProcessingFilter filter = 
				new JwtTokenAuthenticationProcessingFilter(failureHandler, matcher);
		filter.setAuthenticationManager(authManager);
		return filter;
	}

	@Configuration
	@Order(1)
	public class AjaxWebSecurityConfig extends WebSecurityConfigurerAdapter {
		
		@Override
		protected void configure(AuthenticationManagerBuilder auth) throws Exception {
			// TODO Auto-generated method stub
			auth.authenticationProvider(ajaxAuthenticationProvider);
		}

		@Override
		protected void configure(HttpSecurity http) throws Exception {
	
				http.
					csrf().disable()
					.exceptionHandling()
					.authenticationEntryPoint(authenticationEntryPoint)
				
				.and()
					.sessionManagement()
					.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
					
				.and()
					.antMatcher("/api/auth/**")
					.authorizeRequests()
					.antMatchers(AUTHENTICATION_URL)
					.permitAll()
					
					
				.and()
					.addFilterBefore(buildAjaxLoginProcessingFilter(AUTHENTICATION_URL, super.authenticationManager()), UsernamePasswordAuthenticationFilter.class)
					.authenticationProvider(ajaxAuthenticationProvider);
				
		}
		
	}
	
	@Configuration
	public class JwtWebSecurityConfig extends WebSecurityConfigurerAdapter {
		
		@Override
		protected void configure(AuthenticationManagerBuilder auth) throws Exception {
			// TODO Auto-generated method stub
			auth.authenticationProvider(jwtAuthenticationProvider);
		}
		
		@Override
		protected void configure(HttpSecurity http) throws Exception {
			List<String> permitAllEndpointsList = Arrays.asList(
					AUTHENTICATION_URL,
					REFRESH_TOKEN_URL,
					"/console"
				);
			
			http
				.csrf().disable()
				.authorizeRequests()
				.antMatchers("/**").authenticated()
				
				.and()
				.addFilterBefore(buildJwtTokenAuthenticationProcessingFilter(permitAllEndpointsList, API_ROOT_URL, super.authenticationManager()),
					UsernamePasswordAuthenticationFilter.class)
				.authenticationProvider(jwtAuthenticationProvider);
			
		}
		
	}
	
}
