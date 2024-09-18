package com.thigas.quack.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRoadmapEntity {

    private int id;
    private UserEntity user;
    private RoadmapEntity roadmap;
    private Double progress;
    private LocalDate startedAt;
    private LocalDate finishedAt;
}
