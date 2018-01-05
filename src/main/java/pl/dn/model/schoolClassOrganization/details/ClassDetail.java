package pl.dn.model.schoolClassOrganization.details;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class ClassDetail {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;
   
    
    public ClassDetail() {
		super();
	}

	public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
