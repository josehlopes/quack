package com.thigas.quack.domain.entity;

import java.util.Set;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LessonEntity {

    private int id;
    private String title;
    private String description;
    private String language;
    private String imagePath;
    private Set<RoadmapEntity> roadmaps;
}
