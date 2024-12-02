package com.thigas.quack.Domain.Entity.Implementation;

import com.thigas.quack.Domain.Entity.Interface.Step;
import com.thigas.quack.Domain.Entity.Interface.Task;
import com.thigas.quack.Domain.Entity.Interface.TaskText;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonTask implements Task {

    private Integer id;
    private TaskText taskText;
    private Set<Step> steps;
    private String imagePath;
}
