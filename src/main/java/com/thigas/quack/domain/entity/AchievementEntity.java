package com.thigas.quack.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AchievementEntity {

    private int id;
    private String name;
    private String description;
    private String imagePath;
}