package com.df.Onboarding.service;

import com.df.Onboarding.exceptions.InvalidUserNameException;
import com.df.Onboarding.model.User;
import com.df.Onboarding.model.ResultMessage;

public interface Validate {
    public void checkValidUser (User user, ResultMessage resultMessage) throws InvalidUserNameException;
}
