package com.thigas.quack.UseCase.Util;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Classe genérica para encapsular a resposta de uma operação.
 *
 * <p>Esta classe pode ser usada para retornar dados de sucesso ou erro, juntamente com
 * o código de status HTTP e uma mensagem de erro (se aplicável).</p>
 *
 * <p>Exemplo de uso:</p>
 * <pre>
 * {@code
 * ResponseWrapper<String> sucesso = new ResponseWrapper<>("Operação bem-sucedida", 200);
 * ResponseWrapper<String> erro = new ResponseWrapper<>("Erro na operação", 400);
 * }
 * </pre>
 *
 * @param <T> Tipo do objeto de dados da resposta.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseWrapper<T> {

    private T data;             // Dados de sucesso (se houver)
    private String errorMessage; // Mensagem de erro (se houver)
    private int statusCode;      // Código de status HTTP

    /**
     * Construtor para uma resposta de sucesso.
     *
     * @param data Dados retornados com sucesso.
     * @param statusCode Código de status HTTP (normalmente 200 para sucesso).
     */
    public ResponseWrapper(T data, int statusCode) {
        this.data = data;
        this.statusCode = statusCode;
        this.errorMessage = null;  // Nenhuma mensagem de erro para sucesso
    }

    /**
     * Construtor para uma resposta de erro.
     *
     * @param errorMessage Mensagem de erro detalhando o motivo da falha.
     * @param statusCode Código de status HTTP (por exemplo, 400 para erro de solicitação).
     */
    public ResponseWrapper(String errorMessage, int statusCode) {
        this.errorMessage = errorMessage;
        this.statusCode = statusCode;
        this.data = null;  // Nenhum dado para erro
    }

    /**
     * Verifica se a resposta é de sucesso (se não houver mensagem de erro).
     *
     * @return Verdadeiro se for sucesso, falso se for erro.
     */
    public boolean isSuccess() {
        return this.errorMessage == null;
    }
}