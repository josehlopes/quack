package com.thigas.quack.UseCase.Service;

import com.thigas.quack.UseCase.Boundary.ActivityEvaluation;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class AverageCalculationEvaluation implements ActivityEvaluation {

    @Override
    public String evaluate(String code) {
        try {
            // Verifica se as variáveis nota1, nota2 e nota3 são definidas
            Pattern nota1Pattern = Pattern.compile("nota1\\s*=\\s*\\d+(\\.\\d+)?");
            Pattern nota2Pattern = Pattern.compile("nota2\\s*=\\s*\\d+(\\.\\d+)?");
            Pattern nota3Pattern = Pattern.compile("nota3\\s*=\\s*\\d+(\\.\\d+)?");

            // Verifica se a média está sendo calculada corretamente
            Pattern mediaPattern = Pattern.compile("media\\s*=\\s*\\(\\s*nota1\\s*\\+\\s*nota2\\s*\\+\\s*nota3\\s*\\)\\s*/\\s*3");

            Matcher nota1Matcher = nota1Pattern.matcher(code);
            Matcher nota2Matcher = nota2Pattern.matcher(code);
            Matcher nota3Matcher = nota3Pattern.matcher(code);
            Matcher mediaMatcher = mediaPattern.matcher(code);

            if (nota1Matcher.find() && nota2Matcher.find() && nota3Matcher.find() && mediaMatcher.find()) {
                // Extrai os valores das notas
                double nota1 = Double.parseDouble(nota1Matcher.group().split("=")[1].trim());
                double nota2 = Double.parseDouble(nota2Matcher.group().split("=")[1].trim());
                double nota3 = Double.parseDouble(nota3Matcher.group().split("=")[1].trim());

                // Calcula a média
                double media = (nota1 + nota2 + nota3) / 3;

                // Retorna a mensagem com o valor da média
                return "Parabéns! O código está correto e a média é " + media + ".";
            } else {
                return "O código está incompleto ou incorreto. Certifique-se de definir as notas corretamente e calcular a média como (nota1 + nota2 + nota3) / 3.";
            }
        } catch (Exception e) {
            return "Houve um erro ao avaliar o código. Por favor, verifique o código enviado.";
        }
    }
}
