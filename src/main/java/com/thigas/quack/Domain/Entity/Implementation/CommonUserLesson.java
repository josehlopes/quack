package com.thigas.quack.Domain.Entity.Implementation;


import com.thigas.quack.Domain.Entity.Interface.UserLesson;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonUserLesson implements UserLesson {
    private Integer id;
    private Integer UserId;
    private Integer lessonId;
    private Boolean completed;

}
