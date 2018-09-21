package pl.dn.user.creation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.dn.exception.ValidationException;

@RestController
public class UserCreationController {

    private UserCreationService userCreationService;

    @Autowired
    public UserCreationController(UserCreationService userCreationService) {
        this.userCreationService = userCreationService;
    }

    @RequestMapping(value = "/create-user", method =  RequestMethod.POST)
    public UserWithRole addUser(@RequestBody UserWithRole userWithRole) throws ValidationException {
        return userCreationService.addUser(userWithRole);
    }

    @RequestMapping(value = "/update-user", method = RequestMethod.POST)
    public UserWithRole updateUser(@RequestBody UserWithRole userWithRole) throws ValidationException {
        return userCreationService.update(userWithRole);
    }

}
