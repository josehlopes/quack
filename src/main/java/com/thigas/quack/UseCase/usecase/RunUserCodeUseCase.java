package com.thigas.quack.UseCase.usecase;

import com.thigas.quack.Adapter.Controller.CodeExecutor;
import org.springframework.stereotype.Service;

@Service
public class RunUserCodeUseCase {

    public String runTests(String userCode) {
        String result = CodeExecutor.runCode(userCode);

        return "Resultados dos Testes:\n" + result;
    }
}
