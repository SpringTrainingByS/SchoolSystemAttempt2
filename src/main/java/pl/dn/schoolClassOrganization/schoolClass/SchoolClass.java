package pl.dn.schoolClassOrganization.schoolClass;

import java.util.Calendar;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;

import org.hibernate.annotations.JoinColumnOrFormula;
import pl.dn.schoolClassOrganization.details.classType.ClassType;
import pl.dn.schoolClassOrganization.details.prefix.ClassPrefix;
import pl.dn.schoolClassOrganization.details.specialization.ClassSpecialization;
import pl.dn.user.User;

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

    @OneToMany
    @JoinTable(name = "student_school_class",
            joinColumns = @JoinColumn(name = "school_class_id"),
            inverseJoinColumns = @JoinColumn(name = "student_id")
    )
    private List<User> students;

    @OneToOne
    @JoinTable(name = "form_tutor_shool_class",
        joinColumns = @JoinColumn(name = "class_id"),
        inverseJoinColumns = @JoinColumn(name = "teacher_id")
    )
    private User tutor;

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

    public List<User> getStudents() {
        return students;
    }

    public void setStudents(List<User> students) {
        this.students = students;
    }

    public User getTutor() {
        return tutor;
    }

    public void setTutor(User tutor) {
        this.tutor = tutor;
    }
}
