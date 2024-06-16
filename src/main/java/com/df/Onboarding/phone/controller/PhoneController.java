package com.df.Onboarding.phone.controller;

import com.df.Onboarding.phone.model.PhoneNumber;
import com.df.Onboarding.phone.repo.PhoneNumberRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.Optional;

@RestController
public class PhoneController {
    @Autowired
    PhoneNumberRepo phoneNumberRepo;

    @PostMapping("/phone/")
    public void addNumber(@RequestBody PhoneNumber phoneNumber){
        phoneNumberRepo.save(phoneNumber);
    }


    @GetMapping("/phone/")
    public String requestNumbers(@RequestParam int id) {
        Optional<PhoneNumber> phoneNumber = phoneNumberRepo.findById(id);
        if (phoneNumber.isPresent()) {
            return phoneNumber.get().getPhoneNumber();
        } else {
            return "";
        }
    }

}

