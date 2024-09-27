package com.thigas.quack.infrastructure.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.thigas.quack.domain.model.Status;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
@Table(name = "step")
public class StepModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "step_roadmap_mapping", joinColumns = @JoinColumn(name = "step_id"), inverseJoinColumns = @JoinColumn(name = "roadmap_id"))
    private Set<RoadmapModel> roadmaps = new HashSet<>();

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "step_task_mapping", joinColumns = @JoinColumn(name = "step_id"), inverseJoinColumns = @JoinColumn(name = "task_id"))
    private Set<TaskModel> tasks = new HashSet<>();

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "step_lesson_mapping", joinColumns = @JoinColumn(name = "step_id"), inverseJoinColumns = @JoinColumn(name = "lesson_id"))
    private Set<LessonModel> lessons = new HashSet<>();
    @Column(nullable = false)
    private String description;

    @Column(name = "image_path", nullable = true)
    private String imagePath;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "status", nullable = false)
    private Status status = Status.ACTIVE;

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        StepModel stepModel = (StepModel) obj;
        return id == stepModel.id;
    }
}
