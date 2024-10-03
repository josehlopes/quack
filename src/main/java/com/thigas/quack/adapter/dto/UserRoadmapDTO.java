package com.thigas.quack.adapter.dto;

import lombok.Data;

@Data
public class UserRoadmapDTO {

    private int id;
    private int user;
    private int roadmap;
    private Double progress;
    private String startedAt;
    private String finishedAt;
    private int status;

}