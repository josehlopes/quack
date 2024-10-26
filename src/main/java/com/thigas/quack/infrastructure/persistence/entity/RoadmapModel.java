package com.thigas.quack.infrastructure.persistence.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.thigas.quack.domain.model.Status;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "roadmap")
public class RoadmapModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String description;

    @Column(name = "image_path", nullable = false)
    private String imagePath;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinTable(name = "roadmap_steps", joinColumns =
            {@JoinColumn(name = "step_id")}, inverseJoinColumns =
            {@JoinColumn(name = "roadmap_id")})
    @JsonManagedReference
    private Set<StepModel> steps;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "status", nullable = false)
    private Status status = Status.ACTIVE;

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

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public Set<StepModel> getSteps() {
        return steps;
    }

    public void setSteps(Set<StepModel> steps) {
        this.steps = steps;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "RoadmapModel{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", imagePath='" + imagePath + '\'' +
                ", steps=" + steps +
                ", status=" + status +
                '}';
    }
}