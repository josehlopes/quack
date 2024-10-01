package com.thigas.quack.domain.entity;

import java.util.List;
import java.util.Set;

import com.thigas.quack.adapter.model.BaseEntity;
import com.thigas.quack.domain.model.Status;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoadmapEntity implements BaseEntity{

    private int id;
    private String title;
    private String description;
    private String imagePath;
    private Status status;
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