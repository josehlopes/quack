package com.thigas.quack.adapter.dto;

import lombok.Data;

import java.util.Set;

import java.util.Set;

@Data
public class LessonDTO {

    private int id;
    private String title;
    private String description;
    private String language;
    private String imagePath;
    private boolean completed;
    private String link;
    private Set<StepDTO> steps;

}
