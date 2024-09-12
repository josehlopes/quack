package com.thigas.quack.infrastructure.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "task_user")
public class UserTaskModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserModel user;

    @ManyToOne
    @JoinColumn(nullable = false)
    private TaskModel task;

    @Column(nullable = false)
    private String status;

    @Column(nullable = false)
    private String imagePath;

    /**
     * @return int return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return UserModel return the user
     */
    public UserModel getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(UserModel user) {
        this.user = user;
    }

    /**
     * @return TaskModel return the task
     */
    public TaskModel getTask() {
        return task;
    }

    /**
     * @param task the task to set
     */
    public void setTask(TaskModel task) {
        this.task = task;
    }

    /**
     * @return String return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return String return the imagePath
     */
    public String getImagePath() {
        return imagePath;
    }

    /**
     * @param imagePath the imagePath to set
     */
    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

}