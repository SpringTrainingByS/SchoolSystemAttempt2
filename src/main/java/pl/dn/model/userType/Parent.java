package pl.dn.model.userType;

import pl.dn.model.bornInfo.ParentBornInfo;
import pl.dn.model.contactInfo.ParentContactInfo;
import pl.dn.model.generalInfo.BasicInfo;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by User on 11.08.2017.
 */
@Entity
public class Parent {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Embedded
    private BasicInfo basicInfo;

    @OneToOne(mappedBy = "parent")
    ParentContactInfo contactInfo;

    @OneToOne(mappedBy = "parent")
    ParentBornInfo parentBornInfo;

    public Parent() {
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

    public ParentContactInfo getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(ParentContactInfo contactInfo) {
        this.contactInfo = contactInfo;
    }

    public ParentBornInfo getParentBornInfo() {
        return parentBornInfo;
    }

    public void setParentBornInfo(ParentBornInfo parentBornInfo) {
        this.parentBornInfo = parentBornInfo;
    }
}
