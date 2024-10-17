package com.thigas.quack.adapter.dto;

import lombok.Data;

import java.util.Set;

@Data
public class RoadmapDTO {

    private int id;
    private String title;
    private String description;
    private String imagePath;
    private int status;
    private Set<Integer> steps;

}