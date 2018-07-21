package pl.dn.schoolClassOrganization.occupationalGroup;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.dn.exception.ValidationException;

@Service
public class OccupationalGroupService {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired 
	private OccupationalGroupDao dao;
	
	public void add(OccupationalGroup occupationalGroup) throws ValidationException {
		Session session = sessionFactory.getCurrentSession();
		session.save(occupationalGroup);
	}
	
	public void update(OccupationalGroup occupationalGroup) {
		Session session = sessionFactory.getCurrentSession();
		session.update(occupationalGroup);
	}	
}
