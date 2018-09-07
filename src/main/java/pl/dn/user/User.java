package pl.dn.user;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.hibernate.annotations.DynamicUpdate;

import pl.dn.bornInfo.UserBornInfo;
import pl.dn.contactInfo.UserContactInfo;
import pl.dn.generalInfo.BasicInfo;

/**
 * Created by User on 10.08.2017.
 */
@Entity
@DynamicUpdate(true)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
  
    @Embedded
    private BasicInfo basicInfo;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "contact_info_id")
    private UserContactInfo contactInfo;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "born_info_id")
    private UserBornInfo bornInfo;


    public User() {
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

	public UserContactInfo getContactInfo() {
		return contactInfo;
	}

	public void setContactInfo(UserContactInfo contactInfo) {
		this.contactInfo = contactInfo;
	}

	public UserBornInfo getBornInfo() {
		return bornInfo;
	}

	public void setBornInfo(UserBornInfo bornInfo) {
		this.bornInfo = bornInfo;
	}

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", basicInfo=" + basicInfo.toString() +
                ", contactInfo=" + contactInfo.toString() +
                ", bornInfo=" + bornInfo.toString() +
                '}';
    }
}
