package com.thigas.quack.domain.entity;

import java.util.Set;


public class LessonEntity {

    private int id;
    private String title;
    private String description;
    private String language;
    private String imagePath;
    private boolean completed;
    private String link;
    private Set<StepEntity> steps;

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

    public Set<StepEntity> getSteps() {
        return steps;
    }

    public void setSteps(Set<StepEntity> steps) {
        this.steps = steps;
    }

    @Override
    public String toString() {
        return "LessonEntity{" +
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
