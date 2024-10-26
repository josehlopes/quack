package com.thigas.quack.adapter.dto;

public class UserRoadmapDTO {

    private int id;
    private int user;
    private int roadmap;
    private Double progress;
    private String startedAt;
    private String finishedAt;
    private int status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser() {
        return user;
    }

    public void setUser(int user) {
        this.user = user;
    }

    public int getRoadmap() {
        return roadmap;
    }

    public void setRoadmap(int roadmap) {
        this.roadmap = roadmap;
    }

    public Double getProgress() {
        return progress;
    }

    public void setProgress(Double progress) {
        this.progress = progress;
    }

    public String getStartedAt() {
        return startedAt;
    }

    public void setStartedAt(String startedAt) {
        this.startedAt = startedAt;
    }

    public String getFinishedAt() {
        return finishedAt;
    }

    public void setFinishedAt(String finishedAt) {
        this.finishedAt = finishedAt;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "UserRoadmapDTO{" +
                "id=" + id +
                ", user=" + user +
                ", roadmap=" + roadmap +
                ", progress=" + progress +
                ", startedAt='" + startedAt + '\'' +
                ", finishedAt='" + finishedAt + '\'' +
                ", status=" + status +
                '}';
    }
}