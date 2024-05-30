package com.df.Onboarding;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class APIController {

    @PostMapping(path="/ping/")

    public ResponseEntity<String> add(@RequestBody Being being){
        String msg="Hello "+being.getFirstName()+" "+being.getLastName();
        System.out.println(msg);
        return new ResponseEntity<>(msg, HttpStatus.OK);
    }



}
