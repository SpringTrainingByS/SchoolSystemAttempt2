package pl.dn.placeInfo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.dn.placeInfo.city.CityDao;
import pl.dn.placeInfo.street.StreetDao;
import pl.dn.placeInfo.voivodeship.VoivodeshipDao;
import pl.dn.placeInfo.zipCode.ZipCodeDao;

@Component
public class PlaceDaoSet {

    private CityDao cityDao;
    private StreetDao streetDao;
    private VoivodeshipDao voivodeshipDao;
    private ZipCodeDao zipCodeDao;

    @Autowired
    public PlaceDaoSet(CityDao cityDao, StreetDao streetDao, VoivodeshipDao voivodeshipDao, ZipCodeDao zipCodeDao) {
        this.cityDao = cityDao;
        this.streetDao = streetDao;
        this.voivodeshipDao = voivodeshipDao;
        this.zipCodeDao = zipCodeDao;
    }

    public CityDao getCityDao() {
        return cityDao;
    }

    public StreetDao getStreetDao() {
        return streetDao;
    }

    public VoivodeshipDao getVoivodeshipDao() {
        return voivodeshipDao;
    }

    public ZipCodeDao getZipCodeDao() {
        return zipCodeDao;
    }
}
