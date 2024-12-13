package com.thigas.quack.UseCase.Service;

import org.springframework.stereotype.Service;

@Service
public class CodeEvaluationService {

    public String evaluateCode(String code) {
        try {
            if (code.contains("5") && code.contains("3") && code.contains("area")) {
                return "Parabéns! O código está correto e a área será calculada corretamente.";
            } else {
                return "O código está incompleto ou incorreto. Certifique-se de calcular a área com 5 e 3.";
            }
        } catch (Exception e) {
            return "Erro ao avaliar o código: " + e.getMessage();
        }
    }
}