package com.thigas.quack.Domain.Factory.Interface;

import com.thigas.quack.Domain.Entity.Interface.UserStep;

public interface UserStepFactory {
    UserStep create(Integer userId, Integer stepId);
}
