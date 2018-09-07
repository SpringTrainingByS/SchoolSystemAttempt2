package pl.dn.user;

import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.stereotype.Service;
import pl.dn.base.BaseDetail;
import pl.dn.base.BaseDetailDao;
import pl.dn.placeInfo.city.City;
import pl.dn.placeInfo.dao.PlaceDaoSet;
import pl.dn.placeInfo.street.Street;
import pl.dn.placeInfo.voivodeship.Voivodeship;
import pl.dn.placeInfo.zipCode.ZipCode;

@Service
public class UserComplementService {

    private PlaceDaoSet placeDaos;

    @Autowired
    public UserComplementService(PlaceDaoSet placeDaos) {
        this.placeDaos = placeDaos;
    }

    public User fetchPlaceInfo(User user) {

        City city = user.getContactInfo().getAddress().getCity();
        city = (City) findPlaceInDB(city, placeDaos.getCityDao());
        user.getContactInfo().getAddress().setCity(city);

        Street street = user.getContactInfo().getAddress().getStreet();
        street = (Street) findPlaceInDB(street, placeDaos.getStreetDao());
        user.getContactInfo().getAddress().setStreet(street);

        ZipCode zipCode = user.getContactInfo().getAddress().getZipCode();
        zipCode = (ZipCode) findPlaceInDB(zipCode, placeDaos.getZipCodeDao());
        user.getContactInfo().getAddress().setZipCode(zipCode);

        Voivodeship voivodeship = user.getContactInfo().getAddress().getVoivodeship();
        voivodeship = (Voivodeship) findPlaceInDB(voivodeship, placeDaos.getVoivodeshipDao());
        user.getContactInfo().getAddress().setVoivodeship(voivodeship);

        Voivodeship voivodeshipBorn = user.getBornInfo().getVoivodeship();
        voivodeshipBorn = (Voivodeship) findPlaceInDB(voivodeshipBorn, placeDaos.getVoivodeshipDao());
        user.getBornInfo().setVoivodeship(voivodeshipBorn);

        City cityBorn = user.getBornInfo().getCity();
        cityBorn = (City) findPlaceInDB(cityBorn, placeDaos.getCityDao());
        user.getBornInfo().setCity(cityBorn);

        return user;
    }

    private BaseDetail findPlaceInDB(BaseDetail place, BaseDetailDao dao) {
        BaseDetail placeFromDb = dao.findByName(place.getName());

        if (placeFromDb != null) {
            place = placeFromDb;
        }
        return place;
    }
}
