package com.thigas.quack.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TaskEntity {

    private int id;
    private Set<StepEntity> steps;
    private String description;
    private String imagePath;

}