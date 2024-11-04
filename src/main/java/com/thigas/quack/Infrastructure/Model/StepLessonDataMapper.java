package com.thigas.quack.Infrastructure.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name = "step_lesson")
public class StepLessonDataMapper {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "step_id", nullable = false)
    @ToString.Exclude
    private StepDataMapper step;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lesson_id", nullable = false)
    @ToString.Exclude
    private LessonDataMapper lesson;
    @Column(name = "image_path")
    private String imagePath;

    public StepLessonDataMapper(Integer id, StepDataMapper step, LessonDataMapper lesson, String imagePath) {
        this.id = id;
        this.step = step;
        this.lesson = lesson;
        this.imagePath = imagePath;
    }

}

