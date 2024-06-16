package com.df.Onboarding.users.controller;

import com.df.Onboarding.phone.model.PhoneNumber;
import com.df.Onboarding.users.exceptions.InvalidUserNameException;
import com.df.Onboarding.users.model.ResultMessage;

import com.df.Onboarding.users.implservice.ValidateServiceImpl;
import com.df.Onboarding.users.model.Users;
import com.df.Onboarding.users.repo.RepoManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@RestController
public class Onboarder {
    @Autowired
    ValidateServiceImpl implementValidate;

    @Autowired
    RepoManager repoManager;


    @PostMapping(path="/ping/")

    public ResponseEntity<Object> great(@RequestBody Users user){



        try{
            ResultMessage resultMessage = new ResultMessage();
            implementValidate.checkValidUser(user, resultMessage);
            return new ResponseEntity<>(resultMessage, HttpStatus.OK);
        }catch(InvalidUserNameException invalidUserNameException){
            return new ResponseEntity<>("Check the format or provide valid username",HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/findNumber/")
    public String findByNumber(@RequestBody Users users){
        return implementValidate.restTemplateUsage(users);
    }



}
