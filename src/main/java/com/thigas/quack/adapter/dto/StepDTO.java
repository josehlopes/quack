package com.thigas.quack.adapter.dto;

import lombok.Data;

import java.util.Set;

@Data
public class StepDTO {

    private int id;

    private Set<Integer> roadmapIds;

    private Set<Integer> lessonIds;

    private String description;

}
