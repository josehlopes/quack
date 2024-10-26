package com.thigas.quack.adapter.dto;

import java.util.Set;

public class StepDTO {

    private int id;
    private Set<Integer> roadmaps;
    private Set<Integer> lessons;
    private Set<Integer> tasks;
    private String description;
    private String imagePath;
    private int status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Set<Integer> getRoadmaps() {
        return roadmaps;
    }

    public void setRoadmaps(Set<Integer> roadmaps) {
        this.roadmaps = roadmaps;
    }

    public Set<Integer> getLessons() {
        return lessons;
    }

    public void setLessons(Set<Integer> lessons) {
        this.lessons = lessons;
    }

    public Set<Integer> getTasks() {
        return tasks;
    }

    public void setTasks(Set<Integer> tasks) {
        this.tasks = tasks;
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

    @Override
    public String toString() {
        return "StepDTO{" +
                "id=" + id +
                ", roadmaps=" + roadmaps +
                ", lessons=" + lessons +
                ", tasks=" + tasks +
                ", description='" + description + '\'' +
                ", imagePath='" + imagePath + '\'' +
                ", status=" + status +
                '}';
    }
}
