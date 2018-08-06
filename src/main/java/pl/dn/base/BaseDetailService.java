package pl.dn.base;

import java.lang.reflect.Constructor;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.dn.base.history.BaseDetailHistoryService;
import pl.dn.exception.ValidationException;
import pl.dn.history.Registry;
import pl.dn.schoolClassOrganization.details.prefix.ClassPrefix;



@Service
@Transactional
public class BaseDetailService {

	private SessionFactory sessionFactory;
	
	private BaseDetailValidator classDetailValidator;
	
	private BaseDetailHistoryService bdhService;
	
	private BaseDetailDao baseDetailDao;
	
	@Autowired
	private EntityManager em;
	
	@Autowired
	public BaseDetailService(SessionFactory sessionFactory, BaseDetailValidator classDetailValidator) {
		this.sessionFactory = sessionFactory;
		this.classDetailValidator = classDetailValidator;
	}

	public void add(BaseDetail classDetail, Registry registry, String[] validationPatterns) throws ValidationException {
		
		classDetailValidator.validateBeforeAdd(classDetail, baseDetailDao, validationPatterns);
		classDetail.setCreationTime(new Date());
		em.persist(classDetail);
		bdhService.registerAdd(classDetail, registry);
	}
	
	public void addSet(List<? extends BaseDetail> classDetailGroup, Registry registry, String[] validationPatterns) throws ValidationException  {
		
		String message = "";
		
		for (BaseDetail classDetail : classDetailGroup ) {
			try {
				classDetailValidator.validateBeforeAdd(classDetail, baseDetailDao, validationPatterns);
				classDetail.setCreationTime(new Date());
				em.persist(classDetail);
				
				Class c = Class.forName(registry.getClass().getName());
				Registry obj = (Registry) c.newInstance();
				
				bdhService.registerAdd(classDetail, obj);
			}
			catch (ValidationException e) {
				message += "Problem dla encji: " + classDetail.getName() + ": ";
				message += e.getMessage();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (!message.isEmpty()) {
			throw new ValidationException(message);
		}
		
		
	}
	
	public BaseDetail findById(long id) {
		return baseDetailDao.findById(id);
	}
	
	public List<? extends BaseDetail> findByPagination(int limit, int offset) {
		return (List<ClassPrefix>) baseDetailDao.findByPagination(limit, offset);
	}
	
	public void update(BaseDetail classDetail, Registry registry, String[] validationPatterns) throws ValidationException {
		classDetailValidator.validateBeforeUpdate(classDetail, baseDetailDao, validationPatterns);
		System.out.println("Update preiksu klasy");
		bdhService.registerUpdate(classDetail, registry);
		em.merge(classDetail);
		System.out.println("Update prefiksu klasy zakończony powodzeniem");
		
		System.out.println("Procedura aktualizacji prefiksu zakończona powodzeniem");
	}
	
	public List<? extends BaseDetail> findAll() {
		return baseDetailDao.findAll();
	}
	
	public void deleteById(long id) {
		baseDetailDao.deleteById(id);
	}

	public void setBaseDetailDao(BaseDetailDao<?> baseDetailDao) {
		this.baseDetailDao = baseDetailDao;
	}
	
	public void setBdhService(BaseDetailHistoryService<?, ?> bdhService) {
		this.bdhService = bdhService;
	}

	
}
