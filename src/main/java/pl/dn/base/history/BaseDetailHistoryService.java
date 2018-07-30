package pl.dn.base.history;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.dn.base.BaseDetail;
import pl.dn.base.BaseDetailDao;
import pl.dn.history.Registry;
import pl.dn.history.RegistryDao;
import pl.dn.user.User;

@Service
public class BaseDetailHistoryService<G extends BaseDetail, T extends Registry> {

	private BaseDetailDao baseDetailDao;
	
	private HttpServletRequest request;
	
	private EntityManager em;
	
	@Autowired
	public BaseDetailHistoryService(HttpServletRequest request, EntityManager em) {
		this.request = request;
		this.em = em;
	}

	public T prepareChangesForOne(G element, long userId) {
		return null;
	}
	
	public void registerAdd(G element,T registry) {
		
		String description = "Utworzono";
		
		long userId = (long) request.getAttribute("userId");
		registry.setAuthor(em.getReference(User.class, userId));
		registry.setDescription(description);
		registry.setDate(new Date());
		registry.setEntity(element);
		
		em.persist(registry);
	}

	public void registerUpdate(G element,T registry) {
		
		String oldName = baseDetailDao.findNameById(element.getId());
		String description = "Nazwa zmieniona z " + oldName + " na " + element.getName() + ".";
		long userId = (long) request.getAttribute("userId");
		
		registry.setAuthor(em.getReference(User.class, userId));
		
		registry.setDate(new Date());
		registry.setEntity(element);
		registry.setDescription(description);
		
	}

	public void setBaseDetailDao(BaseDetailDao baseDetailDao) {
		this.baseDetailDao = baseDetailDao;
	}
	
}
