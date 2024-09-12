package com.thigas.quack.domain.entity;

import com.thigas.quack.infrastructure.persistence.entity.StepModel;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Setter
@Getter
public class StepEntity {
    private int id;
    private Set<StepModel> step;
    private String description;

}
