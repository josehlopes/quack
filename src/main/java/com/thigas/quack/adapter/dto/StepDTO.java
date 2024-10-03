package com.thigas.quack.adapter.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import lombok.Data;

@Data
public class StepDTO {

    private int id;
    private Set<Integer> roadmaps;
    private Set<Integer> lessons;
    private Set<Integer> tasks;
    private String description;
    private String imagePath;
    private int status;

}
