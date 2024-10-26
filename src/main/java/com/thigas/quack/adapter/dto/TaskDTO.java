package com.thigas.quack.adapter.dto;

import com.thigas.quack.domain.entity.TaskText;

import java.util.Set;

public class TaskDTO {

    private int id;
    private Set<Integer> steps;
    private TaskText tasktext;
    private String imagePath;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Set<Integer> getSteps() {
        return steps;
    }

    public void setSteps(Set<Integer> steps) {
        this.steps = steps;
    }

    public TaskText getTasktext() {
        return tasktext;
    }

    public void setTasktext(TaskText tasktext) {
        this.tasktext = tasktext;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    @Override
    public String toString() {
        return "TaskDTO{" +
                "id=" + id +
                ", steps=" + steps +
                ", tasktext=" + tasktext +
                ", imagePath='" + imagePath + '\'' +
                '}';
    }
}
