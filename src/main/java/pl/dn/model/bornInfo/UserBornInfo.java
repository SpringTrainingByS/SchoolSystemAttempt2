package pl.dn.model.bornInfo;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.DynamicUpdate;

import pl.dn.model.placeInfo.City;
import pl.dn.model.placeInfo.Voivodeship;

@Entity
@Table(name = "user_born_info")
@DynamicUpdate(true)
public class UserBornInfo {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Temporal(TemporalType.DATE)
    @Column(name = "born_date")
    private Date bornDate;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "voivodeship_id")
    private Voivodeship voivodeship;


    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "city_id")
    private City city;

    public UserBornInfo() {
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

	public Voivodeship getVoivodeship() {
		return voivodeship;
	}

	public void setVoivodeship(Voivodeship voivodeship) {
		this.voivodeship = voivodeship;
	}

}
