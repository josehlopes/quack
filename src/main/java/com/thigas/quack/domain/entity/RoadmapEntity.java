package com.thigas.quack.domain.entity;

import com.thigas.quack.domain.model.Status;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoadmapEntity {

    private int id;
    private String title;
    private String description;
    private String imagePath;
    private Status status;
}