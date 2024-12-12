package com.thigas.quack.Domain.Factory.Implementation;

import com.thigas.quack.Domain.Entity.Implementation.CommonUserStep;
import com.thigas.quack.Domain.Entity.Interface.UserStep;
import com.thigas.quack.Domain.Factory.Interface.UserStepFactory;
import com.thigas.quack.Domain.Utils.Status;

public class CommonUserStepFactory implements UserStepFactory{
    @Override
    public UserStep create(Integer userId, Integer stepId){
        return new CommonUserStep(null, userId, stepId, Status.ACTIVE);
    }
}
