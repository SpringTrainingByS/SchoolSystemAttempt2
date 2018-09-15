package pl.dn.user.dataCorrectness.nullCheck.bornInfo;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("BornInfoNullMessages")
public class NullMessages {
    private final String bornInfo = "Brak informacji narodzin.";
    private final String date = "Brak roku urodzenia.";
    private final String city = "Brak miasta urodzenia.";
    private final String voivodeship = "Brak miasta urodzenia.";

    public String getBornInfo() {
        return bornInfo;
    }

    public String getDate() {
        return date;
    }

    public String getCity() {
        return city;
    }

    public String getVoivodeship() {
        return voivodeship;
    }
}
