package com.thigas.quack.UseCase.Model.Response;

import java.util.Set;

public record TaskInfoResponseModel(Integer id, String tasktext, Set<Integer> stepsId, String imagePath) {
}
