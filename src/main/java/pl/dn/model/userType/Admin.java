package pl.dn.model.userType;

import pl.dn.model.bornInfo.AdminBornInfo;
import pl.dn.model.contactInfo.AdminContactInfo;
import pl.dn.model.generalInfo.BasicInfo;

import javax.persistence.*;

/**
 * Created by User on 11.08.2017.
 */
@Entity
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Embedded
    private BasicInfo basicInfo;

    @OneToOne
    @JoinColumn(name = "contact_info_id")
    private AdminContactInfo contactInfo;

    @OneToOne
    @JoinColumn(name = "born_info_id")
    private AdminBornInfo adminBornInfo;

    public Admin() {
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

    public AdminContactInfo getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(AdminContactInfo contactInfo) {
        this.contactInfo = contactInfo;
    }

    public AdminBornInfo getAdminBornInfo() {
        return adminBornInfo;
    }

    public void setAdminBornInfo(AdminBornInfo adminBornInfo) {
        this.adminBornInfo = adminBornInfo;
    }



}
