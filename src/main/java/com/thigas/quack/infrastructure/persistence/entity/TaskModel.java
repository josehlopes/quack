package com.thigas.quack.infrastructure.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@Entity
@Table(name = "task")
public class TaskModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToMany
    @JoinTable(name = "task_lesson_mapping", joinColumns = @JoinColumn(name = "task_id"), inverseJoinColumns = @JoinColumn(name = "lesson_id"))
    private Set<LessonModel> lessons;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String imagePath;
}
