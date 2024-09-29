package com.thigas.quack.domain.entity;

import com.thigas.quack.adapter.model.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

import com.thigas.quack.domain.model.Status;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRoadmapEntity extends BaseEntity {

    private int id;
    private UserEntity user;
    private RoadmapEntity roadmap;
    private Double progress;
    private LocalDate startedAt;
    private LocalDate finishedAt;
    private Status status;
}
