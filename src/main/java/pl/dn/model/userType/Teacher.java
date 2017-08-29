package pl.dn.model.userType;

import pl.dn.model.bornInfo.TeacherBornInfo;
import pl.dn.model.contactInfo.TeacherContactInfo;
import pl.dn.model.generalInfo.BasicInfo;

import javax.persistence.*;

/**
 * Created by User on 11.08.2017.
 */
@Entity
public class Teacher extends User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Embedded
    private BasicInfo basicInfo;

    @OneToOne
    @JoinColumn(name = "contact_info_id")
    private TeacherContactInfo teacherContactInfo;

    @OneToOne
    @JoinColumn(name = "born_info_id")
    private TeacherBornInfo bornInfo;


    public Teacher() {
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

    public TeacherContactInfo getTeacherContactInfo() {
        return teacherContactInfo;
    }

    public void setTeacherContactInfo(TeacherContactInfo teacherContactInfo) {
        this.teacherContactInfo = teacherContactInfo;
    }

    public TeacherBornInfo getBornInfo() {
        return bornInfo;
    }

    public void setBornInfo(TeacherBornInfo bornInfo) {
        this.bornInfo = bornInfo;
    }
}
