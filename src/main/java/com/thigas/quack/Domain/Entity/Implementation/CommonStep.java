package com.thigas.quack.Domain.Entity.Implementation;

import com.thigas.quack.Domain.Entity.Interface.Lesson;
import com.thigas.quack.Domain.Entity.Interface.Roadmap;
import com.thigas.quack.Domain.Entity.Interface.Step;
import com.thigas.quack.Domain.Entity.Interface.Task;
import com.thigas.quack.Domain.Utils.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonStep implements Step {
    private Integer id;
    private Set<Roadmap> roadmaps;
    private Set<Lesson> lessons;
    private Set<Task> tasks;
    private String description;
    private String imagePath;
    private Boolean isActive;

}
