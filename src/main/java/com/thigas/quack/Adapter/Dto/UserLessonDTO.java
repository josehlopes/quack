package com.thigas.quack.Adapter.Dto;

import com.thigas.quack.Domain.Utils.Status;
import lombok.Data;

@Data
public class UserLessonDTO {
    private int id;
    private UserDTO user;
    private LessonDTO lesson;
    private Status status;
    private String imagePath;
}
