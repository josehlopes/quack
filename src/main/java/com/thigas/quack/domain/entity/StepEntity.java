package com.thigas.quack.domain.entity;

import com.thigas.quack.domain.model.Status;

import java.util.Set;

public class StepEntity {

    private int id;
    private Set<RoadmapEntity> roadmaps;
    private Set<LessonEntity> lessons;
    private Set<TaskEntity> tasks;
    private String description;
    private String imagePath;
    private Status status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Set<RoadmapEntity> getRoadmaps() {
        return roadmaps;
    }

    public void setRoadmaps(Set<RoadmapEntity> roadmaps) {
        this.roadmaps = roadmaps;
    }

    public Set<LessonEntity> getLessons() {
        return lessons;
    }

    public void setLessons(Set<LessonEntity> lessons) {
        this.lessons = lessons;
    }

    public Set<TaskEntity> getTasks() {
        return tasks;
    }

    public void setTasks(Set<TaskEntity> tasks) {
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

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "StepEntity{" +
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
