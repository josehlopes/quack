package com.thigas.quack.infrastructure.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "user_task")
public class UserTaskModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserModel userId;

    @ManyToOne
    @JoinColumn(nullable = false)
    private TaskModel taskId;

    @Column(nullable = false)
    private Boolean status;

    @Column(nullable = false)
    private String imagePath;

}