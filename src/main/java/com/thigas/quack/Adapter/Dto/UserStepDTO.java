package com.thigas.quack.Adapter.Dto;

import com.thigas.quack.Domain.Utils.Status;
import lombok.Data;

@Data
public class UserStepDTO {
    private int id;
    private UserDTO user;
    private StepDTO step;
    private Status status;
    private String imagePath;
}
