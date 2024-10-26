package com.thigas.quack.adapter.dto;

public class UserStepDTO {
    private int id;
    private int user;
    private int step;
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

    public int getStep() {
        return step;
    }

    public void setStep(int step) {
        this.step = step;
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
        return "UserStepDTO{" +
                "id=" + id +
                ", user=" + user +
                ", step=" + step +
                ", status=" + status +
                ", imagePath='" + imagePath + '\'' +
                '}';
    }
}
