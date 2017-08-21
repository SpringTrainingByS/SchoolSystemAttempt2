package pl.dn.model.userType;

import pl.dn.model.bornInfo.StudentBornInfo;
import pl.dn.model.contactInfo.StudentContactInfo;
import pl.dn.model.generalInfo.BasicInfo;

import javax.persistence.*;

/**
 * Created by User on 11.08.2017.
 */
@Entity
public class Student extends User{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Embedded
    private BasicInfo basicInfo;


    @OneToOne
    @JoinColumn(name = "student_contact_info_id")
    private StudentContactInfo contactInfo;

    @OneToOne
    @JoinColumn(name = "student_born_info_id")
    private StudentBornInfo bornInfo;

    public Student() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public BasicInfo getBasicInfo() {
        return basicInfo;
    }

    public void setBasicInfo(BasicInfo basicInfo) {
        this.basicInfo = basicInfo;
    }

    public StudentContactInfo getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(StudentContactInfo contactInfo) {
        this.contactInfo = contactInfo;
    }

    public StudentBornInfo getBornInfo() {
        return bornInfo;
    }

    public void setBornInfo(StudentBornInfo bornInfo) {
        this.bornInfo = bornInfo;
    }
}
