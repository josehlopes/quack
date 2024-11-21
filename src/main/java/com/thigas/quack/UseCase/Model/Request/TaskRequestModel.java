package com.thigas.quack.UseCase.Model.Request;

import java.util.Set;

//TODO: Verificar se como o tasktext é uma classe que trabalha apenas com strings, se não é melhor apenas passar ele diretamente aqui
public record TaskRequestModel(Integer id, String tasktext, Set<Integer> stepsIds, String imagePath) {
}