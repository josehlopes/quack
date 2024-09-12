package com.thigas.quack.adapter.dto;

public class RoadmapUserDTO {

    private Long id;
    private Long userId;
    private Long roadmapId;

    /**
     * @return Long return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return Long return the userId
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * @param userId the userId to set
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * @return Long return the roadmapId
     */
    public Long getRoadmapId() {
        return roadmapId;
    }

    /**
     * @param roadmapId the roadmapId to set
     */
    public void setRoadmapId(Long roadmapId) {
        this.roadmapId = roadmapId;
    }

}