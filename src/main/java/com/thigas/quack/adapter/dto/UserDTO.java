package com.thigas.quack.adapter.dto;

public class UserDTO {

    private Long id;
    private String name;
    private String phone;
    private String email;
    private String password;
    private String cpf;
    private String bornAt;
    private Double points;
    private String registerAt;
    private String imagePath;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getBornAt() {
        return bornAt;
    }

    public void setBornAt(String bornAt) {
        this.bornAt = bornAt;
    }

    public Double getPoints() {
        return points;
    }

    public void setPoints(Double points) {
        this.points = points;
    }

    public String getRegisterAt() {
        return registerAt;
    }

    public void setRegisterAt(String registerAt) {
        this.registerAt = registerAt;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
}
