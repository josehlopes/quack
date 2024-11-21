package com.thigas.quack.Domain.Entity.Interface;

import com.thigas.quack.Domain.Utils.Status;

public interface UserLesson {

    int getId();

    User getUser();

    Lesson getLesson();

    Status getStatus();

    String getImagePath();

}
