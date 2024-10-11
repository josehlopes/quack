package com.thigas.quack.adapter.controller;

import javax.tools.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

public class CodeExecutor {

    private static final String CLASS_NAME = "UserCode";

    public static String runCode(String code) {
        File sourceFile = createSourceFile();
        if (sourceFile == null) {
            return "Erro ao criar arquivo temporário.";
        }

        if (!writeSourceCode(sourceFile, code)) {
            return "Erro ao escrever o código.";
        }

        if (!compileSourceCode(sourceFile)) {
            return "Erro ao compilar o código.";
        }

        return executeCompiledCode(sourceFile);
    }

    private static File createSourceFile() {
        String tempDir = System.getProperty("java.io.tmpdir");
        File sourceFile = new File(tempDir, CLASS_NAME + ".java");
        if (sourceFile.exists()) {
            if (!sourceFile.delete()) {
                return null;
            }
        }
        try {
            if (!sourceFile.createNewFile()) {
                return null;
            }
        } catch (IOException e) {
            return null;
        }
        return sourceFile;
    }

    private static boolean writeSourceCode(File sourceFile, String code) {
        try (FileWriter writer = new FileWriter(sourceFile)) {
            writer.write(code);
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    private static boolean compileSourceCode(File sourceFile) {
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        DiagnosticCollector<JavaFileObject> diagnostics = new DiagnosticCollector<>();
        try (StandardJavaFileManager fileManager = compiler.getStandardFileManager(diagnostics, null, null)) {
            Iterable<? extends JavaFileObject> compilationUnits = fileManager.getJavaFileObjects(sourceFile);
            JavaCompiler.CompilationTask task = compiler.getTask(null, fileManager, diagnostics, null, null,
                    compilationUnits);

            boolean success = task.call();
            if (!success) {
                StringBuilder result = new StringBuilder();
                for (Diagnostic<? extends JavaFileObject> diagnostic : diagnostics.getDiagnostics()) {
                    result.append("Erro: ").append(diagnostic.getMessage(null)).append("\n");
                }
                return false;
            }
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    private static String executeCompiledCode(File sourceFile) {
        StringBuilder result = new StringBuilder();
        try (URLClassLoader classLoader = URLClassLoader
                .newInstance(new URL[]{sourceFile.getParentFile().toURI().toURL()})) {
            Class<?> userClass = classLoader.loadClass(CLASS_NAME);
            Object instance = userClass.getDeclaredConstructor().newInstance();

            Method calculateMethod = getCalculateMethod(userClass);
            if (calculateMethod == null) {
                return "Método 'calculate(int, int)' não encontrado na classe 'UserCode'.";
            }

            result.append(runTestCases(calculateMethod, instance));
        } catch (Exception e) {
            return "Erro ao executar o código: " + e.getMessage();
        }
        return result.toString();
    }

    private static Method getCalculateMethod(Class<?> userClass) {
        try {
            return userClass.getMethod("calculate", int.class, int.class);
        } catch (NoSuchMethodException e) {
            return null;
        }
    }

    private static String runTestCases(Method method, Object instance) throws Exception {
        StringBuilder result = new StringBuilder();
        int[][] testCases = {{0, 100}, {1, 10}, {0, 0}, {1, 1}, {10, 5}, {-10, -1}};
        int[] expectedResults = {2500, 25, 0, 1, 0, -25};

        for (int i = 0; i < testCases.length; i++) {
            int[] testCase = testCases[i];
            int expectedResult = expectedResults[i];
            int resultValue = (int) method.invoke(instance, testCase[0], testCase[1]);
            result.append("Test ").append(i + 1).append(": ")
                    .append(resultValue == expectedResult ? "Passed" : "Failed").append("\n");
        }
        return result.toString();
    }
}
