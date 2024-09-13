package com.thigas.quack.adapter.dto;

public class UserRoadmapDTO {

    private int id;
    private int userId;
    private int roadmapId;
    private double progress;
    private String startedAt;
    private String finishedAt;

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
     * @return int return the userId
     */
    public int getUserId() {
        return userId;
    }

    /**
     * @param userId the userId to set
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     * @return int return the roadmapId
     */
    public int getRoadmapId() {
        return roadmapId;
    }

    /**
     * @param roadmapId the roadmapId to set
     */
    public void setRoadmapId(int roadmapId) {
        this.roadmapId = roadmapId;
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
     * @return String return the startedAt
     */
    public String getStartedAt() {
        return startedAt;
    }

    /**
     * @param startedAt the startedAt to set
     */
    public void setStartedAt(String startedAt) {
        this.startedAt = startedAt;
    }

    /**
     * @return String return the finishedAt
     */
    public String getFinishedAt() {
        return finishedAt;
    }

    /**
     * @param finishedAt the finishedAt to set
     */
    public void setFinishedAt(String finishedAt) {
        this.finishedAt = finishedAt;
    }

}