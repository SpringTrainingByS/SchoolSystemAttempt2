package pl.dn.logger;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import pl.dn.user.User;

@Entity
public class Correction {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	@ManyToOne
	@JoinColumn(name = "class_name_id")
	private CorrectionClassName className;
	
	@ManyToOne
	@JoinColumn(name = "class_field_id")
	private CorrectionFieldName fieldName;
	
	private String description;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public CorrectionClassName getClassName() {
		return className;
	}

	public void setClassName(CorrectionClassName className) {
		this.className = className;
	}

	public CorrectionFieldName getFieldName() {
		return fieldName;
	}

	public void setFieldName(CorrectionFieldName fieldName) {
		this.fieldName = fieldName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
