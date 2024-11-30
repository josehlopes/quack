package com.thigas.quack.Domain.Entity.Interface;

import com.thigas.quack.Domain.Utils.Status;

import java.util.Set;

public interface Step {

    Integer getId();
    Set<Roadmap> getRoadmaps();
    Set<Lesson> getLessons();
    Set<Task> getTasks();
    String getDescription();
    String getImagePath();
    Status getStatus();
}
