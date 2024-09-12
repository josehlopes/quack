package com.thigas.quack.domain.entity;

import java.util.Set;

public class LessonEntity {

    private int id;
    private String title;
    private String description;
    private String language;
    private String imagePath;
    private Set<RoadmapEntity> roadmaps;

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

    public Set<RoadmapEntity> getRoadmaps() {
        return roadmaps;
    }

    public void setRoadmaps(Set<RoadmapEntity> roadmaps) {
        this.roadmaps = roadmaps;
    }
}
