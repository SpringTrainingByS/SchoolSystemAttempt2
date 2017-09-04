package pl.dn.controller.userManagement;

import com.sun.org.apache.xpath.internal.operations.Mod;
import org.apache.coyote.http11.filters.VoidOutputFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.dn.dao.placeInfo.CityDao;
import pl.dn.dao.userType.ModeratorDao;
import pl.dn.model.placeInfo.City;
import pl.dn.model.placeInfo.Street;
import pl.dn.model.placeInfo.Voivodeship;
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
    private ModeratorService moderatorService;


    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String add(@RequestBody Moderator moderator) {

        return moderatorService.save(moderator).toString();

    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public Moderator getById(@PathVariable long id) {

        Moderator moderator = moderatorService.findById(id);
        return moderator;

    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable long id) {

        moderatorService.delete(id);

    }
}
