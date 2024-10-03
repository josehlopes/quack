package com.thigas.quack.adapter.dto;

import com.fasterxml.jackson.databind.JsonNode;
import com.thigas.quack.infrastructure.persistence.entity.TaskText;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Data
public class TaskDTO {

    private int id;
    private Set<Integer> steps;
    private TaskText tasktext;
    private String imagePath;
}
