package pl.dn.controller.userManagement;

import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.dn.dao.userType.ModeratorDao;
import pl.dn.model.userType.Moderator;

/**
 * Created by User on 21.08.2017.
 */
@RestController
@RequestMapping(value = "moderators")
public class ModeratorManagement {

    @Autowired
    private ModeratorDao moderatorDao;

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String addModerator(@RequestBody Moderator moderator) {
        return moderatorDao.save(moderator).toString();
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public Moderator getModeratorById(@PathVariable long id) {
        Moderator moderator = moderatorDao.findById(id);
        return moderator;
    }
}
