package com.thigas.quack.Adapter.Dto;

import com.thigas.quack.Domain.Utils.Status;
import lombok.Data;

import java.util.Set;

@Data
public class RoadmapDTO {

    private int id;
    private String title;
    private String description;
    private String imagePath;
    private Status status;
    private Set<StepDTO> steps;

}