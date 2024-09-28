package com.thigas.quack.infrastructure.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

import com.thigas.quack.domain.model.Status;

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

}