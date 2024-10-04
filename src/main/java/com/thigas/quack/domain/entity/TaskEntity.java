package com.thigas.quack.domain.entity;

import com.thigas.quack.adapter.model.BaseEntity;
import com.thigas.quack.infrastructure.persistence.entity.TaskText;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TaskEntity implements BaseEntity {

    private int id;
    private String description;
    private TaskText tasktext;
    private Set<StepEntity> steps;

    @Override
    public int getId() {
        return this.id; // Retorna o ID
    }

    @Override
    public void setId(int id) {
        this.id = id; // Define o ID
    }



}