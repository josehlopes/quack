package com.thigas.quack.domain.entity;

import com.fasterxml.jackson.databind.JsonNode;
import com.thigas.quack.adapter.model.BaseEntity;
import com.thigas.quack.infrastructure.persistence.entity.TaskText;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TaskEntity implements BaseEntity {

    private int id;
    private TaskText tasktext;
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