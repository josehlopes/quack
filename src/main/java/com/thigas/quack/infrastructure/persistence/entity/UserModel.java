package com.thigas.quack.infrastructure.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.OffsetDateTime;

@Data
@NoArgsConstructor
@Entity
@Table(name = "app_user")
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String phone;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, unique = true, length = 11)
    private String cpf;

    @Column(name = "born_at", columnDefinition = "DATE", nullable = false)
    private LocalDate bornAt;

    @Column(name = "points", nullable = false)
    private Double points;

    @Column(name = "register_at", columnDefinition = "TIMESTAMP WITH TIME ZONE", nullable = false)
    private OffsetDateTime registerAt;

    @Column(name = "image_path", nullable = true)
    private String imagePath;
}
