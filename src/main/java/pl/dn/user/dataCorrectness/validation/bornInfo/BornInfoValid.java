package pl.dn.user.dataCorrectness.validation.bornInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import pl.dn.bornInfo.UserBornInfo;
import pl.dn.user.dataCorrectness.validation.ValidationService;
import pl.dn.user.dataCorrectness.validation.base.ValidationPatterns;

import java.util.Date;

@Service
public class BornInfoValid {

    private InvalidMessages invalidMessages;
    private ValidationService validService;

    @Autowired
    public BornInfoValid(ValidationService validService, @Qualifier("BornInfoInvalidMessages") InvalidMessages invalidMessages) {
        this.invalidMessages = invalidMessages;
        this.validService = validService;
    }

    public StringBuilder valid(UserBornInfo bornInfo) {
        StringBuilder message = new StringBuilder();

        if (!validService.validNameStartGreat(bornInfo.getCity().getName())) {
            message.append(invalidMessages.getCity());
        }

        if (!validService.validName(bornInfo.getVoivodeship().getName())) {
            message.append(invalidMessages.getVoivodeship());
        }


        String bornDateValidationMsg = validBornDate(bornInfo.getBornDate()).toString();

        if (!bornDateValidationMsg.equals("")) {
            message.append(invalidMessages.getBornDate());
            message.append(bornDateValidationMsg);
        }

        return message;
    }

    private StringBuilder validBornDate(Date bornDate) {
        StringBuilder message = new StringBuilder();
        int month = bornDate.getMonth() + 1;

        if (month < 1 || month > 12) {
            System.out.println(bornDate.getMonth());
            System.out.println("Nieprawidłowy zakres dla dnia miesiąca");
            message.append(invalidMessages.getBornMonth());
        }
        else if (month == 2) {
            int maxDay = 30;

            if ((bornDate.getYear() % 4 == 0 && bornDate.getYear() % 100 != 0) ||
                    (bornDate.getYear() % 400 == 0)) {

                maxDay = 28;
            }

            if (bornDate.getDate() > maxDay) {
                message.append(invalidMessages.getBornDay());
            }
        }
        else if (month % 2 == 0) {
            if (bornDate.getDate() > 30 || bornDate.getDate() < 0) {
                message.append(invalidMessages.getBornDay());
            }
        }
        else if (month % 2 != 0) {
            if (bornDate.getDate() > 31 || bornDate.getDate() < 0) {
                message.append(invalidMessages.getBornDay());
            }
        }

        return message;
    }
}
