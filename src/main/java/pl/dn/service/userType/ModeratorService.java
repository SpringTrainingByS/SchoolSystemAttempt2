package pl.dn.service.userType;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.dn.dao.placeInfo.CityDao;
import pl.dn.dao.placeInfo.StreetDao;
import pl.dn.dao.placeInfo.VoivodeshipDao;
import pl.dn.dao.placeInfo.ZipCodeDao;
import pl.dn.dao.userType.ModeratorDao;
import pl.dn.model.generalInfo.BasicInfo;
import pl.dn.model.placeInfo.*;
import pl.dn.model.userType.Moderator;

import javax.transaction.Transactional;
import javax.validation.constraints.Null;

/**
 * Created by User on 31.08.2017.
 */
@Service
public class ModeratorService  {

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private ModeratorDao moderatorDao;

    @Autowired
    private CityDao cityDao;

    @Autowired
    private StreetDao streetDao;

    @Autowired
    private VoivodeshipDao voivodeshipDao;

    @Autowired
    private ZipCodeDao zipCodeDao;

    public Moderator findById(Long id) {

        Moderator moderator = moderatorDao.findById(id);
        return moderator;

    }

    @Transactional
    public Moderator save(Moderator moderator) throws NullPointerException {

        try {
            moderator = prepareModeratorData(moderator);
        }
        catch (NullPointerException e) {
            throw new NullPointerException(e.getMessage());
        }

        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(moderator);

        return moderator;
    }


    public void delete(Long id) {
        moderatorDao.delete(id);
    }


    public Moderator prepareModeratorData(Moderator moderator) throws NullPointerException{

        System.out.println("------------------------ Test1 --------------------------");
        if (moderator == null) {
            throw new NullPointerException("Zero danych");
        }

        System.out.println("------------------------ Test2 --------------------------");
        if (moderator.getContactInfo() == null) {
            throw new NullPointerException("Brak informacji kontaktowych.");
        }

        System.out.println("------------------------ Test2 --------------------------");
        if (moderator.getContactInfo().getAddress() == null) {
            throw new NullPointerException("Brak adresu kontaktowego.");
        }

        System.out.println("------------------------ Test3 --------------------------");
        if (moderator.getBasicInfo() == null) {
            throw new NullPointerException("Brak podstawowych informacji.");
        }

        System.out.println("------------------------ Test4 --------------------------");
        if (moderator.getBornInfo() == null) {
            throw new NullPointerException("Brak danych urodzenia.");
        }


        Address addressContact = moderator.getContactInfo().getAddress();
        BasicInfo basicInfo = moderator.getBasicInfo();
        City cityContact = addressContact.getCity();
        Street streetContact = addressContact.getStreet();
        Voivodeship voivodeshipContact = addressContact.getVoivodeship();


        ZipCode zipCodeContact = addressContact.getZipCode();
        City cityBorn = moderator.getBornInfo().getCity();

        if (basicInfo.isFirstNameEmpty()) {
            throw new NullPointerException("Brak imion");
        }

        if (basicInfo.isLastNameEmpty()) {
            throw new NullPointerException("Brak nazwiska");
        }

        if (basicInfo.isPeselEmpty()) {
            throw new NullPointerException("Brak numeru Pesel");
        }

        if (cityContact.isNameEmpty()) {
            throw new NullPointerException("Brak wybranego miasta dla danych kontaktowych.");
        }

        if (streetContact.isNameEmpty()) {
            throw new NullPointerException("Brak wybranej ulicy dla danych kontaktowych.");
        }

        if (voivodeshipContact.isNameEmpty()) {
            throw new NullPointerException("Brak wybranego województa dla danych kontaktowych.");
        }

        if (cityBorn.isNameEmpty()) {
            throw new NullPointerException("Brak wybranego miasta dla danych urodzenia.");
        }

        if (zipCodeContact.isValueEmpty()) {
            throw new NullPointerException("Brak wybranego kodu pocztowego dla danych kontaktowych.");
        }


        if (cityContact.getId() == 0) {
            long id = cityDao.findByName(cityContact.getName()).getId();
            if (id != 0) {
                cityContact.setId(id);
            }
        }

        if (streetContact.getId() == 0) {
            long id = streetDao.findByName(streetContact.getName()).getId();
            if (id != 0) {
                streetContact.setId(id);
            }
        }

        if (voivodeshipContact.getId() == 0) {
            long id = voivodeshipDao.findByName(voivodeshipContact.getName()).getId();
            if (id != 0) {
                voivodeshipContact.setId(id);
            }
        }

        if (zipCodeContact.getId() == 0) {
            long id = zipCodeDao.findByValue(zipCodeContact.getValue()).getId();
            if (id != 0) {
                zipCodeContact.setId(id);
            }
        }

        if (cityBorn.getId() == 0) {
            long id = cityDao.findByName(cityBorn.getName()).getId();
            if (id != 0) {
                cityBorn.setId(id);
            }
        }


        return moderator;
    }
}
