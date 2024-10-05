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

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StepEntity implements BaseEntity {

    private int id;
    private Set<RoadmapEntity> roadmaps;
    private Set<LessonEntity> lessons;
    private Set<TaskEntity> tasks;
    private String description;
    private String imagePath;
    private Status status;

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }



}
