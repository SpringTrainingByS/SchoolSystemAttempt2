package pl.dn.placeInfo;

import org.hibernate.annotations.Cascade;
import org.hibernate.engine.spi.CascadingAction;

import javax.persistence.*;

/**
 * Created by User on 10.08.2017.
 */

@Embeddable
public class Address {

    @Column(name = "house_number")
    private long houseNamber;

    @Column(name = "apratment_number")
    private long apartmentNumber;


    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;

    @ManyToOne
    @JoinColumn(name = "street_id")
    private Street street;

    @ManyToOne
    @JoinColumn(name = "zip_code_id")
    private ZipCode zipCode;

    @ManyToOne
    @JoinColumn(name = "voivodeship_id")
    private Voivodeship voivodeship;

    public long getHouseNamber() {
        return houseNamber;
    }

    public void setHouseNamber(long houseNamber) {
        this.houseNamber = houseNamber;
    }

    public long getApartmentNumber() {
        return apartmentNumber;
    }

    public void setApartmentNumber(long apartmentNumber) {
        this.apartmentNumber = apartmentNumber;
    }

    public Street getStreet() {
        return street;
    }

    public void setStreet(Street street) {
        this.street = street;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public ZipCode getZipCode() {
        return zipCode;
    }

    public void setZipCode(ZipCode zipCode) {
        this.zipCode = zipCode;
    }

    public Voivodeship getVoivodeship() {
        return voivodeship;
    }

    public void setVoivodeship(Voivodeship voivodeship) {
        this.voivodeship = voivodeship;
    }

    @Override
    public String toString() {
        return "Address{" +
                "houseNamber=" + houseNamber +
                ", apartmentNumber=" + apartmentNumber +
                ", street=" + street +
                '}';
    }
}
