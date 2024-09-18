package com.thigas.quack.infrastructure.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@Entity
@Table(name = "lesson")
public class LessonModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String description;

    @Column(nullable = true)
    private String language;

    @Column(name = "image_path", nullable = false)
    private String imagePath;

    @ManyToMany(mappedBy = "lessons")
    private Set<StepModel> steps;

    @ManyToMany(mappedBy = "lessons")
    private Set<TaskModel> tasks;

}
