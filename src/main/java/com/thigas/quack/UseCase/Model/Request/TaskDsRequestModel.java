package com.thigas.quack.UseCase.Model.Request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TaskDsRequestModel {

    private int id;
    private TaskTextDsRequestModel tasktext;
    private Set<StepDsRequestModel> steps;
    private String imagePath;

}