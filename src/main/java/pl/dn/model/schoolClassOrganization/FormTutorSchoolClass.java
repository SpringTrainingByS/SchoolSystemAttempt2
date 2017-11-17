package pl.dn.model.schoolClassOrganization;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import pl.dn.model.userType.User;

/**
 * Created by User on 14.08.2017.
 */
@Entity
@Table(name = "form_tutor_shool_class")
public class FormTutorSchoolClass {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
	
    @OneToOne
    @JoinColumn(name = "teacher_id")
    private User teacher;

    @OneToOne
    @JoinColumn(name = "class_id")
    private SchoolClass school;

    public FormTutorSchoolClass() {
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

	public SchoolClass getSchool() {
		return school;
	}

	public void setSchool(SchoolClass school) {
		this.school = school;
	}

    
}
