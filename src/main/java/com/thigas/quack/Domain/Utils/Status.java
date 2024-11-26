package com.thigas.quack.Domain.Utils;

import lombok.Getter;

/**
 * Enum que representa os diferentes status possíveis para a relação entre o usuário e um elemento, como roadmaps ou conquistas.
 *
 * <p>Esse enum define os seguintes status:</p>
 * <ul>
 *   <li><strong>INACTIVE</strong> (0): O elemento está inativo ou não foi iniciado pelo usuário.</li>
 *   <li><strong>ACTIVE</strong> (1): O elemento está ativo, indicando que o usuário iniciou ou está interagindo com ele.</li>
 *   <li><strong>FINISHED</strong> (2): O elemento foi concluído pelo usuário, como um roadmap finalizado ou uma tarefa concluída.</li>
 *   <li><strong>CANCELED</strong> (3): O elemento foi cancelado, não será mais considerado na interação do usuário.</li>
 *   <li><strong>SKIPPED</strong> (4): O elemento foi ignorado ou pulado pelo usuário.</li>
 *   <li><strong>UNLOCKED</strong> (5): O elemento foi destravado pelo usuário, como uma conquista ou uma nova área no sistema.</li>
 * </ul>
 *
 * <p>Exemplo de uso:</p>
 * <pre>
 *   - O status de um roadmap iniciado por um usuário seria {@code Status.ACTIVE}.
 *   - O status de uma conquista destravada seria {@code Status.UNLOCKED}.
 * </pre>
 *
 * @see #INACTIVE
 * @see #ACTIVE
 * @see #FINISHED
 * @see #CANCELED
 * @see #SKIPPED
 * @see #UNLOCKED
 */
@Getter
public enum Status {
    INACTIVE(0), ACTIVE(1), FINISHED(2), CANCELED(3), SKIPPED(4), UNLOCKED(5);

    private final int value;

    /**
     * Construtor para inicializar o valor do status.
     *
     * @param value O valor inteiro associado ao status.
     */
    Status(int value) {
        this.value = value;
    }

    /**
     * Retorna o {@link Status} correspondente ao valor inteiro fornecido.
     *
     * @param value O valor inteiro do status.
     * @return O {@link Status} correspondente ao valor fornecido.
     * @throws IllegalArgumentException Se o valor não corresponder a nenhum status.
     */
    public static Status fromValue(int value) {
        for (Status status : Status.values()) {
            if (status.getValue() == value) {
                return status;
            }
        }
        throw new IllegalArgumentException("Valor inválido para Status: " + value);
    }
}
