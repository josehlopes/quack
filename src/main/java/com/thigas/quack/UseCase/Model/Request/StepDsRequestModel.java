package com.thigas.quack.UseCase.Model.Request;

import com.thigas.quack.Domain.Utils.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StepDsRequestModel {

    private int id;
    private Set<RoadmapDsRequestModel> roadmaps;
    private Set<LessonDsRequestModel> lessons;
    private Set<TaskDsRequestModel> tasks;
    private String description;
    private String imagePath;
    private Status status;

}
