package pl.dn.base;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

@MappedSuperclass
public class BaseDetail {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;

    @Temporal(TemporalType.DATE)
    @JsonFormat
      (shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date creationTime;
   
    
    public BaseDetail() {
		super();
	}

    public BaseDetail(String name, Date creationTime) {
        this.name = name;
        this.creationTime = creationTime;
    }

    public BaseDetail(String name) {
        this.name = name;
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

	public Date getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}


    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", creationTime=" + creationTime +
                '}';
    }
}
