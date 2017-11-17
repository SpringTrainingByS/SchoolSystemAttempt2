package pl.dn.model.timeOrganization;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "school_hour")
public class SchoolHour {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
	
	@Column(name = "range_desc")
	private String rangeDesc;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getRangeDesc() {
		return rangeDesc;
	}

	public void setRangeDesc(String rangeDesc) {
		this.rangeDesc = rangeDesc;
	}
	
	

	
}
