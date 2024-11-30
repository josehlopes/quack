package com.thigas.quack.UseCase.Model.Response;

import com.thigas.quack.Domain.Utils.Status;

import java.util.Set;

public record RoadmapInfoResponseModel(Integer id, String title, String description, String imagePath,
                                       Set<Integer> stepsId) {
}
