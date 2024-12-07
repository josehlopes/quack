package com.thigas.quack.Domain.Entity.Interface;

import com.thigas.quack.Domain.Utils.Status;

public interface UserLesson {

    Integer getId();

    Integer getUserId();

    Integer getLessonId();

    Boolean getCompleted();

    void setCompleted(Boolean completed);

}
