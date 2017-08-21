package pl.dn.model.userType;

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

    @OneToOne(mappedBy = "student")
    private StudentContactInfo contactInfo;

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
}
