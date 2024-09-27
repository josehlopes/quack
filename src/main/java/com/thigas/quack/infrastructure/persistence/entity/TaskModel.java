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

    @ManyToMany(mappedBy = "tasks", fetch = FetchType.LAZY)
    private Set<StepModel> steps;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String imagePath;
}
