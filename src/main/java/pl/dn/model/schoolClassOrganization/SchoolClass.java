package pl.dn.model.schoolClassOrganization;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import pl.dn.model.schoolClassOrganization.details.ClassPrefix;
import pl.dn.model.schoolClassOrganization.details.ClassSpecialization;
import pl.dn.model.schoolClassOrganization.details.ClassType;

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
    @Column(name = "start_date")
    private Date startDate;

    @ManyToOne
    @JoinColumn(name = "specialization_id")
    private ClassSpecialization specialization;

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

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public ClassSpecialization getSpecialization() {
		return specialization;
	}

	public void setSpecialization(ClassSpecialization specialization) {
		this.specialization = specialization;
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
