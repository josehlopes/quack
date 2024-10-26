package com.thigas.quack.adapter.dto;

import lombok.Data;

@Data
public class UserLessonDTO {
    private int id;
    private int user;
    private int lesson;
    private int status;
    private String imagePath;
}
