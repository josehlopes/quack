package com.thigas.quack.Domain.Entity.Interface;

import com.thigas.quack.Domain.Utils.Status;

public interface UserStep {

    Integer getId();

    Integer getUserId();

    Integer getStepId();

    Status getStatus();
}
