package com.thigas.quack.adapter.dto;

import java.util.Set;

public class StepDTO {

    private int id;

    private Set<Integer> roadmapIds;

    private Set<Integer> lessonIds;

    private String description;

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Set<Integer> getRoadmapIds() {
        return roadmapIds;
    }

    public void setRoadmapIds(Set<Integer> roadmapIds) {
        this.roadmapIds = roadmapIds;
    }

    public Set<Integer> getLessonIds() {
        return lessonIds;
    }

    public void setLessonIds(Set<Integer> lessonIds) {
        this.lessonIds = lessonIds;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
