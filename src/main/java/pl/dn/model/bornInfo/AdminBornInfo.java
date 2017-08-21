package pl.dn.model.bornInfo;

import pl.dn.model.placeInfo.City;
import pl.dn.model.userType.Admin;
import pl.dn.model.userType.User;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by User on 11.08.2017.
 */
@Entity
@Table(name = "admin_born_info")
public class AdminBornInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Temporal(TemporalType.DATE)
    @Column(name = "born_date")
    private Date bornDate;

    @Column(name = "city_id", insertable = false, updatable = false)
    private long cityId;

    @Column(name = "admin_id", insertable = false, updatable = false)
    private long adminId;

    @ManyToOne
    @JoinColumn(name = "city_id", insertable = false, updatable = false)
    private City city;

    @OneToOne
    @JoinColumn(name = "admin_id", insertable = false, updatable = false)
    private Admin admin;

    public AdminBornInfo() {
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

    public long getCityId() {
        return cityId;
    }

    public void setCityId(long cityId) {
        this.cityId = cityId;
    }

    public long getAdminId() {
        return adminId;
    }

    public void setAdminId(long adminId) {
        this.adminId = adminId;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }
}
