package com.df.Onboarding.users.implservice;

import com.df.Onboarding.users.repo.RepoManager;
import com.df.Onboarding.users.exceptions.InvalidUserNameException;
import com.df.Onboarding.users.model.ResultMessage;
import com.df.Onboarding.users.model.Users;
import com.df.Onboarding.users.service.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
@Component
public class ValidateServiceImpl implements Validate {

    @Autowired
    RepoManager repoManager;

    @Override
    public void checkValidUser(Users user, ResultMessage resultMessage) {
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

    public void validateUser(Users user, ResultMessage resultMessage){
        repoManager.save(user);
        resultMessage.setSuccess(true);
        resultMessage.setMessage("Congratulations! "+user.getFirstName()+" "+user.getLastName()+". You are now a active user. ");
    }

    public String restTemplateUsage(Users firstName) {
        //logic to find users with the firstName
        int id=0;
        Users user = repoManager.findTop1ByFirstNameAndLastName(firstName.getFirstName(),firstName.getLastName());
        if(user==null) return "User Not Found";
        
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8080/phone/?id=" + user.getId();
        return restTemplate.getForObject(url, String.class);
    }


}
