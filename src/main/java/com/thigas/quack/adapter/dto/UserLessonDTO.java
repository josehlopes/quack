package com.thigas.quack.adapter.dto;

public class UserLessonDTO {
    private int id;
    private int user;
    private int lesson;
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

    public int getLesson() {
        return lesson;
    }

    public void setLesson(int lesson) {
        this.lesson = lesson;
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
        return "UserLessonDTO{" +
                "id=" + id +
                ", user=" + user +
                ", lesson=" + lesson +
                ", status=" + status +
                ", imagePath='" + imagePath + '\'' +
                '}';
    }
}
