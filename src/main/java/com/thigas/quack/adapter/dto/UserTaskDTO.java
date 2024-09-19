package com.thigas.quack.adapter.dto;

import lombok.Data;

@Data
public class UserTaskDTO {

    private int id;
    private int userId;
    private int taskId;
    private Boolean status;
    private String imagePath;

}