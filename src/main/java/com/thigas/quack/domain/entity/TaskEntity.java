package com.thigas.quack.domain.entity;

import java.util.Set;


public class TaskEntity {

    private int id;
    private String description;
    private TaskText tasktext;
    private Set<StepEntity> steps;

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public TaskText getTasktext() {
        return tasktext;
    }

    public Set<StepEntity> getSteps() {
        return steps;
    }

    @Override
    public String toString() {
        return "TaskEntity{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", tasktext=" + tasktext +
                ", steps=" + steps +
                '}';
    }
}