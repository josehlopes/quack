package com.thigas.quack.UseCase.Service;

import com.thigas.quack.UseCase.Boundary.ActivityEvaluation;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

@Service
public class EvenOddEvaluation implements ActivityEvaluation {

    @Override
    public String evaluate(String code) {
        try {
            // Cria o processo para executar o código Python
            ProcessBuilder processBuilder = new ProcessBuilder("python", "-c", code);
            processBuilder.redirectErrorStream(true); // Juntar erros com a saída normal
            Process process = processBuilder.start();

            // Captura a saída do processo
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream(), StandardCharsets.UTF_8));
            StringBuilder output = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                output.append(line).append("\n");
            }

            // Aguarda a execução do processo
            int exitCode = process.waitFor();

            // Verifica erro de sintaxe
            if (output.toString().contains("SyntaxError")) {
                // Retorna a mensagem de erro detalhada
                return "Erro de sintaxe no código Python. Verifique a estrutura do código. Verifique se todos os parênteses estão fechados corretamente.\n" +
                        "Detalhes do erro: " + output.toString().trim();
            }

            // Valida a saída exata e retorna a mensagem correta
            String result = output.toString().trim();
            if (result.equals("O numero eh par") || result.equals("O numero eh impar")) {
                return result.replace("eh", "é"); // Ajusta o texto para o formato desejado
            } else {
                return "O código executou, mas a saída está incorreta. Certifique-se de imprimir 'O número é par.' ou 'O número é ímpar.' corretamente.";
            }

        } catch (Exception e) {
            // Lida com erros de execução no código Python
            return "O código não pôde ser executado. Verifique se a sintaxe está correta.";
        }
    }
}
