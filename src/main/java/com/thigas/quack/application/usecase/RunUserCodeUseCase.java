package com.thigas.quack.application.usecase;

import org.springframework.stereotype.Service;

import com.thigas.quack.adapter.controller.CodeExecutor;

@Service
public class RunUserCodeUseCase {

    public String runTests(String userCode) {
        String result = CodeExecutor.runCode(userCode);

        StringBuilder resultBuilder = new StringBuilder("Resultados dos Testes:\n");
        resultBuilder.append(result);
        return resultBuilder.toString();
    }
}
