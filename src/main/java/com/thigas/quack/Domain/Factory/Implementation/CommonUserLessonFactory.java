package com.thigas.quack.Domain.Factory.Implementation;

import com.thigas.quack.Domain.Entity.Implementation.CommonUserLesson;
import com.thigas.quack.Domain.Entity.Interface.UserLesson;
import com.thigas.quack.Domain.Factory.Interface.UserLessonFactory;

public class CommonUserLessonFactory implements UserLessonFactory {
    @Override
    public UserLesson create(Integer userId, Integer lessonId){
        return new CommonUserLesson(null, userId, lessonId,false);
    }
}
