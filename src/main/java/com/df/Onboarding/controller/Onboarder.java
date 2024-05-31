package com.df.Onboarding.controller;

import com.df.Onboarding.model.ResultMessage;
import com.df.Onboarding.model.User;
import com.df.Onboarding.service.ImplementValidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Onboarder {
    @Autowired
    ImplementValidate implementValidate;

    @PostMapping(path="/ping/")

    public ResponseEntity<ResultMessage> great(@RequestBody User user){

        ResultMessage resultMessage = new ResultMessage();
        implementValidate.checkCondition(user, resultMessage);
        return new ResponseEntity<>(resultMessage, HttpStatus.OK);
    }



}
