package pl.dn.user.complementService.placeDataInDB;



import org.junit.After;
import org.junit.Before;
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
public class UserComplementServiceTest {

    @Autowired
    private UserComplementService complementService;

    @Autowired
    private PlaceInfo placeInfo;

    @Autowired
    private UserAndPlacePreparations preparations;

    @Before
    public void insertPlacesToDB() {
        preparations.insertPlacesToDB();
    }
    
    @Test
    public void testFetchPlaceInfoToUser() {
        User user = preparations.prepareUser();
        user = complementService.fetchPlaceInfo(user);
        System.out.println(user.toString());
    }


    @After
    public void removeDataFromDb() {
        preparations.removeInsertedPlacesEntitesFromDB();
    }

}
