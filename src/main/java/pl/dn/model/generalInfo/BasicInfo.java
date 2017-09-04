package pl.dn.model.generalInfo;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

/**
 * Created by User on 11.08.2017.
 */
@Embeddable
public class BasicInfo {

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "pesel", length = 11)
    private String pesel;

    @Temporal(TemporalType.DATE)
    @Column(name = "start_date")
    private Date startDate;

    public BasicInfo() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    @JsonIgnore
    public boolean isFirstNameEmpty() {
        if (firstName == null || firstName.isEmpty()) {
            return true;
        }

        return false;
    }

    @JsonIgnore
    public boolean isLastNameEmpty() {
        if (lastName == null || lastName.isEmpty()) {
            return true;
        }

        return false;
    }

    @JsonIgnore
    public boolean isPeselEmpty() {
        if (pesel == null || pesel.isEmpty()) {
            return true;
        }

        return false;
    }


}
