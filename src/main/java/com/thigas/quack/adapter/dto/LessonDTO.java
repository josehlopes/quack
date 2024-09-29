package com.thigas.quack.adapter.dto;

import java.util.List;
import java.util.Set;

import jdk.dynalink.linker.LinkerServices;
import lombok.Data;

@Data
public class LessonDTO {

    private int id;
    private String title;
    private String description;
    private String language;
    private String imagePath;
    private List<Integer> steps;

}
