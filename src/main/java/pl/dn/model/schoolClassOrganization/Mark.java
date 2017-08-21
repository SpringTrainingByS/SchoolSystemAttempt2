package pl.dn.model.schoolClassOrganization;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by User on 17.08.2017.
 */

@Entity
public class Mark {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "student_id")
    private long studentId;

    @Column(name = "occupational_group_id")
    private long occupationalGroupId;

    @Column(name = "credit_id")
    private long creditId;

    @Temporal(TemporalType.DATE)
    @Column(name = "insert_date")
    private Date insertDate;

    public Mark() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getStudentId() {
        return studentId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    public long getOccupationalGroupId() {
        return occupationalGroupId;
    }

    public void setOccupationalGroupId(long occupationalGroupId) {
        this.occupationalGroupId = occupationalGroupId;
    }

    public long getCreditId() {
        return creditId;
    }

    public void setCreditId(long creditId) {
        this.creditId = creditId;
    }

    public Date getInsertDate() {
        return insertDate;
    }

    public void setInsertDate(Date insertDate) {
        this.insertDate = insertDate;
    }
}
