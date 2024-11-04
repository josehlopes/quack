package com.thigas.quack.Adapter.Dto;

import com.thigas.quack.Domain.Utils.Status;
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