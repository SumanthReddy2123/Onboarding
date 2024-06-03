package com.df.Onboarding.controller;

import com.df.Onboarding.exceptions.InvalidUserNameException;
import com.df.Onboarding.model.ResultMessage;
import com.df.Onboarding.model.User;
import com.df.Onboarding.implservice.ValidateServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Onboarder {
    @Autowired
    ValidateServiceImpl implementValidate;

    @PostMapping(path="/ping/")

    public ResponseEntity<Object> great(@RequestBody User user){



        try{
            ResultMessage resultMessage = new ResultMessage();
            implementValidate.checkValidUser(user, resultMessage);
            return new ResponseEntity<>(resultMessage, HttpStatus.OK);
        }catch(InvalidUserNameException invalidUserNameException){
            return new ResponseEntity<>("Check the format or provide valid username",HttpStatus.BAD_REQUEST);
        }
    }



}
