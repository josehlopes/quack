package com.thigas.quack.domain.entity;

import com.thigas.quack.domain.model.Status;


public class UserLessonEntity {

    private int id;
    private UserEntity user;
    private LessonEntity lesson;
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

    public LessonEntity getLesson() {
        return lesson;
    }

    public void setLesson(LessonEntity lesson) {
        this.lesson = lesson;
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
        return "UserLessonEntity{" +
                "id=" + id +
                ", user=" + user +
                ", lesson=" + lesson +
                ", status=" + status +
                ", imagePath='" + imagePath + '\'' +
                '}';
    }
}
