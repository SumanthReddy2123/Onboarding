package com.df.Onboarding.service;

import com.df.Onboarding.model.User;
import com.df.Onboarding.model.ResultMessage;
import com.df.Onboarding.service.impl.Validate;
import org.springframework.stereotype.Component;

@Component
public class ImplementValidate implements Validate {

    @Override
    public void checkCondition(User user, ResultMessage resultMessage) {
        String firstName= user.getFirstName(),lastName= user.getLastName();
        firstName=firstName.toLowerCase();
        lastName=lastName.toLowerCase();
        if(firstName.length()>0 && (firstName.charAt(0)=='v'||firstName.charAt(0)=='k')){
            invalidateUser(resultMessage);
        }else if((firstName.length()>0&&(firstName.charAt(firstName.length()-1)=='a'||firstName.charAt(firstName.length()-1)=='i')) || (lastName.length()>0&&(lastName.charAt(lastName.length()-1)=='a'||lastName.charAt(lastName.length()-1)=='i'))){
            invalidateUser(resultMessage);
        }else{
            validateUser(user, resultMessage);
        }

    }
    public void invalidateUser(ResultMessage resultMessage){
        resultMessage.setSuccess(false);
        resultMessage.setMessage("Invalid User");
    }

    public void validateUser(User user, ResultMessage resultMessage){
        resultMessage.setSuccess(true);
        resultMessage.setMessage("Congratulations! "+user.getFirstName()+" "+user.getLastName()+". You are now a active user. ");
    }
}
