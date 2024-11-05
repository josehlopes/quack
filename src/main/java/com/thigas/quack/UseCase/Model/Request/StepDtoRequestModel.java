package com.thigas.quack.UseCase.Model.Request;

import com.thigas.quack.Domain.Utils.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;


public record StepDtoRequestModel(Integer id, Set<Integer> roadmapsIds, Set<Integer> lessonsIds, Set<Integer> tasksIds, String description, String imagePath, Integer status) {
}
