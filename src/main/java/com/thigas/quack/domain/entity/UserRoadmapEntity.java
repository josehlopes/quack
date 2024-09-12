package com.thigas.quack.domain.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRoadmapEntity {

    private int id;
    private UserEntity user;
    private RoadmapEntity roadmap;
}
