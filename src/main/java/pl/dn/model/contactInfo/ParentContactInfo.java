package pl.dn.model.contactInfo;

import pl.dn.model.placeInfo.Address;
import pl.dn.model.userType.Parent;

import javax.persistence.*;

/**
 * Created by User on 11.08.2017.
 */
@Entity
@Table(name = "parent_contact_info")
public class ParentContactInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String email;

    @Column(name = "parent_id", insertable = false, updatable = false)
    private long parent_id;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Embedded
    private Address address;

    @OneToOne
    @JoinColumn(name = "parent_id")
    private Parent parent;

    public ParentContactInfo() {
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

    public long getParent_id() {
        return parent_id;
    }

    public void setParent_id(long parent_id) {
        this.parent_id = parent_id;
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

    public Parent getParent() {
        return parent;
    }

    public void setParent(Parent parent) {
        this.parent = parent;
    }
}
