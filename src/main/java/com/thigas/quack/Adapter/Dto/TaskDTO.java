package com.thigas.quack.Adapter.Dto;

import com.thigas.quack.UseCase.Model.Request.TaskTextDsRequestModel;
import lombok.Data;

import java.util.Set;

@Data
public class TaskDTO {

    private int id;
    private Set<StepDTO> steps;
    private TaskTextDsRequestModel tasktext;
    private String imagePath;
}
