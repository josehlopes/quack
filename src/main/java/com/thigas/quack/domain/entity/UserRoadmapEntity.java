package com.thigas.quack.domain.entity;

import java.time.LocalDate;

public class UserRoadmapEntity {

    private int id;
    private UserEntity user;
    private RoadmapEntity roadmap;
    private double progress;
    private LocalDate startedAt;
    private LocalDate finishedAt;

    /**
     * @return int return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return UserEntity return the user
     */
    public UserEntity getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(UserEntity user) {
        this.user = user;
    }

    /**
     * @return RoadmapEntity return the roadmap
     */
    public RoadmapEntity getRoadmap() {
        return roadmap;
    }

    /**
     * @param roadmap the roadmap to set
     */
    public void setRoadmap(RoadmapEntity roadmap) {
        this.roadmap = roadmap;
    }

    /**
     * @return double return the progress
     */
    public double getProgress() {
        return progress;
    }

    /**
     * @param progress the progress to set
     */
    public void setProgress(double progress) {
        this.progress = progress;
    }

    /**
     * @return LocalDate return the startedAt
     */
    public LocalDate getStartedAt() {
        return startedAt;
    }

    /**
     * @param startedAt the startedAt to set
     */
    public void setStartedAt(LocalDate startedAt) {
        this.startedAt = startedAt;
    }

    /**
     * @return LocalDate return the finishedAt
     */
    public LocalDate getFinishedAt() {
        return finishedAt;
    }

    /**
     * @param finishedAt the finishedAt to set
     */
    public void setFinishedAt(LocalDate finishedAt) {
        this.finishedAt = finishedAt;
    }

}
