package com.thigas.quack.adapter.dto;

import java.util.Set;

public class RoadmapDTO {

    private int id;
    private String title;
    private String description;
    private String imagePath;
    private int status;
    private Set<Integer> steps;

    public int getId() {
        return id;
    }

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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Set<Integer> getSteps() {
        return steps;
    }

    public void setSteps(Set<Integer> steps) {
        this.steps = steps;
    }

    @Override
    public String toString() {
        return "RoadmapDTO{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", imagePath='" + imagePath + '\'' +
                ", status=" + status +
                ", steps=" + steps +
                '}';
    }
}