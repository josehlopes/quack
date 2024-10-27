package com.thigas.quack.adapter.dto;

import com.thigas.quack.domain.model.Status;
import lombok.Data;

@Data
public class UserTaskDTO {

    private int id;
    private UserDTO user;
    private TaskDTO task;
    private Status status;
    private String imagePath;

}