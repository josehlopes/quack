package com.thigas.quack.infrastructure.persistence.entity;

import com.thigas.quack.domain.model.Status;
import jakarta.persistence.*;

@Entity
@Table(name = "user_step")
public class UserStepModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserModel user;

    @ManyToOne
    @JoinColumn(name = "step_id", nullable = false)
    private StepModel step;

    @Column(nullable = false)
    private String imagePath;

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

    public StepModel getStep() {
        return step;
    }

    public void setStep(StepModel step) {
        this.step = step;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "UserStepModel{" +
                "id=" + id +
                ", user=" + user +
                ", step=" + step +
                ", imagePath='" + imagePath + '\'' +
                ", status=" + status +
                '}';
    }
}
