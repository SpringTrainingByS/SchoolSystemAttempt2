package pl.dn.user.complementService.placeDataNoDB;



import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import pl.dn.user.User;
import pl.dn.user.complementService.UserComplementService;
import pl.dn.user.UserAndPlacePreparations;

@RunWith(SpringRunner.class)
@SpringBootTest
@ComponentScan("pl.dn.user.complementService")
@TestPropertySource(locations="classpath:test.properties")
public class UserComplementServiceTestWithNoDataInDB {

    @Autowired
    private UserComplementService complementService;

    @Autowired
    private UserAndPlacePreparations preparations;

    @Test
    public void completeUserReturnUserContainPlacesInfoFromDBIfExsists() {
        User user = preparations.prepareUser();
        user = complementService.fetchPlaceInfo(user);
        preparations.retrievePlaceInfo(user);
        System.out.println("User Result ===============================================");
        System.out.println(user);
    }

    @After
    public void removeDataFromDb() {
        preparations.removeInsertedPlacesEntitesFromDB();
    }

}
