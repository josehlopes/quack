package com.thigas.quack.adapter.dto;

import lombok.Data;

import java.util.Set;

@Data
public class TaskDTO {

    private int id;
    private Set<Integer> lessonIds;
    private String description;
    private String imagePath;
}
