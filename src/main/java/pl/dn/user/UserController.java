package pl.dn.user;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.dn.exception.ValidationException;
import pl.dn.user.model.UserParams;

import java.util.List;

@RestController
@RequestMapping(value = "users")
//@PreAuthorize("hasAuthority('ADMIN')")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public void add(@RequestBody User user) throws ValidationException {
		System.out.println("add Dosz³o");
		userService.add(user);
	}
	
	@RequestMapping(value = "/number", method = RequestMethod.GET)
	public long getNumber() {
		long userNumber = userService.getNumber();
		return userNumber;
	}

	@RequestMapping(value = "get/{id}", method = RequestMethod.GET)
	public User get(@PathVariable long id) {
		System.out.println("Get user by id");
		User user = userService.getById(id);
		return user;
	}

	@RequestMapping(value = "get/all", method = RequestMethod.GET)
	public List<User> getAll() {
		List<User> users = userService.getAll();
		System.out.println("User counts: " + users.size());
		return users;
	}

	@RequestMapping(value = "get", params = {"limit", "offset"}, method = RequestMethod.GET)
	public List<User> getByPagination(@RequestParam("limit") int limit, @RequestParam("offset") int offset) {
		System.out.println("Limit: " + limit);
		System.out.println("offset: " + offset);
		return userService.getByPagination(limit, offset);
	}
	
	@RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable long id) {
		userService.delete(id);
	}
	
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public void update(@RequestBody User user) throws ValidationException {
		userService.update(user);
	}

	@RequestMapping(value = "find", params = {"role"}, method = RequestMethod.POST)
	public List<User> find(@RequestBody UserParams userParams, @RequestParam("role") String role) {
		return userService.findByBasicInfo(userParams, role);
	}

}
