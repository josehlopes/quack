package com.thigas.quack.infrastructure.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

import com.thigas.quack.domain.model.Status;

@Data
@NoArgsConstructor
@Entity
@Table(name = "roadmap")
public class RoadmapModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String description;

    @Column(name = "image_path", nullable = false)
    private String imagePath;

    @ManyToMany(mappedBy = "roadmaps")
    private Set<StepModel> steps;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "status", nullable = false)
    private Status status = Status.ACTIVE;

}