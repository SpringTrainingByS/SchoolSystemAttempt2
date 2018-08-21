package pl.dn.schoolClassOrganization.prefix;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import junit.framework.Assert;
import pl.dn.schoolClassOrganization.details.prefix.ClassPrefix;


@RunWith(SpringRunner.class)
@DataJpaTest
public class ClassPrefixDaoTest {
	
//	@Autowired
//	private ClassPrefixDao cpDao;
	
//	@Test
//	public void TestFind() {
//		List<String> keyWords = new ArrayList<String>() {{
//			add("a");
//			add("b");
//		}};
//		
//		List<ClassPrefix> cp = cpDao.containsKeyWords(keyWords);
//		
//		System.out.println(cp);
//		System.out.println("koniec testu");
//		
//		Assert.assertNotNull(cp);
//	}
	
	@Test
	public void TestNothing() {
		Assert.assertNotNull(new ClassPrefix());
	}
	
}
