package pl.dn.base;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.apache.commons.collections4.ListUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import pl.dn.base.history.BaseDetailHistoryService;
import pl.dn.exception.ValidationException;
import pl.dn.history.Registry;
import pl.dn.schoolClassOrganization.details.prefix.ClassPrefix;

@Service
@Transactional
@Scope("prototype")
public class BaseDetailService {
	
	private BaseDetailValidator classDetailValidator;
	
	private BaseDetailHistoryService bdhService;
	
	private BaseDetailDao baseDetailDao;

	private EntityManager em;
	
	@Autowired
	public BaseDetailService(BaseDetailValidator classDetailValidator, EntityManager em) {
		this.classDetailValidator = classDetailValidator;
		this.em = em;
	}

	public BaseDetail add(BaseDetail classDetail, Registry registry, String[] validationPatterns) throws ValidationException {
		
		classDetailValidator.validateBeforeAdd(classDetail, baseDetailDao, validationPatterns);
		classDetail.setCreationTime(new Date());
		em.persist(classDetail);
		bdhService.registerAdd(classDetail, registry);
		
		System.out.println("Data dodanego elementu: " + classDetail.getCreationTime());
		
		return classDetail;
	}
	
	public List<? extends BaseDetail> addSet(List<? extends BaseDetail> classDetailGroup, Registry registry, String[] validationPatterns) throws ValidationException  {
		
		String message = ""; 
		List<Object> detailsToRemove = new ArrayList<Object>();
		
		for (BaseDetail classDetail : classDetailGroup ) {
			try {
				add(classDetail, registry.clone(), validationPatterns);
			}
			catch (ValidationException e) {
				message += "Problem dla encji: " + classDetail.getName() + ": ";
				message += e.getMessage();
				detailsToRemove.add(classDetail);
			} catch (CloneNotSupportedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			
		}
		
		if (!message.isEmpty()) {
			
			for (Object detailToRemove : detailsToRemove) {
				classDetailGroup.remove(detailToRemove);
			}
			
			throw new ValidationException(message, classDetailGroup);
		}
		
		return classDetailGroup;
	}
	
	public BaseDetail findById(long id) {
		BaseDetail bd = baseDetailDao.findById(id);
		System.out.println("Pobrana data elementu: " + bd.getCreationTime());
		return baseDetailDao.findById(id);
	}
	
	public List<? extends BaseDetail> findByPagination(int limit, int offset) {
		return (List<ClassPrefix>) baseDetailDao.findUsePagination(limit, offset);
	}
	
	public void update(BaseDetail classDetail, Registry registry, String[] validationPatterns) throws ValidationException {
		classDetailValidator.validateBeforeUpdate(classDetail, baseDetailDao, validationPatterns);
		System.out.println("Update preiksu klasy");
		bdhService.registerUpdate(classDetail, registry);
		em.merge(classDetail);
		System.out.println("Update prefiksu klasy zakoñczony powodzeniem");
		
		System.out.println("Procedura aktualizacji prefiksu zakoñczona powodzeniem");
	}
	
	public List<? extends BaseDetail> findAll() {
		return baseDetailDao.findAll();
	}
	
	public void deleteById(long id) {
		baseDetailDao.deleteById(id);
	}
	
	public long count() {
		return baseDetailDao.count();
	}

	public void setBaseDetailDao(BaseDetailDao<?> baseDetailDao) {
		this.baseDetailDao = baseDetailDao;
	}
	
	public void setBdhService(BaseDetailHistoryService<?, ?> bdhService) {
		this.bdhService = bdhService;
	}

	public List<? extends BaseDetail> find(List<String> keyWords) {

		List<? extends BaseDetail> result = new ArrayList<>();

		for (String keyWord : keyWords) {
			result = ListUtils.union(result,baseDetailDao.findByNameContaining(keyWord));
		}

		return result;
	}
}
