package pl.dn.base.history;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import pl.dn.base.BaseDetail;
import pl.dn.history.Registry;
import pl.dn.history.RegistryDao;
import pl.dn.request.UserContext;

@Service
public class BaseDetailHistoryService<G extends BaseDetail, T extends Registry> {

	private RegistryDao registryDao;
	
	private UserContext userContext;
	
	@Autowired
	public BaseDetailHistoryService(@Qualifier("userContextRequest") UserContext userContext) {
		this.userContext = userContext;
	}

	public T prepareChangesForOne(G element, long userId) {
		return null;
	}
	
	public void registerAdd(G element,T registry) {
		System.out.println("BaseDetailHisotryService.registerAdd: userId: " + userContext.getUserId());
	}
	
	public void registerAddCollection(List<G> elements) {
		
	}
	
	public void registerUpdate(T element,T registry) {
		
	}

	public void setRegistryDao(RegistryDao registryDao) {
		this.registryDao = registryDao;
	}
	
	
}
