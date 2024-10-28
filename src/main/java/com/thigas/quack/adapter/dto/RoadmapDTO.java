package com.thigas.quack.adapter.dto;

import com.thigas.quack.domain.model.Status;
import lombok.Data;

import java.util.Set;

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