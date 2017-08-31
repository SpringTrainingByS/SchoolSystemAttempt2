package pl.dn.controller.userManagement;

import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.dn.dao.placeInfo.CityDao;
import pl.dn.dao.userType.ModeratorDao;
import pl.dn.model.placeInfo.City;
import pl.dn.model.userType.Moderator;
import pl.dn.service.userType.ModeratorService;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by User on 21.08.2017.
 */
@RestController
@RequestMapping(value = "moderators")
public class ModeratorManagement {

    @Autowired
    private ModeratorDao moderatorDao;

    @Autowired ModeratorService moderatorService;

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String add(@RequestBody Moderator moderator) {

        return moderatorService.save(moderator).toString();

    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public Moderator getById(@PathVariable long id) {

        Moderator moderator = moderatorDao.findById(id);
        return moderator;

    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable long id){

        moderatorDao.delete(id);

    }
}
