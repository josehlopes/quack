package com.thigas.quack.adapter.dto;

import java.util.Set;

public class LessonDTO {

    private Long id;
    private String title;
    private String description;
    private String language;
    private String imagePath;
    private Set<Long> roadmapIds; // IDs das roadmaps associadas à lesson

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
     * @return String return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
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

    /**
     * @return String return the language
     */
    public String getLanguage() {
        return language;
    }

    /**
     * @param language the language to set
     */
    public void setLanguage(String language) {
        this.language = language;
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

    /**
     * @return Set<Long> return the roadmapIds
     */
    public Set<Long> getRoadmapIds() {
        return roadmapIds;
    }

    /**
     * @param roadmapIds the roadmapIds to set
     */
    public void setRoadmapIds(Set<Long> roadmapIds) {
        this.roadmapIds = roadmapIds;
    }
}
