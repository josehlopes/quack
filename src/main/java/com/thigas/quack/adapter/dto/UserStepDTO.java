package com.thigas.quack.adapter.dto;

import com.thigas.quack.domain.model.Status;
import lombok.Data;

@Data
public class UserStepDTO {
    private int id;
    private UserDTO user;
    private StepDTO step;
    private Status status;
    private String imagePath;
}
