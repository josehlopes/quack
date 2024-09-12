package com.thigas.quack.adapter.dto;

import java.util.Set;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LessonDTO {

    private int id;
    private String title;
    private String description;
    private String language;
    private String imagePath;
    private Set<Integer> roadmapIds;
}
