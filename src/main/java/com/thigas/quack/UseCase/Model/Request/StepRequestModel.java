package com.thigas.quack.UseCase.Model.Request;

import com.thigas.quack.Domain.Utils.Status;

import java.util.Set;


public record StepRequestModel(Integer id, Set<Integer> roadmapsId, Set<Integer> lessonsId, Set<Integer> tasksId,
                               String description, String imagePath, Status status) {
}
