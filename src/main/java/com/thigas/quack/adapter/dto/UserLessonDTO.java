package com.thigas.quack.adapter.dto;

import com.thigas.quack.domain.model.Status;
import lombok.Data;

@Data
public class UserLessonDTO {
    private int id;
    private UserDTO user;
    private LessonDTO lesson;
    private Status status;
    private String imagePath;
}
