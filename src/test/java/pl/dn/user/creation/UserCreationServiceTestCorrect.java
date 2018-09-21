package pl.dn.user.creation;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pl.dn.bornInfo.UserBornInfo;
import pl.dn.contactInfo.UserContactInfo;
import pl.dn.exception.ValidationException;
import pl.dn.generalInfo.BasicInfo;
import pl.dn.placeInfo.Address;
import pl.dn.placeInfo.city.City;
import pl.dn.placeInfo.street.Street;
import pl.dn.placeInfo.voivodeship.Voivodeship;
import pl.dn.placeInfo.zipCode.ZipCode;
import pl.dn.security.role.Role;
import pl.dn.security.role.RoleDao;
import pl.dn.user.User;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserCreationServiceTestCorrect {

    @Autowired
    private UserCreationService userCreationService;

    @Autowired
    private RoleDao roleDao;

    @Test
    public void testAddUserWhenDataIsCorrectShouldReturnUserWithRole() {
        UserWithRole userWithRole = prepareUserWithRole();

        try {
            userCreationService.addUser(userWithRole);
        }
        catch(ValidationException exception) {
            System.out.println(exception.getMessage());
        }

    }

    private UserWithRole prepareUserWithRole() {
        User user = new User();

        user.setBasicInfo(new BasicInfo());
        user.getBasicInfo().setPesel("94061142569");
        user.getBasicInfo().setLastName("Mikaruk");
        user.getBasicInfo().setFirstName("Macha³");

        user.setContactInfo(new UserContactInfo());
        user.getContactInfo().setEmail("scorpion777@gmail.com");
        user.getContactInfo().setPhoneNumber("7778889990");

        Address address = new Address();
        address.setHouseNamber(7);
        address.setApartmentNumber(8);
        address.setZipCode(new ZipCode("21-307"));
        address.setCity(new City("Bia³a Podlaska"));
        address.setStreet(new Street("Polna"));
        address.setVoivodeship(new Voivodeship("lubelskie"));
        user.getContactInfo().setAddress(address);

        user.setBornInfo(new UserBornInfo());
        user.getBornInfo().setBornDate(new Date(2012, 2, 4));
        user.getBornInfo().setCity(new City("Ulan-Majorat"));
        user.getBornInfo().setVoivodeship(new Voivodeship("lubelskie"));

        Role role = roleDao.findById(1);

        UserWithRole userWithRole = new UserWithRole();
        userWithRole.setUser(user);
        userWithRole.setRole(role);

        return userWithRole;

    }



}
