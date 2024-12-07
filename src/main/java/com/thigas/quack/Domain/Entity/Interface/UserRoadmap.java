package com.thigas.quack.Domain.Entity.Interface;

import com.thigas.quack.Domain.Utils.Status;

import java.time.LocalDate;

public interface UserRoadmap {

    Integer getId();

    Integer getUserId();

    Integer getRoadmapId();

    Double getProgress();

    LocalDate getStartedIn();

    LocalDate getFinishedIn();

    Status getStatus();

    void addProgress(Double progress);
    void updateStatus(Status status);
    void updateFinishedIn(LocalDate finishedIn);

}
