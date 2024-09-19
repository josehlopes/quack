package com.thigas.quack.infrastructure.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@Entity
@Table(name = "step")
public class StepModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToMany
    @JoinTable(name = "roadmap_step_mapping", joinColumns = @JoinColumn(name = "step_id"), inverseJoinColumns = @JoinColumn(name = "roadmap_id"))
    private Set<RoadmapModel> roadmaps;

    @ManyToMany
    @JoinTable(name = "step_lesson_mapping", joinColumns = @JoinColumn(name = "step_id"), inverseJoinColumns = @JoinColumn(name = "lesson_id"))
    private Set<LessonModel> lessons;

    @Column(nullable = false)
    private String description;
}
