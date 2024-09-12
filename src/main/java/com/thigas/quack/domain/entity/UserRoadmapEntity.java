package com.thigas.quack.domain.entity;

public class UserRoadmapEntity {

    private int id;
    private UserEntity user;
    private RoadmapEntity roadmap;

    // Getters e Setters

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
}
