package com.thigas.quack.infrastructure.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
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

}