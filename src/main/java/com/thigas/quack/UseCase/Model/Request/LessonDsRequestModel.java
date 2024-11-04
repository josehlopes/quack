package com.thigas.quack.UseCase.Model.Request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LessonDsRequestModel {

    private int id;
    private String title;
    private String description;
    private String language;
    private String imagePath;
    private boolean completed;
    private String link;
    private Set<StepDsRequestModel> steps;

}
