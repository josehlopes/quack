package com.thigas.quack.domain.entity;

import java.util.Set;

public class Lesson {

    private Long id;
    private String title;
    private String description;
    private String language;
    private String imagePath;
    private Set<Roadmap> roadmaps;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Set<Roadmap> getRoadmaps() {
        return roadmaps;
    }

    public void setRoadmaps(Set<Roadmap> roadmaps) {
        this.roadmaps = roadmaps;
    }
}
