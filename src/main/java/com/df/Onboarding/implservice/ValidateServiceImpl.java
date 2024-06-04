package com.df.Onboarding.implservice;

import com.df.Onboarding.exceptions.InvalidUserNameException;
import com.df.Onboarding.model.User;
import com.df.Onboarding.model.ResultMessage;
import com.df.Onboarding.service.Validate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component
public class ValidateServiceImpl implements Validate {

    @Override
    public void checkValidUser(User user, ResultMessage resultMessage) {
        System.out.println("User == " +user);
        if(user.getFirstName()==null || user.getLastName()==null){
            throw new InvalidUserNameException("Invalid User Name");
        }
        String firstName= user.getFirstName().toLowerCase();
        String lastName= user.getLastName().toLowerCase();

        int firstNameLength=firstName.length();
        int lastnameLength=lastName.length();

        if(firstNameLength>0 && (firstName.charAt(0)=='v'||firstName.charAt(0)=='k')){
            invalidateUser(resultMessage);
        }else if((firstNameLength>0&&(firstName.charAt(firstNameLength-1)=='a'||firstName.charAt(firstNameLength-1)=='i')) || (lastnameLength>0&&(lastName.charAt(lastnameLength-1)=='a'||lastName.charAt(lastnameLength-1)=='i'))){
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
