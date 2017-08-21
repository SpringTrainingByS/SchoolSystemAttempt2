package pl.dn.model.schoolClassOrganization;

import javax.persistence.*;

/**
 * Created by User on 14.08.2017.
 */
@Entity
@Table(name = "student_school_class")
public class StudentSchoolClass {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "student_id")
    private long studentId;

    @Column(name = "school_class_id")
    private long schoolClassId;

    public StudentSchoolClass() {
    }

    public long getStudentId() {
        return studentId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    public long getSchoolClassId() {
        return schoolClassId;
    }

    public void setSchoolClassId(long schoolClassId) {
        this.schoolClassId = schoolClassId;
    }
}
