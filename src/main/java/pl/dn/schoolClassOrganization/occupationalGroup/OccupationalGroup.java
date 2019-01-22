package pl.dn.schoolClassOrganization.occupationalGroup;

import java.util.Date;

import javax.persistence.CascadeType;
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

import pl.dn.schoolClassOrganization.schoolClass.SchoolClass;
import pl.dn.schoolClassOrganization.schoolSubject.SchoolSubject;
import pl.dn.user.User;

/**
 * Created by User on 17.08.2017.
 */
@Entity
@Table(name = "occupational_group")
public class OccupationalGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private User teacher;

    @ManyToOne
    @JoinColumn(name = "school_class_id")
    private SchoolClass schoolClass;

    @ManyToOne
    @JoinColumn(name = "school_subject_id")
    private SchoolSubject schoolSubject;

    @Temporal(TemporalType.DATE)
    @Column(name = "create_date")
    private Date createDate;

    public OccupationalGroup() {
    }

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public User getTeacher() {
		return teacher;
	}

	public void setTeacher(User teacher) {
		this.teacher = teacher;
	}

	public SchoolClass getSchoolClass() {
		return schoolClass;
	}

	public void setSchoolClass(SchoolClass schoolClass) {
		this.schoolClass = schoolClass;
	}

	public SchoolSubject getSchoolSubject() {
		return schoolSubject;
	}

	public void setSchoolSubject(SchoolSubject schoolSubject) {
		this.schoolSubject = schoolSubject;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

}
