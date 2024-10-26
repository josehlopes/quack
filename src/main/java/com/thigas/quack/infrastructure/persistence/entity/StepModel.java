package com.thigas.quack.infrastructure.persistence.entity;

import com.thigas.quack.domain.model.Status;
import jakarta.persistence.*;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "step")
public class StepModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinTable(name = "roadmap_steps", joinColumns = @JoinColumn(name = "step_id"),
            inverseJoinColumns = @JoinColumn(name = "roadmap_id"))
    @ToString.Exclude
    private Set<RoadmapModel> roadmaps = new HashSet<>();

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinTable(name = "step_tasks", joinColumns = @JoinColumn(name = "step_id"), inverseJoinColumns = @JoinColumn(name = "task_id"))
    @ToString.Exclude
    private Set<TaskModel> tasks = new HashSet<>();

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinTable(name = "step_lesson", joinColumns = @JoinColumn(name = "step_id"), inverseJoinColumns = @JoinColumn(name = "lesson_id"))
    private Set<LessonModel> lessons = new HashSet<>();

    @Column(nullable = false)
    private String description;

    @Column(name = "image_path")
    private String imagePath;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "status", nullable = false)
    private Status status = Status.ACTIVE;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Set<RoadmapModel> getRoadmaps() {
        return roadmaps;
    }

    public void setRoadmaps(Set<RoadmapModel> roadmaps) {
        this.roadmaps = roadmaps;
    }

    public Set<TaskModel> getTasks() {
        return tasks;
    }

    public void setTasks(Set<TaskModel> tasks) {
        this.tasks = tasks;
    }

    public Set<LessonModel> getLessons() {
        return lessons;
    }

    public void setLessons(Set<LessonModel> lessons) {
        this.lessons = lessons;
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

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "StepModel{" +
                "id=" + id +
                ", roadmaps=" + roadmaps +
                ", tasks=" + tasks +
                ", lessons=" + lessons +
                ", description='" + description + '\'' +
                ", imagePath='" + imagePath + '\'' +
                ", status=" + status +
                '}';
    }
}
