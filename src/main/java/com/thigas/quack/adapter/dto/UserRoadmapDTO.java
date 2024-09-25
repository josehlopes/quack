package com.thigas.quack.adapter.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class UserRoadmapDTO {

    private int id;
    private int userId;
    private int roadmapId;
    private Double progress;
    private String startedAt;
    private String finishedAt;
    private int status;
}