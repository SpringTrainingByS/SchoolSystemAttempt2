package pl.dn.userLogin;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pl.dn.user.User;

import javax.transaction.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class UserLoginDaoTest {

    @Autowired
    private UserLoginDao dao;

    @Test
    public void testFindByUserId() {
        long userId = 15;
        UserLogin userLogin = dao.findByUserId(userId);
        System.out.println(userLogin.getUser().toString());
    }

}
