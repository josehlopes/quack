package com.thigas.quack.Adapter.Dto;

import com.thigas.quack.Domain.Utils.Status;
import lombok.Data;

@Data
public class UserTaskDTO {

    private int id;
    private UserDTO user;
    private TaskDTO task;
    private Status status;
    private String imagePath;

}