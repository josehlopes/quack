package com.thigas.quack.infrastructure.persistence.entity;

import com.thigas.quack.adapter.mapper.TaskTextConverter;
import com.thigas.quack.adapter.model.BaseModel;
import com.thigas.quack.domain.entity.TaskText;
import jakarta.persistence.*;
import lombok.ToString;
import org.hibernate.annotations.ColumnTransformer;

import java.util.Set;


@Entity
@Table(name = "task")
public class TaskModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToMany(mappedBy = "tasks", fetch = FetchType.LAZY)
    @ToString.Exclude
    private Set<StepModel> steps;

    @Column(columnDefinition = "jsonb")
    @Convert(converter = TaskTextConverter.class)
    @ColumnTransformer(write = "?::jsonb")
    private TaskText tasktext;

    @Column(nullable = false)
    private String imagePath;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Set<StepModel> getSteps() {
        return steps;
    }

    public void setSteps(Set<StepModel> steps) {
        this.steps = steps;
    }

    public TaskText getTasktext() {
        return tasktext;
    }

    public void setTasktext(TaskText tasktext) {
        this.tasktext = tasktext;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    @Override
    public String toString() {
        return "TaskModel{" +
                "id=" + id +
                ", steps=" + steps +
                ", tasktext=" + tasktext +
                ", imagePath='" + imagePath + '\'' +
                '}';
    }
}
