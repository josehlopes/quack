package com.thigas.quack.domain.entity;

import java.util.Set;

public class StepEntity {

    private int id;

    private Set<RoadmapEntity> roadmaps;

    private Set<LessonEntity> lessons;

    private String description;

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
     * @return Set<RoadmapEntity> return the roadmaps
     */
    public Set<RoadmapEntity> getRoadmaps() {
        return roadmaps;
    }

    /**
     * @param roadmaps the roadmaps to set
     */
    public void setRoadmaps(Set<RoadmapEntity> roadmaps) {
        this.roadmaps = roadmaps;
    }

    /**
     * @return Set<LessonEntity> return the lessons
     */
    public Set<LessonEntity> getLessons() {
        return lessons;
    }

    /**
     * @param lessons the lessons to set
     */
    public void setLessons(Set<LessonEntity> lessons) {
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
