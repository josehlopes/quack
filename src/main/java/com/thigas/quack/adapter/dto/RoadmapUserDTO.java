package com.thigas.quack.adapter.dto;

public class RoadmapUserDTO {

    private int id;
    private int userId;
    private int roadmapId;

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

}