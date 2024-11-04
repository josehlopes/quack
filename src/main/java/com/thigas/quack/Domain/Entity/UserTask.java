package com.thigas.quack.Domain.Entity;

import com.thigas.quack.Domain.Utils.Status;

public interface UserTask {

    int getId();

    User getUser();

    Task getTask();

    Status getStatus();

    String getImagePath();

}