package com.thigas.quack.infrastructure.persistence.entity;

import com.thigas.quack.adapter.model.BaseModel;
import com.thigas.quack.domain.model.Status;
import jakarta.persistence.*;

import java.time.OffsetDateTime;

@Entity
@Table(name = "user_achievement")
public class UserAchievementModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserModel user;

    @ManyToOne
    @JoinColumn(name = "achievement_id", nullable = false)
    private AchievementModel achievement;

    @Column(name = "image_path")
    private String imagePath;

    @Column(name = "obtained_date")
    private OffsetDateTime obtainedDate;

    @Column(name = "status")
    @Enumerated(EnumType.ORDINAL)
    private Status status = Status.ACTIVE;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }

    public AchievementModel getAchievement() {
        return achievement;
    }

    public void setAchievement(AchievementModel achievement) {
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
        return "UserAchievementModel{" +
                "id=" + id +
                ", user=" + user +
                ", achievement=" + achievement +
                ", imagePath='" + imagePath + '\'' +
                ", obtainedDate=" + obtainedDate +
                ", status=" + status +
                '}';
    }
}
