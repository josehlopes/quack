package com.thigas.quack.Domain.Entity;

import com.thigas.quack.Domain.Utils.Status;

public interface UserStep {

    int getId();

    User getUser();

    Step getStep();

    Status getStatus();

    String getImagePath();

}
