package com.thigas.quack.UseCase.Model.Response;

import java.util.Objects;

/**
 * Modelo de resposta genérico que encapsula uma mensagem de texto.
 *
 * <p>Esta classe é usada para representar respostas genéricas que contêm apenas uma mensagem de texto.
 * A mensagem de texto não pode ser nula nem vazia.</p>
 *
 * <p>Exemplo de uso:</p>
 * <pre>
 * {@code
 * GenericResponseModel response = new GenericResponseModel("Operação bem-sucedida");
 * System.out.println(response.text()); // Saída: Operação bem-sucedida
 * }
 * </pre>
 *
 * @param text A mensagem de texto da resposta. Não pode ser nula nem vazia.
 * @throws NullPointerException se o texto for nulo.
 * @throws IllegalArgumentException se o texto for vazio.
 */
public record GenericResponseModel(String text) {

    /**
     * Construtor para o modelo de resposta genérico.
     *
     * @param text A mensagem de texto da resposta. Não pode ser nula nem vazia.
     * @throws NullPointerException se o texto for nulo.
     * @throws IllegalArgumentException se o texto for vazio.
     */
    public GenericResponseModel {
        Objects.requireNonNull(text, "Text cannot be null");
        if (text.isBlank()) {
            throw new IllegalArgumentException("Text cannot be blank");
        }
    }
}