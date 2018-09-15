package pl.dn.user.dataCorrectness.validation.bornInfo;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("BornInfoInvalidMessages")
public class InvalidMessages {

    private final String date = ", data urodzenia";
    private final String city = ", miasto urodzenia";
    private final String voivodeship = ", wojowództwo urodzenia";
    private final String bornDate = ". Data Urodzenia : ";
    private final String bornDay = ", nieprawidłowy zakres dla dnia w danym miesiącu";
    private final String bornMonth = ", nieprawidłowy zakres dla miesiąca";

    public String getDate() {
        return date;
    }

    public String getCity() {
        return city;
    }

    public String getVoivodeship() {
        return voivodeship;
    }

    public String getBornDate() {
        return bornDate;
    }

    public String getBornDay() {
        return bornDay;
    }

    public String getBornMonth() {
        return bornMonth;
    }


}
