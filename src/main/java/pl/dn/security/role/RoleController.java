package pl.dn.security.role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "roles")
public class RoleController {

    private RoleDao dao;

    @Autowired
    public RoleController(RoleDao dao) {
        this.dao = dao;
    }

    @RequestMapping(value = "get/all", method = RequestMethod.GET)
    public List<Role> getAll() {
        return dao.findAll();
    }

}
