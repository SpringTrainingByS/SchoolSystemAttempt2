package pl.dn.user.nullCheck.bornInfo;

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
