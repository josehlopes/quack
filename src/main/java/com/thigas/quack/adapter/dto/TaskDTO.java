package com.thigas.quack.adapter.dto;

import java.util.Set;
import com.thigas.quack.infrastructure.persistence.entity.LessonModel;

public class TaskDTO {

    private int id;
    private Set<Integer> lessonIds;
    private String description;
    private String imagePath;

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
     * @return Set<Integer> return the lessonIds
     */
    public Set<Integer> getLessonIds() {
        return lessonIds;
    }

    /**
     * @param lessonIds the lessonIds to set
     */
    public void setLessonIds(Set<Integer> lessonIds) {
        this.lessonIds = lessonIds;
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
