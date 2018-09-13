package pl.dn.user.nullCheck.bornInfo;

import org.springframework.stereotype.Service;
import pl.dn.bornInfo.UserBornInfo;

@Service
public class BornInfoChecker {

    private StringBuilder stringBuilder;
    private NullMessages nullMsgs;

    public StringBuilder checkNulls(UserBornInfo bornInfo, StringBuilder stringBuilder) {
        this.stringBuilder = stringBuilder;
        nullMsgs = new NullMessages();

        if (bornInfo == null) {
            stringBuilder.append(nullMsgs.getBornInfo());
        }
        else {
            checkNullsInside(bornInfo);
        }

        return stringBuilder;
    }

    private void checkNullsInside(UserBornInfo bornInfo) {
        if (bornInfo.getBornDate() == null) {
            stringBuilder.append(nullMsgs.getDate());
        }

        if (bornInfo.getCity() == null) {
            stringBuilder.append(nullMsgs.getCity());
        }

        if (bornInfo.getVoivodeship() == null) {
            stringBuilder.append(nullMsgs.getVoivodeship());
        }
    }
}
