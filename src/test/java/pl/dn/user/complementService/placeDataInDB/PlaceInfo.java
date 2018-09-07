package pl.dn.user.complementService.placeDataInDB;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import pl.dn.placeInfo.city.City;
import pl.dn.placeInfo.street.Street;
import pl.dn.placeInfo.voivodeship.Voivodeship;
import pl.dn.placeInfo.zipCode.ZipCode;

@Component
public class PlaceInfo {

//    ulan, rolna, radzyn, mazowieckie, radzyn

    private City cityUlan;
    private City cityRadzyn;
    private Street streetRolna;
    private Voivodeship voivMazowieckie;
    private Voivodeship voivLubelskie;
    private ZipCode zipCode;

    public PlaceInfo() {
        cityUlan = new City("Ulan");
        cityRadzyn = new City("Radzyñ");
        streetRolna = new Street("rolna");
        voivMazowieckie = new Voivodeship("mazowieckie");
        voivLubelskie = new Voivodeship("lubelskie");
        zipCode = new ZipCode("21-307");
    }

    public City getCityUlan() {
        return cityUlan;
    }

    public void setCityUlan(City cityUlan) {
        this.cityUlan = cityUlan;
    }

    public City getCityRadzyn() {
        return cityRadzyn;
    }

    public void setCityRadzyn(City cityRadzyn) {
        this.cityRadzyn = cityRadzyn;
    }

    public Street getStreetRolna() {
        return streetRolna;
    }

    public void setStreetRolna(Street streetRolna) {
        this.streetRolna = streetRolna;
    }

    public Voivodeship getVoivMazowieckie() {
        return voivMazowieckie;
    }

    public void setVoivMazowieckie(Voivodeship voivMazowieckie) {
        this.voivMazowieckie = voivMazowieckie;
    }

    public Voivodeship getVoivLubelskie() {
        return voivLubelskie;
    }

    public void setVoivLubelskie(Voivodeship voivLubelskie) {
        this.voivLubelskie = voivLubelskie;
    }

    public ZipCode getZipCode() {
        return zipCode;
    }

    public void setZipCode(ZipCode zipCode) {
        this.zipCode = zipCode;
    }
}
