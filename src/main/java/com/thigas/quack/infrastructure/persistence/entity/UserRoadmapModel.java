package com.thigas.quack.infrastructure.persistence.entity;

import com.thigas.quack.adapter.model.BaseModel;
import com.thigas.quack.domain.model.Status;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "user_roadmap")
public class UserRoadmapModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserModel user;

    @ManyToOne
    @JoinColumn(name = "roadmap_id", nullable = false)
    private RoadmapModel roadmap;

    @Column(name = "progress", nullable = false)
    private Double progress;

    @Column(name = "started_at", columnDefinition = "DATE", nullable = false)
    private LocalDate startedAt;

    @Column(name = "finished_at", columnDefinition = "DATE", nullable = true)
    private LocalDate finishedAt;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "status", nullable = false)
    private Status status = Status.ACTIVE;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }

    public RoadmapModel getRoadmap() {
        return roadmap;
    }

    public void setRoadmap(RoadmapModel roadmap) {
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
        return "UserRoadmapModel{" +
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