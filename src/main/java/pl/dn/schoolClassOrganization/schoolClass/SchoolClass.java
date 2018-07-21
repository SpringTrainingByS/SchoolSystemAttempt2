package pl.dn.schoolClassOrganization.schoolClass;

import java.util.Calendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

import pl.dn.schoolClassOrganization.details.classType.ClassType;
import pl.dn.schoolClassOrganization.details.prefix.ClassPrefix;
import pl.dn.schoolClassOrganization.details.specialization.ClassSpecialization;

/**
 * Created by User on 14.08.2017.
 */
@Entity
@Table(name = "school_class")
public class SchoolClass {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Temporal(TemporalType.DATE)
    @Column(name = "start_date", updatable = false)
    @JsonFormat(pattern="yyyy-MM-dd")
    private Calendar startDate;

    @ManyToMany
    @JoinTable(
    		name = "schoolclass_classspecialization",
    		joinColumns = @JoinColumn(
    				name = "schoolclass_id",
    				referencedColumnName = "id"),
    		inverseJoinColumns = @JoinColumn(
    				name = "classspecialization_id",
    				referencedColumnName = "id"
    				)
    		)
    private List<ClassSpecialization> classSpecializationList;

    @ManyToOne
    @JoinColumn(name = "type_id")
    private ClassType type;

    @ManyToOne
    @JoinColumn(name = "prefix_id")
    private ClassPrefix prefix;

    public SchoolClass() {
    }

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Calendar getStartDate() {
		return startDate;
	}

	public void setStartDate(Calendar startDate) {
		this.startDate = startDate;
	}

	public List<ClassSpecialization> getClassSpecializationList() {
		return classSpecializationList;
	}

	public void setClassSpecializationList(List<ClassSpecialization> classSpecializationList) {
		this.classSpecializationList = classSpecializationList;
	}

	public ClassType getType() {
		return type;
	}

	public void setType(ClassType type) {
		this.type = type;
	}

	public ClassPrefix getPrefix() {
		return prefix;
	}

	public void setPrefix(ClassPrefix prefix) {
		this.prefix = prefix;
	}

    
}
