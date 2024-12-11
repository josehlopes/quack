package com.thigas.quack.Domain.Factory.Interface;

import com.thigas.quack.Domain.Entity.Interface.UserLesson;

public interface UserLessonFactory {
    UserLesson create(Integer userId, Integer lessonId, Boolean completed);
}
