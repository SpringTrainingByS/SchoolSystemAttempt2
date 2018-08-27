package pl.dn.base.customModels;

import java.util.Date;

public interface BaseDetailRegistryResponse {
	
	public String getDescription();
	public Date getDate();
	
	public long getUserId();
	public String getUserBasicInfoFirstName();
	public String getUserBasicInfoLastName();
	
}
