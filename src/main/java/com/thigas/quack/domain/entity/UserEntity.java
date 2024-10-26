package com.thigas.quack.domain.entity;

import com.thigas.quack.domain.model.Status;

import java.time.LocalDate;
import java.time.OffsetDateTime;


public class UserEntity {

    private int id;
    private String name;
    private String username;
    private String phone;
    private String email;
    private String password;
    private String cpf;
    private LocalDate bornAt;
    private Double points;
    private OffsetDateTime registerAt;
    private String imagePath;
    private Status status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getBornAt() {
        return bornAt;
    }

    public void setBornAt(LocalDate bornAt) {
        this.bornAt = bornAt;
    }

    public Double getPoints() {
        return points;
    }

    public void setPoints(Double points) {
        this.points = points;
    }

    public OffsetDateTime getRegisterAt() {
        return registerAt;
    }

    public void setRegisterAt(OffsetDateTime registerAt) {
        this.registerAt = registerAt;
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
        return "UserEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", cpf='" + cpf + '\'' +
                ", bornAt=" + bornAt +
                ", points=" + points +
                ", registerAt=" + registerAt +
                ", imagePath='" + imagePath + '\'' +
                ", status=" + status +
                '}';
    }
}
