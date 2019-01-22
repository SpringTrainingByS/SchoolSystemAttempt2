package pl.dn.schoolClassOrganization.occupationalGroup;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.dn.exception.ValidationException;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Service
public class OccupationalGroupService {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	private EntityManager em;
	
	@Autowired 
	private OccupationalGroupDao dao;

	@Transactional
	public void add(OccupationalGroup occupationalGroup) throws ValidationException {
//		Session session = sessionFactory.getCurrentSession();
		em.persist(occupationalGroup);
	}
	
	public void update(OccupationalGroup occupationalGroup) {
		Session session = sessionFactory.getCurrentSession();
		session.update(occupationalGroup);
	}

	public List<OccupationalGroup> findByPagination(int limit, int offset) {
		return dao.findByPagination(limit, offset);
	}
}
