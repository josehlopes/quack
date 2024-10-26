package com.thigas.quack.domain.entity;

import com.thigas.quack.adapter.model.BaseEntity;
import com.thigas.quack.domain.model.Status;

import java.util.Set;

public class RoadmapEntity implements BaseEntity {

    private int id;
    private String title;
    private String description;
    private String imagePath;
    private Status status;
    private Set<StepEntity> steps;

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Set<StepEntity> getSteps() {
        return steps;
    }

    public void setSteps(Set<StepEntity> steps) {
        this.steps = steps;
    }

    @Override
    public String toString() {
        return "RoadmapEntity{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", imagePath='" + imagePath + '\'' +
                ", status=" + status +
                ", steps=" + steps +
                '}';
    }
}