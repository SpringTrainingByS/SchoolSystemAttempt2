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
import pl.dn.bornInfo.UserBornInfo;
import pl.dn.contactInfo.UserContactInfo;
import pl.dn.generalInfo.BasicInfo;
import pl.dn.placeInfo.Address;
import pl.dn.placeInfo.city.City;
import pl.dn.placeInfo.dao.PlaceDaoSet;
import pl.dn.placeInfo.street.Street;
import pl.dn.placeInfo.voivodeship.Voivodeship;
import pl.dn.placeInfo.zipCode.ZipCode;
import pl.dn.user.User;
import pl.dn.user.UserComplementService;

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
    private PlaceDaoSet placeDaoSet;

    @Before
    public void insertPlacesToDB() {
        City city = placeDaoSet.getCityDao().save(placeInfo.getCityRadzyn());
        placeInfo.setCityRadzyn(city);

        City city2 = placeDaoSet.getCityDao().save(placeInfo.getCityUlan());
        placeInfo.setCityUlan(city2);

        Voivodeship voivo1 = placeDaoSet.getVoivodeshipDao().save(placeInfo.getVoivLubelskie());
        placeInfo.setVoivLubelskie(voivo1);

        Voivodeship voivo2 = placeDaoSet.getVoivodeshipDao().save(placeInfo.getVoivMazowieckie());
        placeInfo.setVoivLubelskie(voivo1);

        Street street = placeDaoSet.getStreetDao().save(placeInfo.getStreetRolna());
        placeInfo.setStreetRolna(street);

        ZipCode zipCode = placeDaoSet.getZipCodeDao().save(placeInfo.getZipCode());
        placeInfo.setZipCode(zipCode);
    }
    
    @Test
    public void testFetchPlaceInfoToUser() {
        User user = prepareUser();

        user = complementService.fetchPlaceInfo(user);

        System.out.println(user.toString());

    }

    private User prepareUser() {
        User user = new User();

        UserContactInfo contactInfo = new UserContactInfo();
        BasicInfo basicInfoInfo = new BasicInfo();
        UserBornInfo bornInfo = new UserBornInfo();

        basicInfoInfo.setFirstName("Dariusz");
        basicInfoInfo.setLastName("Nurzyñski");
        basicInfoInfo.setPesel("94061104852");

        contactInfo.setAddress(new Address());
        contactInfo.getAddress().setCity(new City("Ulan"));
        contactInfo.getAddress().setApartmentNumber(5);
        contactInfo.getAddress().setHouseNamber(5);
        contactInfo.getAddress().setStreet(new Street("rolna"));
        contactInfo.getAddress().setVoivodeship(new Voivodeship("lubelskie"));
        contactInfo.getAddress().setZipCode(new ZipCode("21-307"));

        bornInfo.setCity(new City("Radzyñ"));
        bornInfo.setVoivodeship(new Voivodeship("mazowieckie"));

        user.setBornInfo(bornInfo);
        user.setContactInfo(contactInfo);
        user.setBasicInfo(basicInfoInfo);

        return user;
    }

    @After
    public void removeDataFromDb() {
        placeDaoSet.getCityDao().delete(placeInfo.getCityRadzyn().getId());
        placeDaoSet.getCityDao().delete(placeInfo.getCityUlan().getId());

        placeDaoSet.getStreetDao().delete(placeInfo.getStreetRolna().getId());

        placeDaoSet.getVoivodeshipDao().delete(placeInfo.getVoivLubelskie().getId());
        placeDaoSet.getVoivodeshipDao().delete(placeInfo.getVoivMazowieckie().getId());

        placeDaoSet.getZipCodeDao().delete(placeInfo.getZipCode().getId());
    }

}
