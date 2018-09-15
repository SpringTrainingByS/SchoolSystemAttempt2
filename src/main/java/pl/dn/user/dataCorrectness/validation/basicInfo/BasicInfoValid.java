package pl.dn.user.dataCorrectness.validation.basicInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import pl.dn.generalInfo.BasicInfo;
import pl.dn.user.dataCorrectness.validation.ValidationService;
import pl.dn.user.dataCorrectness.validation.base.ValidationPatterns;

@Service
public class BasicInfoValid {

    private ValidationService validService;
    private InvalidMessages invalidMessages;

    @Autowired
    public BasicInfoValid(ValidationService validService,@Qualifier("BasicInfoInvalidMessages") InvalidMessages invalidMessages) {
        this.validService = validService;
        this.invalidMessages = invalidMessages;
    }

    public StringBuilder valid(BasicInfo basicInfo) {
        StringBuilder message = new StringBuilder();


        if (!validService.validNameStartGreat(basicInfo.getFirstName())) {
            message.append(invalidMessages.getFirstName());
        }

        if (!validService.validNameStartGreat(basicInfo.getLastName())) {
            message.append(invalidMessages.getLastName());
        }


        if (!validService.validPesel(basicInfo.getPesel())) {
            message.append(invalidMessages.getPesel());
        }

        return message;
    }


}
