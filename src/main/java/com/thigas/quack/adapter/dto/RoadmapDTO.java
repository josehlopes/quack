package com.thigas.quack.adapter.dto;

import java.util.Set;
import lombok.Data;

@Data
public class RoadmapDTO {

    private int id;
    private String title;
    private String description;
    private String imagePath;
    private int status;
    private Set<Integer> steps;

}