package pl.dn.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.dn.exception.ValidationException;

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
	
	@RequestMapping(value = "get/{id}", method = RequestMethod.GET)
	public User get(@PathVariable long id) {
		return userService.getById(id);
	}

	@RequestMapping(value = "get/all", method = RequestMethod.GET)
	public List<User> getAll() {
		return userService.getAll();
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

}
