package pl.dn.user.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pl.dn.user.User;
import pl.dn.user.UserDao;
import pl.dn.user.model.UserParams;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FindByBasicInfoTest {

    @Autowired
    private UserDao userDao;

    @Test
    public void testFindByBasicInfoShouldReturnUserList() {
        UserParams userParams = new UserParams("Irena", "Wierzchowska", "");

        List<User> users = userDao.findByBasicInfo("Irena", "Wierzchowska", "");

        for (User user : users) {
            System.out.println(user.toString());
        }
    }



}
