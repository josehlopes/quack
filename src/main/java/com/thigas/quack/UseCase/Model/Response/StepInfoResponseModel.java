package com.thigas.quack.UseCase.Model.Response;

import com.thigas.quack.Domain.Utils.Status;

import java.util.Set;

public record StepInfoResponseModel(Integer id, Set<Integer> roadmapsIds, Set<Integer> lessonsIds, Set<Integer> tasksIds,
                                    String description, String imagePath, Status status, String title) {
}
