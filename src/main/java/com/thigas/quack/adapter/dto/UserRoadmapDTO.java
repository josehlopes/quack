package com.thigas.quack.adapter.dto;

import com.thigas.quack.domain.entity.UserAchievementEntity;
import com.thigas.quack.domain.model.Status;
import lombok.Data;

@Data
public class UserRoadmapDTO {

    private int id;
    private UserDTO user;
    private RoadmapDTO roadmap;
    private Double progress;
    private String startedAt;
    private String finishedAt;
    private Status status;


}