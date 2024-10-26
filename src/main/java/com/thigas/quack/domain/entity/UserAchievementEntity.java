package com.thigas.quack.domain.entity;

import com.thigas.quack.domain.model.Status;

import java.time.OffsetDateTime;


public class UserAchievementEntity {

    private int id;
    private UserEntity user;
    private AchievementEntity achievement;
    private String imagePath;
    private OffsetDateTime obtainedDate;
    private Status status;

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

    public AchievementEntity getAchievement() {
        return achievement;
    }

    public void setAchievement(AchievementEntity achievement) {
        this.achievement = achievement;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public OffsetDateTime getObtainedDate() {
        return obtainedDate;
    }

    public void setObtainedDate(OffsetDateTime obtainedDate) {
        this.obtainedDate = obtainedDate;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "UserAchievementEntity{" +
                "id=" + id +
                ", user=" + user +
                ", achievement=" + achievement +
                ", imagePath='" + imagePath + '\'' +
                ", obtainedDate=" + obtainedDate +
                ", status=" + status +
                '}';
    }
}
