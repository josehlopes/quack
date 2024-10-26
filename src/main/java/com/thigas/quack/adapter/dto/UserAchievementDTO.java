package com.thigas.quack.adapter.dto;

public class UserAchievementDTO {

    private int id;
    private int user;
    private String imagePath;
    private int achievement;
    private String obtainedDate;
    private int status;

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

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public int getAchievement() {
        return achievement;
    }

    public void setAchievement(int achievement) {
        this.achievement = achievement;
    }

    public String getObtainedDate() {
        return obtainedDate;
    }

    public void setObtainedDate(String obtainedDate) {
        this.obtainedDate = obtainedDate;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "UserAchievementDTO{" +
                "id=" + id +
                ", user=" + user +
                ", imagePath='" + imagePath + '\'' +
                ", achievement=" + achievement +
                ", obtainedDate='" + obtainedDate + '\'' +
                ", status=" + status +
                '}';
    }
}
