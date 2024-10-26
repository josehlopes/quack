package com.thigas.quack.infrastructure.persistence.entity;

import jakarta.persistence.*;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "lesson")
public class LessonModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String description;

    @Column(nullable = true)
    private String language;

    @Column(name = "image_path", nullable = false)
    private String imagePath;

    @Column(name = "completed", nullable = false)
    private boolean completed = false;

    @Column(name = "link", nullable = true)
    private String link;

    @ManyToMany(mappedBy = "lessons", fetch = FetchType.LAZY)
    @ToString.Exclude
    private Set<StepModel> steps = new HashSet<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Set<StepModel> getSteps() {
        return steps;
    }

    public void setSteps(Set<StepModel> steps) {
        this.steps = steps;
    }

    @Override
    public String toString() {
        return "LessonModel{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", language='" + language + '\'' +
                ", imagePath='" + imagePath + '\'' +
                ", completed=" + completed +
                ", link='" + link + '\'' +
                ", steps=" + steps +
                '}';
    }
}
