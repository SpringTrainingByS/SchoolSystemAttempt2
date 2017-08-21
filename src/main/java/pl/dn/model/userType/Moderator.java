package pl.dn.model.userType;

import pl.dn.model.bornInfo.ModeratorBornInfo;
import pl.dn.model.contactInfo.ModeratorContactInfo;
import pl.dn.model.generalInfo.BasicInfo;

import javax.persistence.*;

/**
 * Created by User on 11.08.2017.
 */
@Entity
public class Moderator {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Embedded
    private BasicInfo basicInfo;

    @OneToOne
    @JoinColumn(name = "moderator_contact_info_id")
    private ModeratorContactInfo contactInfo;

    @OneToOne
    @JoinColumn(name = "moderator_born_info_id")
    private ModeratorBornInfo bornInfo;

    public Moderator() {
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

    public ModeratorContactInfo getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(ModeratorContactInfo contactInfo) {
        this.contactInfo = contactInfo;
    }

    public ModeratorBornInfo getBornInfo() {
        return bornInfo;
    }

    public void setBornInfo(ModeratorBornInfo bornInfo) {
        this.bornInfo = bornInfo;
    }

}
