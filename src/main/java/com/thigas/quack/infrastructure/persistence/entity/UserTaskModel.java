package com.thigas.quack.infrastructure.persistence.entity;

import com.thigas.quack.adapter.model.BaseModel;
import com.thigas.quack.domain.model.Status;
import jakarta.persistence.*;

@Entity
@Table(name = "user_task")
public class UserTaskModel implements BaseModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserModel user;

    @ManyToOne
    @JoinColumn(name = "task_id", nullable = false)
    private TaskModel task;

    @Column(nullable = false)
    private String imagePath;

    @Column(name = "status")
    @Enumerated(EnumType.ORDINAL)
    private Status status = Status.ACTIVE;

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }

    public TaskModel getTask() {
        return task;
    }

    public void setTask(TaskModel task) {
        this.task = task;
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
        return "UserTaskModel{" +
                "id=" + id +
                ", user=" + user +
                ", task=" + task +
                ", imagePath='" + imagePath + '\'' +
                ", status=" + status +
                '}';
    }
}