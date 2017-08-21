package pl.dn.model.schoolClassOrganization;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by User on 14.08.2017.
 */
@Entity
@Table(name = "form_tutor_shool_class")
public class FormTutorSchoolClass implements Serializable{

    @Id
    @Column(name = "teacher_id")
    private long teacherId;

    @Id
    @Column(name = "class_id")
    private long classId;

    public FormTutorSchoolClass() {
    }

    public long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(long teacherId) {
        this.teacherId = teacherId;
    }

    public long getClassId() {
        return classId;
    }

    public void setClassId(long classId) {
        this.classId = classId;
    }
}
