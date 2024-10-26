package com.thigas.quack.adapter.dto;

import lombok.Data;

@Data
public class UserStepDTO {
    private int id;
    private int user;
    private int step;
    private int status;
    private String imagePath;
}
