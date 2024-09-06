package com.thigas.quack.adapter.persistence.entity;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "lesson")
public class LessonModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "varchar(255)", nullable = false)
    private String title;

    @Column(columnDefinition = "varchar(255)", nullable = false)
    private String description;

    @Column(columnDefinition = "varchar(255)", nullable = true)
    private String language;

    @Column(name = "image_path", columnDefinition = "varchar(255)", nullable = true)
    private String imagePath;

    @ManyToMany
    @JoinTable(name = "lesson_roadmap", joinColumns = @JoinColumn(name = "lesson_id"), inverseJoinColumns = @JoinColumn(name = "roadmap_id"))
    private Set<RoadmapModel> roadmaps;

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

}
