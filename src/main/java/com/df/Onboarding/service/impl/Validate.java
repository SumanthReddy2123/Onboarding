package com.df.Onboarding.service.impl;

import com.df.Onboarding.model.User;
import com.df.Onboarding.model.ResultMessage;

public interface Validate {
    public void checkCondition(User user, ResultMessage resultMessage);
}
