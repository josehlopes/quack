package com.thigas.quack.UseCase.Model.Request;

import com.thigas.quack.Domain.Utils.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRoadmapDsRequestModel {

    private int id;
    private UserDsRequestModel user;
    private RoadmapDsRequestModel roadmap;
    private Double progress;
    private LocalDate startedAt;
    private LocalDate finishedAt;
    private Status status;
}
