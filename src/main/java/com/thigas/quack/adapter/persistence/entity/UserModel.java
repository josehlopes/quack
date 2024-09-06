package com.thigas.quack.adapter.persistence.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "varchar(255)", nullable = false)
    private String name;

    @Column(columnDefinition = "varchar(255)", nullable = false)
    private String phone;

    @Column(columnDefinition = "varchar(255)", nullable = false)
    private String email;

    @Column(columnDefinition = "varchar(255)", nullable = false)
    private String password;

    @Column(columnDefinition = "varchar(255)", nullable = false)
    private String cpf;

    @Column(name = "born_at", columnDefinition = "varchar(255)", nullable = false)
    private LocalDate bornAt;

    @Column(name = "points", columnDefinition = "varchar(255)", nullable = false)
    private Double points;

    @Column(name = "register_at", columnDefinition = "varchar(255)", nullable = false)
    private LocalDateTime registerAt;

    @Column(name = "image_path", columnDefinition = "varchar(255)", nullable = true)
    private String imagePath;

    // Getters e Setters
    /**
     * @return Long return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return String return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return String return the phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone the phone to set
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * @return String return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return String return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return String return the cpf
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * @param cpf the cpf to set
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    /**
     * @return LocalDate return the bornAt
     */
    public LocalDate getBornAt() {
        return bornAt;
    }

    /**
     * @param bornAt the bornAt to set
     */
    public void setBornAt(LocalDate bornAt) {
        this.bornAt = bornAt;
    }

    /**
     * @return Double return the points
     */
    public Double getPoints() {
        return points;
    }

    /**
     * @param points the points to set
     */
    public void setPoints(Double points) {
        this.points = points;
    }

    /**
     * @return LocalDateTime return the registerAt
     */
    public LocalDateTime getRegisterAt() {
        return registerAt;
    }

    /**
     * @param registerAt the registerAt to set
     */
    public void setRegisterAt(LocalDateTime registerAt) {
        this.registerAt = registerAt;
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
