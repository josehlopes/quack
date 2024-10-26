package com.thigas.quack.adapter.dto;

import java.util.Set;

public class LessonDTO {

    private int id;
    private String title;
    private String description;
    private String language;
    private String imagePath;
    private boolean completed;
    private String link;
    private Set<Integer> steps;

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

    public Set<Integer> getSteps() {
        return steps;
    }

    public void setSteps(Set<Integer> steps) {
        this.steps = steps;
    }

    @Override
    public String toString() {
        return "LessonDTO{" +
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
