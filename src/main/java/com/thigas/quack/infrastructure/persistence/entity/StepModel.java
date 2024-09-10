package com.thigas.quack.infrastructure.persistence.entity;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "step")
public class StepModel {

    @Id
    private Long id;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "step_lesson", joinColumns = @JoinColumn(name = "step_id"), inverseJoinColumns = @JoinColumn(name = "lesson_id"))
    private Set<LessonModel> lessons;

    @Column(nullable = false)
    private String description;

    // Getters e Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<LessonModel> getLessons() {
        return lessons;
    }

    public void setLessons(Set<LessonModel> lessons) {
        this.lessons = lessons;
    }

    /**
     * @return String return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

}
