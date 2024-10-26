package com.thigas.quack.domain.entity;

import com.thigas.quack.domain.model.Status;


public class UserStepEntity {

    private int id;
    private UserEntity user;
    private StepEntity step;
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

    public StepEntity getStep() {
        return step;
    }

    public void setStep(StepEntity step) {
        this.step = step;
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
        return "UserStepEntity{" +
                "id=" + id +
                ", user=" + user +
                ", step=" + step +
                ", status=" + status +
                ", imagePath='" + imagePath + '\'' +
                '}';
    }
}
