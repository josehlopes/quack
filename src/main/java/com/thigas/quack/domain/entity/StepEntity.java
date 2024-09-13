package com.thigas.quack.domain.entity;

import com.thigas.quack.infrastructure.persistence.entity.RoadmapModel;

import com.thigas.quack.infrastructure.persistence.entity.LessonModel;
import java.util.Set;

public class StepEntity {

    private int id;

    private Set<RoadmapModel> roadmaps;

    private Set<LessonModel> lessons;

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
     * @return Set<RoadmapModel> return the roadmaps
     */
    public Set<RoadmapModel> getRoadmaps() {
        return roadmaps;
    }

    /**
     * @param roadmaps the roadmaps to set
     */
    public void setRoadmaps(Set<RoadmapModel> roadmaps) {
        this.roadmaps = roadmaps;
    }

    /**
     * @return Set<LessonModel> return the lessons
     */
    public Set<LessonModel> getLessons() {
        return lessons;
    }

    /**
     * @param lessons the lessons to set
     */
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
