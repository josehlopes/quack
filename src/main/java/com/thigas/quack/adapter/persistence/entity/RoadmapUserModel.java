package com.thigas.quack.adapter.persistence.entity;

import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
@Table(name = "roadmap_user")
public class RoadmapUserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserModel user;

    @ManyToOne
    @JoinColumn(name = "roadmap_id", nullable = false)
    private RoadmapModel roadmap;

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
     * @return UserModel return the user
     */
    public UserModel getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(UserModel user) {
        this.user = user;
    }

    /**
     * @return RoadmapModel return the roadmap
     */
    public RoadmapModel getRoadmap() {
        return roadmap;
    }

    /**
     * @param roadmap the roadmap to set
     */
    public void setRoadmap(RoadmapModel roadmap) {
        this.roadmap = roadmap;
    }

}