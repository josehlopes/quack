package com.thigas.quack.UseCase.Model.Request;

import com.thigas.quack.Domain.Utils.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoadmapDsRequestModel {

    private int id;
    private String title;
    private String description;
    private String imagePath;
    private Status status;
    private Set<StepDsRequestModel> steps;

}