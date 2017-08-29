package pl.dn.model.bornInfo;

import pl.dn.model.placeInfo.City;
import pl.dn.model.userType.Moderator;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by User on 11.08.2017.
 */
@Entity
@Table(name = "moderator_born_info")
public class ModeratorBornInfo  {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Temporal(TemporalType.DATE)
    @Column(name = "born_date")
    private Date bornDate;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "city_id")
    private City city;

    public ModeratorBornInfo() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getBornDate() {
        return bornDate;
    }

    public void setBornDate(Date bornDate) {
        this.bornDate = bornDate;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "ModeratorBornInfo{" +
                "id=" + id +
                ", bornDate=" + bornDate +
                ", city=" + city +
                '}';
    }
}
