package com.thigas.quack.adapter.dto;

import lombok.Data;

import java.util.List;
import java.util.Set;

@Data
public class TaskDTO {

    private int id;
    private List<Integer> steps;
    private String description;
    private String imagePath;
}
