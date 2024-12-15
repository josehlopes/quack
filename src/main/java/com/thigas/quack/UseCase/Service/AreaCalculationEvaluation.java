package com.thigas.quack.UseCase.Service;

import com.thigas.quack.UseCase.Boundary.ActivityEvaluation;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class AreaCalculationEvaluation implements ActivityEvaluation {

    @Override
    public String evaluate(String code) {
        try {
            // Verifica se as variáveis comprimento e largura estão atribuídas corretamente
            Pattern comprimentoPattern = Pattern.compile("comprimento\\s*=\\s*5");
            Pattern larguraPattern = Pattern.compile("largura\\s*=\\s*3");
            Pattern areaPattern = Pattern.compile("area\\s*=\\s*comprimento\\s*\\*\\s*largura");

            Matcher comprimentoMatcher = comprimentoPattern.matcher(code);
            Matcher larguraMatcher = larguraPattern.matcher(code);
            Matcher areaMatcher = areaPattern.matcher(code);

            if (comprimentoMatcher.find() && larguraMatcher.find() && areaMatcher.find()) {
                return "Parabéns! O código está correto e a área será calculada corretamente.";
            } else {
                return "O código está incorreto. Certifique-se de que as variáveis comprimento e largura estão atribuídas corretamente e que a área é calculada como comprimento * largura.";
            }
        } catch (Exception e) {
            return "Houve um erro ao avaliar o código. Por favor, verifique o código enviado.";
        }
    }
}
