package com.thigas.quack.adapter.dto;

import lombok.Data;

import java.util.Set;

@Data
public class StepDTO {

    private int id;
    private Set<Integer> roadmaps;
    private Set<Integer> lessons;
    private Set<Integer> tasks;
    private String description;
    private String imagePath;
    private int status;

}
