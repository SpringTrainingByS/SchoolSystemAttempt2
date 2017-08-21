package pl.dn.model.placeInfo;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Created by User on 10.08.2017.
 */

@Embeddable
public class Address {

    @Column(name = "city_id", insertable = false, updatable = false)
    private long cityId;

    @Column(name = "zip_code_id", insertable = false, updatable = false)
    private long zipCodeId;

    @Column(name = "street_id", insertable = false, updatable = false)
    private long streetId;

    @Column(name = "house_number", insertable = false, updatable = false)
    private long houseNamber;

    @Column(name = "apratment_number", insertable = false, updatable = false)
    private long apartmentNumber;


    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;

    @ManyToOne
    @JoinColumn(name = "zip_code_id")
    private ZipCode zipCode;

    @ManyToOne
    @JoinColumn(name = "street_id")
    private Street street;


    public long getCityId() {
        return cityId;
    }

    public void setCityId(long cityId) {
        this.cityId = cityId;
    }

    public long getZipCodeId() {
        return zipCodeId;
    }

    public void setZipCodeId(long zipCodeId) {
        this.zipCodeId = zipCodeId;
    }

    public long getStreetId() {
        return streetId;
    }

    public void setStreetId(long streetId) {
        this.streetId = streetId;
    }

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

    public Street getStreet() {
        return street;
    }

    public void setStreet(Street street) {
        this.street = street;
    }
}
