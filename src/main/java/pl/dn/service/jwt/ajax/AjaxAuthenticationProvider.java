package pl.dn.service.jwt.ajax;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import pl.dn.dao.security.UserRoleDao;
import pl.dn.dao.userType.UserLoginDao;
import pl.dn.model.security.UserRoleOnly;
import pl.dn.service.jwt.common.UserLoginInfo;

@Service
public class AjaxAuthenticationProvider implements AuthenticationProvider {
	
	private final BCryptPasswordEncoder encoder;
	private final UserLoginDao userLoginDao;
	private final UserRoleDao userRoleDao;
	
	@Autowired
	public AjaxAuthenticationProvider(final BCryptPasswordEncoder encoder, final UserLoginDao userLoginDao, final UserRoleDao userRoleDao) {
		this.encoder = encoder;
		this.userLoginDao = userLoginDao;
		this.userRoleDao = userRoleDao;
	}

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		
		System.out.println("AjaxAuthenticationProvider: authenticate");
		
		String username = (String) authentication.getPrincipal();
		String password = (String) authentication.getCredentials();
		
		UserLoginInfo userLoginInfo = userLoginDao.findByUsername(username);
		
		if (userLoginInfo == null) {
			throw new UsernameNotFoundException("User not found: " + username);
		}
		
		if (!encoder.matches(password, userLoginInfo.getPassword())) {
			throw new BadCredentialsException("Authentication Failed. Username or password not valid");
		}
		
		long userId = userLoginDao.findIdByUsername(username);
		List<UserRoleOnly> roles = userRoleDao.findByUserLoginId(userId);
		
		return new UsernamePasswordAuthenticationToken(username, null, (Collection<? extends GrantedAuthority>) roles);
	}

	@Override
	public boolean supports(Class<?> authentication) {
		
		System.out.println("AjaxAuthenticationProvider: supports");
		return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
	}

}
