package com.thigas.quack.adapter.dto;

public class UserTaskDTO {

    private int id;
    private int user;
    private int task;
    private int status;
    private String imagePath;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser() {
        return user;
    }

    public void setUser(int user) {
        this.user = user;
    }

    public int getTask() {
        return task;
    }

    public void setTask(int task) {
        this.task = task;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
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
        return "UserTaskDTO{" +
                "id=" + id +
                ", user=" + user +
                ", task=" + task +
                ", status=" + status +
                ", imagePath='" + imagePath + '\'' +
                '}';
    }
}