package com.thigas.quack.Adapter.Dto;

import com.thigas.quack.Domain.Utils.Status;
import lombok.Data;

import java.util.Set;

@Data
public class StepDTO {

    private int id;
    private Set<RoadmapDTO> roadmaps;
    private Set<LessonDTO> lessons;
    private Set<TaskDTO> tasks;
    private String description;
    private String imagePath;
    private Status status;

}
