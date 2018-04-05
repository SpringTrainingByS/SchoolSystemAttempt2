package pl.dn.service.jwt.config;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.databind.ObjectMapper;

import pl.dn.service.jwt.RestAuthenticationEntryPoint;
import pl.dn.service.jwt.ajax.AjaxAuthenticationProvider;
import pl.dn.service.jwt.ajax.AjaxAwareAuthenticationFailureHandler;
import pl.dn.service.jwt.ajax.AjaxAwareAuthenticationSuccessHandler;
import pl.dn.service.jwt.ajax.AjaxLoginProcessingFilter;
import pl.dn.service.jwt.common.TokenExtractor;
import pl.dn.service.jwt.jwt.JwtAuthenticationProvider;
import pl.dn.service.jwt.jwt.JwtTokenAuthenticationProcessingFilter;
import pl.dn.service.jwt.jwt.SkipPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

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
	
	protected AjaxLoginProcessingFilter buildAjaxLoginProcessingFilter(String loginEntryPoint) throws Exception {
		AjaxLoginProcessingFilter filter = 
				new AjaxLoginProcessingFilter(loginEntryPoint, successHandler, failureHandler, objectMapper);
		filter.setAuthenticationManager(authenticationManager);
		return filter;
	}
	
	protected JwtTokenAuthenticationProcessingFilter buildJwtTokenAuthenticationProcessingFilter(List<String> pathsToSkip, String pattern) {
		SkipPathRequestMatcher matcher = new SkipPathRequestMatcher(pathsToSkip, pattern);
		JwtTokenAuthenticationProcessingFilter filter = 
				new JwtTokenAuthenticationProcessingFilter(failureHandler, matcher);
		filter.setAuthenticationManager(this.authenticationManager);
		return filter;
	}

	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		// TODO Auto-generated method stub
		return super.authenticationManagerBean();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(ajaxAuthenticationProvider);
		auth.authenticationProvider(jwtAuthenticationProvider);
	}

	

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		List<String> permitAllEndpointsList = Arrays.asList(
			AUTHENTICATION_URL,
			REFRESH_TOKEN_URL,
			"console"
		);
		
		http.
			csrf().disable()
			.exceptionHandling()
			.authenticationEntryPoint(this.authenticationEntryPoint)
		
		.and()
			.sessionManagement()
			.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
			
		.and()
			.authorizeRequests()
			.antMatchers(permitAllEndpointsList.toArray(new String[permitAllEndpointsList.size()]))
			.permitAll()
		.and()
			.authorizeRequests()
			.antMatchers(API_ROOT_URL).authenticated()
		.and()
			.addFilterBefore(buildAjaxLoginProcessingFilter(AUTHENTICATION_URL), UsernamePasswordAuthenticationFilter.class)
			.addFilterBefore(buildJwtTokenAuthenticationProcessingFilter(permitAllEndpointsList, API_ROOT_URL),
					UsernamePasswordAuthenticationFilter.class);
	}
	
}
