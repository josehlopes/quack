package com.thigas.quack.domain.entity;

import com.thigas.quack.adapter.model.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LessonEntity implements BaseEntity {

    private int id;
    private String title;
    private String description;
    private String language;
    private String imagePath;
    private Set<StepEntity> steps;

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }


}
