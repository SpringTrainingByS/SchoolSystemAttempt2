package pl.dn.base.history;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

import pl.dn.base.BaseDetail;
import pl.dn.base.BaseDetailDao;
import pl.dn.history.Registry;
import pl.dn.user.User;

@Service
@Scope("prototype")
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
		
		BaseDetail oldElement = baseDetailDao.findById(element.getId());
		String description = "Nazwa zmieniona: \"" + oldElement.getName() + "\" na \"" + element.getName() + "\".";
		long userId = (long) request.getAttribute("userId");
		
		registry.setAuthor(em.getReference(User.class, userId));
		
		registry.setDate(new Date());
		registry.setEntity(element);
		registry.setDescription(description);
		
		System.out.println("Próba zapisu registry");
		em.persist(registry);
		System.out.println("Zapis registry zakoñczony powodzeniem");
		
	}

	public void setBaseDetailDao(BaseDetailDao baseDetailDao) {
		this.baseDetailDao = baseDetailDao;
	}
	
}
