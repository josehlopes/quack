package com.thigas.quack.UseCase.Model.Request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;
//TODO: Verificar se como o tasktext é uma classe que trabalha apenas com strings, se não é melhor apenas passar ele diretamente aqui
public record TaskDtoRequestModel(Integer id, String tasktext, Set<Integer> stepsIds, String imagePath) {
}