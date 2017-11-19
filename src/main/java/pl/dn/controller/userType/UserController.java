package pl.dn.controller.userType;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import pl.dn.model.userType.User;

@RestController("/users")
public class UserController {
	
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public void add(@RequestBody User user) {
		
	}

}
