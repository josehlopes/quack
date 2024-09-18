package com.thigas.quack.adapter.controller;

import javax.tools.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

public class CodeExecutor {
    public static String runCode(String code) {
        String className = "UserCode";
        File sourceFile;
        try {
            // Cria o arquivo temporário diretamente no diretório temporário do sistema
            String tempDir = System.getProperty("java.io.tmpdir");
            sourceFile = new File(tempDir, className + ".java");

            if (sourceFile.exists()) {
                sourceFile.delete();
            }
            sourceFile.createNewFile();
        } catch (IOException e) {
            return "Erro ao criar arquivo temporário.";
        }

        try (FileWriter writer = new FileWriter(sourceFile)) {
            writer.write(code);
        } catch (IOException e) {
            return "Erro ao escrever o código.";
        }

        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        DiagnosticCollector<JavaFileObject> diagnostics = new DiagnosticCollector<>();
        StringBuilder result = new StringBuilder();
        try (StandardJavaFileManager fileManager = compiler.getStandardFileManager(diagnostics, null, null)) {
            Iterable<? extends JavaFileObject> compilationUnits = fileManager.getJavaFileObjects(sourceFile);
            JavaCompiler.CompilationTask task = compiler.getTask(null, fileManager, diagnostics, null, null,
                    compilationUnits);

            boolean success = task.call();

            if (!success) {
                for (Diagnostic<? extends JavaFileObject> diagnostic : diagnostics.getDiagnostics()) {
                    result.append("Erro: ").append(diagnostic.getMessage(null)).append("\n");
                }
                return result.toString();
            }
        } catch (IOException e) {
            return "Erro ao gerenciar arquivos de compilação.";
        }

        // Executa o código compilado
        try (URLClassLoader classLoader = URLClassLoader
                .newInstance(new URL[]{sourceFile.getParentFile().toURI().toURL()})) {
            Class<?> userClass = classLoader.loadClass(className);
            Object instance = userClass.getDeclaredConstructor().newInstance();

            // Verifica a existência do método
            Method calculateMethod;
            try {
                calculateMethod = userClass.getMethod("calculate", int.class, int.class);
            } catch (NoSuchMethodException e) {
                return "Método 'calculate(int, int)' não encontrado na classe 'UserCode'.";
            }

            // Executa os testes
            int[][] testCases = {
                    {0, 100}, {1, 10}, {0, 0}, {1, 1}, {10, 5}, {-10, -1}
            };
            int[] expectedResults = {2500, 25, 0, 1, 0, -25};

            for (int i = 0; i < testCases.length; i++) {
                int[] testCase = testCases[i];
                int expectedResult = expectedResults[i];
                int resultValue = (int) calculateMethod.invoke(instance, testCase[0], testCase[1]); // resultValue é
                // temporário
                result.append("Test ").append(i + 1).append(": ") // Aqui você usa result para armazenar os resultados
                        .append(resultValue == expectedResult ? "Passed" : "Failed").append("\n");
            }

            return result.toString(); // Retorna a string construída com os resultados

        } catch (Exception e) {
            return "Erro ao executar o código: " + e.getMessage();
        }
    }
}
