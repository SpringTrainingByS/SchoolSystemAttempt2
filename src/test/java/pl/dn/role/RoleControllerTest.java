package pl.dn.role;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pl.dn.security.role.Role;
import pl.dn.security.role.RoleController;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RoleControllerTest {

    @Autowired
    private RoleController roleController;

    @Test
    public void testGetAll() {
        List<Role> roles = roleController.getAll();

        System.out.println("Pobrane role: ========================================");
        for (Role role : roles) {
            System.out.println(role.getName());
        }
    }

}
