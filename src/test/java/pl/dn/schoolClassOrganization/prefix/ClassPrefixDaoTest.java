package pl.dn.schoolClassOrganization.prefix;

import org.apache.commons.collections4.ListUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import junit.framework.Assert;
import pl.dn.SchoolSystemA2Application;
import pl.dn.schoolClassOrganization.details.prefix.ClassPrefix;
import pl.dn.schoolClassOrganization.details.prefix.ClassPrefixDao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(locations="classpath:test.properties")
public class ClassPrefixDaoTest {
	
	@Autowired
	private ClassPrefixDao cpDao;


	public void TestFind() {
		List<String> keyWords = new ArrayList<String>() {{
			add("a");
			add("b");
		}};

		List<ClassPrefix> cps = new ArrayList<ClassPrefix>();

		for (String keyWord : keyWords) {
		    cps = ListUtils.union(cps,cpDao.findByNameContaining(keyWord));
        }

		System.out.println("Wynik rezultatu: ");
		for (ClassPrefix cp : cps) {
		    System.out.println(cp.toString());
        }

	}

	@Test
	public void TestFindByName() {
		System.out.println("Pobrane informacje");
		System.out.println(cpDao.findByName("z"));
	}

	@Test
	public void TestFindByNameContaining() {
		System.out.println("TestFindByNameContaining");
		List<ClassPrefix> list = cpDao.findByNameContaining("a");

		System.out.println("Pobrane Informacje");

		for (ClassPrefix cp : list) {
			System.out.println(cp.toString());
		}

	}

	
}
