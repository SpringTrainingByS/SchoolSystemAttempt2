package pl.dn.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.databind.ObjectMapper;

import pl.dn.security.RestAuthenticationEntryPoint;
import pl.dn.security.ajax.AjaxAuthenticationProvider;
import pl.dn.security.ajax.AjaxAwareAuthenticationFailureHandler;
import pl.dn.security.ajax.AjaxAwareAuthenticationSuccessHandler;
import pl.dn.security.ajax.AjaxLoginProcessingFilter;
import pl.dn.security.jwt.JwtAuthenticationProvider;
import pl.dn.security.jwt.JwtTokenAuthenticationProcessingFilter;


@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class  WebSecurityConfig {

	public static final String AUTHENTICATION_HEADER_NAME = "Authorization";
    public static final String AUTHENTICATION_URL = "/auth/login";
    public static final String REFRESH_TOKEN_URL = "/auth/token";
    public static final String API_ROOT_URL = "/**";
	
	
	@Autowired private RestAuthenticationEntryPoint authenticationEntryPoint;
	@Autowired private AjaxAwareAuthenticationSuccessHandler successHandler;
	@Autowired private AjaxAwareAuthenticationFailureHandler failureHandler;
	@Autowired private AjaxAuthenticationProvider ajaxAuthenticationProvider;
	@Autowired private JwtAuthenticationProvider jwtAuthenticationProvider;
	
	@Autowired private ObjectMapper objectMapper;
	
	protected  AjaxLoginProcessingFilter buildAjaxLoginProcessingFilter(String loginEntryPoint,
			AuthenticationManager  authManager) throws Exception {
		AjaxLoginProcessingFilter filter = 
				new AjaxLoginProcessingFilter(loginEntryPoint, successHandler, failureHandler, objectMapper);
		filter.setAuthenticationManager(authManager);
		return filter;
	}
	
	protected JwtTokenAuthenticationProcessingFilter buildJwtTokenAuthenticationProcessingFilter(String urlForFilter,
			AuthenticationManager authManager) {
		JwtTokenAuthenticationProcessingFilter filter = 
				new JwtTokenAuthenticationProcessingFilter(failureHandler, urlForFilter);
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
					.antMatcher("/auth/**")
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
		
			http
				.csrf().disable()
				.authorizeRequests()
				.antMatchers("/**").authenticated()
				
				.and()
				.addFilterBefore(buildJwtTokenAuthenticationProcessingFilter(API_ROOT_URL, super.authenticationManager()),
					UsernamePasswordAuthenticationFilter.class)
				.authenticationProvider(jwtAuthenticationProvider);
			
		}
		
	}
	
}
