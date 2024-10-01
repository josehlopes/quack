package com.thigas.quack.adapter.dto;

import lombok.Data;

@Data
public class UserTaskDTO {

    private int id;
    private int user;
    private int task;
    private Boolean status;
    private String imagePath;

}