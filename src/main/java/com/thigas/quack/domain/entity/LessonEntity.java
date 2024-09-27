package com.thigas.quack.domain.entity;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LessonEntity {

    private int id;
    private String title;
    private String description;
    private String language;
    private String imagePath;
    private Set<StepEntity> steps;

}
