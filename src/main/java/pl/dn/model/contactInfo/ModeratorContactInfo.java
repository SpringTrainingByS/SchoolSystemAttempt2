package pl.dn.model.contactInfo;

import pl.dn.model.placeInfo.Address;
import pl.dn.model.userType.Admin;
import pl.dn.model.userType.Moderator;

import javax.persistence.*;

/**
 * Created by User on 11.08.2017.
 */
@Entity
@Table(name = "moderator_contact_info")
public class ModeratorContactInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String email;

    @Column(name = "moderator_id", insertable = false, updatable = false)
    private long moderatorId;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Embedded
    private Address address;

    @OneToOne
    @JoinColumn(name = "moderator_id")
    private Moderator moderator;

    public ModeratorContactInfo() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getModeratorId() {
        return moderatorId;
    }

    public void setModeratorId(long moderatorId) {
        this.moderatorId = moderatorId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Moderator getModerator() {
        return moderator;
    }

    public void setModerator(Moderator moderator) {
        this.moderator = moderator;
    }
}
