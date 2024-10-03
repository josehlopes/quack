package com.thigas.quack.application.usecase;

import com.thigas.quack.adapter.controller.CodeExecutor;
import org.springframework.stereotype.Service;

@Service
public class RunUserCodeUseCase {

    public String runTests(String userCode) {
        String result = CodeExecutor.runCode(userCode);

        return "Resultados dos Testes:\n" + result;
    }
}
