package com.thigas.quack.infrastructure.persistence.entity;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "step")
public class StepModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToMany
    @JoinTable(name = "roadmap_step_mapping", joinColumns = @JoinColumn(name = "step_id"), inverseJoinColumns = @JoinColumn(name = "roadmap_id"))
    private Set<RoadmapModel> roadmaps;

    @ManyToMany
    @JoinTable(name = "step_lesson_mapping", joinColumns = @JoinColumn(name = "step_id"), inverseJoinColumns = @JoinColumn(name = "lesson_id"))
    private Set<LessonModel> lessons;

    @Column(nullable = false)
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
