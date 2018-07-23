package pl.dn.schoolClassOrganization.prefix.history;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import pl.dn.schoolClassOrganization.details.prefix.history.ClassPrefixRegistryDao;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ClassPrefixRegitryDaoTest {
	
	@Autowired
	private ClassPrefixRegistryDao dao;
	
	@Test
	public void findByUserIdTest() {
		
	}
	
}
