package com.thigas.quack.infrastructure.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

import com.thigas.quack.domain.model.Status;

@Data
@NoArgsConstructor
@Entity
@Table(name = "step")
public class StepModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "roadmap_step_mapping", joinColumns = @JoinColumn(name = "step_id"), inverseJoinColumns = @JoinColumn(name = "roadmap_id"))
    private Set<RoadmapModel> roadmaps;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "step_lesson_mapping", joinColumns = @JoinColumn(name = "step_id"), inverseJoinColumns = @JoinColumn(name = "lesson_id"))
    private Set<LessonModel> lessons;

    @Column(nullable = false)
    private String description;

    @Column(name = "image_path", nullable = true)
    private String imagePath;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "status", nullable = false)
    private Status status = Status.ACTIVE;

}
