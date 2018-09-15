package pl.dn.user.dataCorrectness.nullCheck.basicInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import pl.dn.generalInfo.BasicInfo;

@Service
public class BasicInfoChecker {

    private StringBuilder stringBuilder;

    private NullMessages nullMessages;

    @Autowired
    public BasicInfoChecker(@Qualifier("BasicInfoNullMessages") NullMessages nullMessages) {
        this.nullMessages = nullMessages;
    }

    public StringBuilder checkNulls(BasicInfo basicInfo, StringBuilder stringBuilder) {
        this.stringBuilder = stringBuilder;
        this.nullMessages = new NullMessages();

        if (basicInfo == null) {
            stringBuilder.append(nullMessages.getBasicInfo());
        }
        else {
            checkNullsInsideBasicInfo(basicInfo);
        }

        return stringBuilder;
    }

    private void checkNullsInsideBasicInfo(BasicInfo basicInfo) {

        if (basicInfo.getFirstName() == null) {
            stringBuilder.append(nullMessages.getFirstName());
        }

        if (basicInfo.getLastName() == null) {
            stringBuilder.append(nullMessages.getSurname());
        }

        if (basicInfo.getPesel() == null) {
            stringBuilder.append(nullMessages.getPesel());
        }

    }

}
