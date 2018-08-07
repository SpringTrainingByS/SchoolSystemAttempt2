package pl.dn.schoolClassOrganization.details.prefix.history.customModels;

import java.util.Date;

public interface CustomPrefixRegistryResponse {
	
	public String getDescription();
	public Date getDate();
	
	public long getUserId();
	public String getUserBasicInfoFirstName();
	public String getUserBasicInfoLastName();
	
}
