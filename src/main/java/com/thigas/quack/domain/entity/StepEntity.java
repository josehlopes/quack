package com.thigas.quack.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StepEntity {

    private int id;

    private Set<RoadmapEntity> roadmaps;

    private Set<LessonEntity> lessons;

    private String description;

}
