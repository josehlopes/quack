package com.thigas.quack.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;

import java.util.Set;

import com.thigas.quack.domain.model.Status;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StepEntity {

    private int id;
    private Set<RoadmapEntity> roadmaps = new HashSet<>();
    private Set<LessonEntity> lessons = new HashSet<>();
    private Set<TaskEntity> tasks = new HashSet<>();
    private String description;
    private String imagePath;
    private Status status;

}
