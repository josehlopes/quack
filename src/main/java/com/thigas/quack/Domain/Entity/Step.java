package com.thigas.quack.Domain.Entity;

import com.thigas.quack.Domain.Utils.Status;

import java.util.Set;

public interface Step {

    int getId();

    Set<Roadmap> getRoadmaps();

    Set<Lesson> getLessons();

    Set<Task> getTasks();

    String getDescription();

    String getImagePath();

    Status getStatus();

}
