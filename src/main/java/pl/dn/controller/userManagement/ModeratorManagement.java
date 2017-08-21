package pl.dn.controller.userManagement;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by User on 21.08.2017.
 */
@RestController
public class ModeratorManagement {

    @RequestMapping("moderators/add")
    public String addModerator() {
        return "Hello";
    }

}
