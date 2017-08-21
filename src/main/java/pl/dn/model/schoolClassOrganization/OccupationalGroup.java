package pl.dn.model.schoolClassOrganization;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by User on 17.08.2017.
 */
@Entity
@Table(name = "occupational_group")
public class OccupationalGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "teacher_id")
    private long teacherId;

    @Column(name = "school_class_id")
    private long schoolClassId;

    @Column(name = "school_subject_id")
    private long schoolSubjectId;

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

    public long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(long teacherId) {
        this.teacherId = teacherId;
    }

    public long getSchoolClassId() {
        return schoolClassId;
    }

    public void setSchoolClassId(long schoolClassId) {
        this.schoolClassId = schoolClassId;
    }

    public long getSchoolSubjectId() {
        return schoolSubjectId;
    }

    public void setSchoolSubjectId(long schoolSubjectId) {
        this.schoolSubjectId = schoolSubjectId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
