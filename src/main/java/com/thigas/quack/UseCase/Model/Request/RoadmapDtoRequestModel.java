package com.thigas.quack.UseCase.Model.Request;

import com.thigas.quack.Domain.Utils.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;


public record RoadmapDtoRequestModel(Integer id, String title, String description, String imagePath, Status status, Set<Integer> stepsIds) {
}