package pl.dn.base.history;

import java.util.List;

import org.springframework.stereotype.Service;

import pl.dn.base.BaseDetail;
import pl.dn.history.Registry;
import pl.dn.history.RegistryDao;

@Service
public class BaseDetailHistoryService<G extends BaseDetail, T extends Registry> {

	private RegistryDao registryDao;
	
	public T prepareChangesForOne(G element, long userId) {
		return null;
	}
	
	public void registerAddCollection(List<G> elements, long userId) {
		
	}
	
	public void registerAdd(G element, long userId) {
		
	}
	
	public void registerUpdate(T element, long userId) {
		
	}

	public void setRegistryDao(RegistryDao registryDao) {
		this.registryDao = registryDao;
	}
	
	
}
