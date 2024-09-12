package com.thigas.quack.adapter.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class StepDTO {
    private int id;
    private Set<Integer> stepIds;
    private String description;

}
