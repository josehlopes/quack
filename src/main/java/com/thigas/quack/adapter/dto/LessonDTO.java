package com.thigas.quack.adapter.dto;

import java.util.Set;

public class LessonDTO {

    private int id;
    private String title;
    private String description;
    private String language;
    private String imagePath;
    private Set<Integer> roadmapIds;

    // Getters e Setters

    /**
     * @return int return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
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
     * @return Set<Integer> return the roadmapIds
     */
    public Set<Integer> getRoadmapIds() {
        return roadmapIds;
    }

    /**
     * @param roadmapIds the roadmapIds to set
     */
    public void setRoadmapIds(Set<Integer> roadmapIds) {
        this.roadmapIds = roadmapIds;
    }
}
