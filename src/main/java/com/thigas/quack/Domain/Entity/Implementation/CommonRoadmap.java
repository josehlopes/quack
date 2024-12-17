package com.thigas.quack.Domain.Entity.Implementation;

import com.thigas.quack.Domain.Entity.Interface.Roadmap;
import com.thigas.quack.Domain.Entity.Interface.Step;
import com.thigas.quack.Domain.Utils.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonRoadmap implements Roadmap {
    private Integer id;
    private String title;
    private String description;
    private String imagePath;
    private Set<Step> steps;
    private String category;
    private Boolean isActive;
    private String subtitle;
    private String color;
}

