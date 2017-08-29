package pl.dn.model.placeInfo;

import org.hibernate.annotations.Cascade;

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

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "street_id")
    private Street street;


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

    @Override
    public String toString() {
        return "Address{" +
                "houseNamber=" + houseNamber +
                ", apartmentNumber=" + apartmentNumber +
                ", street=" + street +
                '}';
    }
}
