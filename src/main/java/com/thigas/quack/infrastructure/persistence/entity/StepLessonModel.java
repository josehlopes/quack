package com.thigas.quack.infrastructure.persistence.entity;

import jakarta.persistence.*;
import lombok.ToString;


@Entity
@Table(name = "step_lesson")
public class StepLessonModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "step_id", nullable = false)
    @ToString.Exclude
    private StepModel step;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lesson_id", nullable = false)
    @ToString.Exclude
    private LessonModel lesson;

    @Column(name = "image_path")
    private String imagePath;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public StepModel getStep() {
        return step;
    }

    public void setStep(StepModel step) {
        this.step = step;
    }

    public LessonModel getLesson() {
        return lesson;
    }

    public void setLesson(LessonModel lesson) {
        this.lesson = lesson;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    @Override
    public String toString() {
        return "StepLessonModel{" +
                "id=" + id +
                ", step=" + step +
                ", lesson=" + lesson +
                ", imagePath='" + imagePath + '\'' +
                '}';
    }
}

