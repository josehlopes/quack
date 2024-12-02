package com.thigas.quack.Domain.Entity.Interface;

import com.thigas.quack.Domain.Utils.Status;

import java.time.LocalDate;

public interface UserRoadmap {

    int getId();

    User getUser();

    Roadmap getRoadmap();

    Double getProgress();

    LocalDate getStartedOn();

    LocalDate getFinishedOn();

    Status getStatus();

}
