package com.thigas.quack.UseCase.usecase;

import org.springframework.stereotype.Service;

import com.thigas.quack.Adapter.Controller.CodeExecutor;

@Service
public class RunUserCodeUseCase {

    public String runTests(String userCode) {
        String result = CodeExecutor.runCode(userCode);

        StringBuilder resultBuilder = new StringBuilder("Resultados dos Testes:\n");
        resultBuilder.append(result);
        return resultBuilder.toString();
    }
}
