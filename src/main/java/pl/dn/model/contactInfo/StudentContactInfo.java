package pl.dn.model.contactInfo;

import pl.dn.model.placeInfo.Address;
import pl.dn.model.userType.Student;
import pl.dn.model.userType.User;

import javax.persistence.*;

/**
 * Created by User on 11.08.2017.
 */
@Entity(name = "student_contact_info")
public class StudentContactInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String email;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Embedded
    private Address address;

    public StudentContactInfo() {
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
}
