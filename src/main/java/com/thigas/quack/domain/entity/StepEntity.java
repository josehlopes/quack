package com.thigas.quack.domain.entity;

import com.thigas.quack.adapter.model.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashSet;

import java.util.List;
import java.util.Set;

import com.thigas.quack.domain.model.Status;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StepEntity extends BaseEntity {

    private int id;
    private List<RoadmapEntity> roadmaps;
    private List<LessonEntity> lessons;
    private List<TaskEntity> tasks;
    private String description;
    private String imagePath;
    private Status status;

}
