package com.thigas.quack.domain.entity;

import com.thigas.quack.domain.model.Status;


public class UserTaskEntity {

    private int id;
    private UserEntity user;
    private TaskEntity task;
    private Status status;
    private String imagePath;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public TaskEntity getTask() {
        return task;
    }

    public void setTask(TaskEntity task) {
        this.task = task;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    @Override
    public String toString() {
        return "UserTaskEntity{" +
                "id=" + id +
                ", user=" + user +
                ", task=" + task +
                ", status=" + status +
                ", imagePath='" + imagePath + '\'' +
                '}';
    }
}