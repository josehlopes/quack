package com.thigas.quack.UseCase.Model.Request;

import java.util.Set;


public record StepRequestModel(Integer id, Set<Integer> roadmapsIds, Set<Integer> lessonsIds, Set<Integer> tasksIds,
                               String description, String imagePath, Integer status) {
}
