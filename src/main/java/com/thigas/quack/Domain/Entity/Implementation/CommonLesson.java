package com.thigas.quack.Domain.Entity.Implementation;

import com.thigas.quack.Domain.Entity.Interface.Lesson;
import com.thigas.quack.Domain.Entity.Interface.Step;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonLesson implements Lesson {

    private Integer id;
    private String title;
    private String description;
    private String language;
    private String imagePath;
    private Boolean completed;
    private String link;
    private Set<Step> steps;
}
