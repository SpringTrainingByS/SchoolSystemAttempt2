package pl.dn.user.service.add;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pl.dn.user.User;
import pl.dn.user.UserAndPlacePreparations;
import pl.dn.user.complementService.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AddWithDetachedEntity {

    @Autowired
    private UserService userService;

    @Autowired
    private UserAndPlacePreparations preparations;

    @Before
    public void prepareDB() {
        preparations.clearPlacesTablesInDB();
    }

    @Test
    public void addUserWithDetachedPlacesInfoEntityShouldReturnResultOk() {
        User user = preparations.prepareUser();
        user = userService.add(user);
        System.out.println(user);
    }

    @After
    public void clearAllPulledDataIntoDB() {
        //preparations.clearPlacesTablesInDB();
    }


}
