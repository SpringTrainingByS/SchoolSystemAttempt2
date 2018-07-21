package pl.dn.controller.userType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import pl.dn.user.User;
import pl.dn.user.UserService;

@RestController
@RequestMapping(value = "users")
@PreAuthorize("hasAuthority('ADMIN')")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public void add(@RequestBody User user) {
		userService.add(user);
	}
	
	@RequestMapping(value = "get/{id}", method = RequestMethod.GET)
	public User get(@PathVariable long id) {
		return userService.getById(id);
	}
	
	@RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable long id) {
		userService.delete(id);
	}
	
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public void update(@RequestBody User user) {
		userService.update(user);
	}

}
