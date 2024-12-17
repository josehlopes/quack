package com.thigas.quack.UseCase.Model.Request;

import java.util.Set;

public record RoadmapRequestModel(Integer id, String title, String description, String imagePath,
                                  Set<Integer> stepsId, String category, String subtitle, String color) {
}
