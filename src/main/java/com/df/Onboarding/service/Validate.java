package com.df.Onboarding.service;

import com.df.Onboarding.exceptions.InvalidUserNameException;
import com.df.Onboarding.model.ResultMessage;
import com.df.Onboarding.model.Users;

public interface Validate {
    public void checkValidUser (Users user, ResultMessage resultMessage) throws InvalidUserNameException;
}
