package pl.dn.model.bornInfo;

import pl.dn.model.placeInfo.City;
import pl.dn.model.userType.Student;
import pl.dn.model.userType.User;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by User on 11.08.2017.
 */
@Entity
@Table(name = "student_born_info")
public class StudentBornInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Temporal(TemporalType.DATE)
    @Column(name = "born_date")
    private Date bornDate;

    @Column(name = "city_id", insertable = false, updatable = false)
    private long cityId;

    @Column(name = "student_id", insertable = false, updatable = false)
    private long studentId;

    @ManyToOne
    @JoinColumn(name = "city_id", insertable = false, updatable = false)
    private City city;

    @OneToOne
    @JoinColumn(name = "student_id", insertable = false, updatable = false)
    private Student student;

    public StudentBornInfo() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getBornDate() {
        return bornDate;
    }

    public void setBornDate(Date bornDate) {
        this.bornDate = bornDate;
    }

    public long getCityId() {
        return cityId;
    }

    public void setCityId(long cityId) {
        this.cityId = cityId;
    }

    public long getStudentId() {
        return studentId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
