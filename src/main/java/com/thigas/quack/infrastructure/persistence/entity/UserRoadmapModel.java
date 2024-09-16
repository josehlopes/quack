package com.thigas.quack.infrastructure.persistence.entity;

import java.time.LocalDate;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "user_roadmap")
public class UserRoadmapModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserModel userId;

    @ManyToOne
    @JoinColumn(name = "roadmap_id", nullable = false)
    private RoadmapModel roadmapId;

    @Column(name = "progress", nullable = false)
    private Double progress;

    @Column(name = "started_at", columnDefinition = "DATE", nullable = false)
    private LocalDate startedAt;

    @Column(name = "finished_at", columnDefinition = "DATE", nullable = true)
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
     * @return UserModel return the userId
     */
    public UserModel getUserId() {
        return userId;
    }

    /**
     * @param userId the userId to set
     */
    public void setUserId(UserModel userId) {
        this.userId = userId;
    }

    /**
     * @return RoadmapModel return the roadmapId
     */
    public RoadmapModel getRoadmapId() {
        return roadmapId;
    }

    /**
     * @param roadmapId the roadmapId to set
     */
    public void setRoadmapId(RoadmapModel roadmapId) {
        this.roadmapId = roadmapId;
    }

    /**
     * @return Double return the progress
     */
    public Double getProgress() {
        return progress;
    }

    /**
     * @param progress the progress to set
     */
    public void setProgress(Double progress) {
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