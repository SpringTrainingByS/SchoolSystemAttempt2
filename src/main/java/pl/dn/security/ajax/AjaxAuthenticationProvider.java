package pl.dn.security.ajax;

import java.util.ArrayList;
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

import pl.dn.security.role.Role;
import pl.dn.userLogin.LoginInfo;
import pl.dn.userLogin.UserLoginDao;


@Service
public class AjaxAuthenticationProvider implements AuthenticationProvider {
	
	private final BCryptPasswordEncoder encoder;
	private final UserLoginDao userLoginDao;
	
	@Autowired
	public AjaxAuthenticationProvider(final BCryptPasswordEncoder encoder, final UserLoginDao userLoginDao) {
		this.encoder = encoder;
		this.userLoginDao = userLoginDao;
	}

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		
		System.out.println("AjaxAuthenticationProvider: authenticate");

		String username = (String) authentication.getPrincipal();
		String password = (String) authentication.getCredentials();
		
		LoginInfo loginInfo = userLoginDao.findByUsername(username);
		
		if (loginInfo == null) {
			throw new UsernameNotFoundException("User not found: " + username);
		}
		
		if (!password.equals(loginInfo.getPassword())) {
			throw new BadCredentialsException("Authentication Failed. Username or password not valid");
		}

		List<Role> roles = new ArrayList<Role>();
		roles.add(loginInfo.getRole());

		return new UsernamePasswordAuthenticationToken(loginInfo, null, (Collection<? extends GrantedAuthority>) roles);
	}

	@Override
	public boolean supports(Class<?> authentication) {
		
		System.out.println("AjaxAuthenticationProvider: supports");
		return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
	}

}
