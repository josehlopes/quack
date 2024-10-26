package com.thigas.quack.domain.entity;

import com.thigas.quack.domain.model.Status;

import java.time.LocalDate;


public class UserRoadmapEntity {

    private int id;
    private UserEntity user;
    private RoadmapEntity roadmap;
    private Double progress;
    private LocalDate startedAt;
    private LocalDate finishedAt;
    private Status status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public RoadmapEntity getRoadmap() {
        return roadmap;
    }

    public void setRoadmap(RoadmapEntity roadmap) {
        this.roadmap = roadmap;
    }

    public Double getProgress() {
        return progress;
    }

    public void setProgress(Double progress) {
        this.progress = progress;
    }

    public LocalDate getStartedAt() {
        return startedAt;
    }

    public void setStartedAt(LocalDate startedAt) {
        this.startedAt = startedAt;
    }

    public LocalDate getFinishedAt() {
        return finishedAt;
    }

    public void setFinishedAt(LocalDate finishedAt) {
        this.finishedAt = finishedAt;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "UserRoadmapEntity{" +
                "id=" + id +
                ", user=" + user +
                ", roadmap=" + roadmap +
                ", progress=" + progress +
                ", startedAt=" + startedAt +
                ", finishedAt=" + finishedAt +
                ", status=" + status +
                '}';
    }
}
