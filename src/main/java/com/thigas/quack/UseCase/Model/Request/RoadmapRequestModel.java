package com.thigas.quack.UseCase.Model.Request;

import com.thigas.quack.Domain.Utils.Status;

import java.util.Set;


public record RoadmapRequestModel(Integer id, String title, String description, String imagePath,
                                  Set<Integer> stepsId) {
}