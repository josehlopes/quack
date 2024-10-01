# CrudRepository Interface

A interface `CrudRepository<T, ID>` define um conjunto de operações CRUD (Create, Read, Update, Delete) genéricas para manipulação de entidades em um repositório de dados. Ela estende a interface base `Repository<T, ID>`.

## Tipos genéricos:

- `T`: O tipo da entidade que será gerenciada pelo repositório.
- `ID`: O tipo do identificador único da entidade.

Abaixo está a descrição de cada método:

---

### 1. `<S extends T> S save(S entity)`

Este método salva (ou atualiza) uma entidade no banco de dados.

- **Parâmetro**: Uma entidade do tipo `S` que estende `T` (a entidade principal).
- **Retorno**: A entidade salva ou atualizada.

### 2. `<S extends T> Iterable<S> saveAll(Iterable<S> entities)`

Este método salva ou atualiza várias entidades em uma única operação.

- **Parâmetro**: Um `Iterable` contendo as entidades a serem salvas.
- **Retorno**: Um `Iterable` contendo as entidades salvas.

---

### 3. `Optional<T> findById(ID id)`

Recupera uma entidade pelo seu identificador (`ID`). O resultado é envolto em um `Optional` para evitar `null`.

- **Parâmetro**: O identificador único da entidade (`ID`).
- **Retorno**: Um `Optional<T>` contendo a entidade, se encontrada, ou vazio, caso contrário.

### 4. `boolean existsById(ID id)`

Verifica se uma entidade com o identificador fornecido existe.

- **Parâmetro**: O identificador único da entidade (`ID`).
- **Retorno**: `true` se a entidade existir, `false` caso contrário.

---

### 5. `Iterable<T> findAll()`

Recupera todas as entidades do repositório.

- **Parâmetro**: Nenhum.
- **Retorno**: Um `Iterable<T>` contendo todas as entidades.

### 6. `Iterable<T> findAllById(Iterable<ID> ids)`

Recupera todas as entidades cujos identificadores estão na lista fornecida.

- **Parâmetro**: Um `Iterable` contendo os identificadores das entidades.
- **Retorno**: Um `Iterable<T>` contendo as entidades correspondentes.

---

### 7. `long count()`

Conta o número total de entidades no repositório.

- **Parâmetro**: Nenhum.
- **Retorno**: O número total de entidades (long).

---

### 8. `void deleteById(ID id)`

Remove uma entidade pelo seu identificador.

- **Parâmetro**: O identificador único da entidade (`ID`).
- **Retorno**: Nenhum (void).

### 9. `void delete(T entity)`

Remove uma entidade específica.

- **Parâmetro**: A entidade a ser removida.
- **Retorno**: Nenhum (void).

### 10. `void deleteAllById(Iterable<? extends ID> ids)`

Remove múltiplas entidades cujos identificadores estão na lista fornecida.

- **Parâmetro**: Um `Iterable` de identificadores (`ID`).
- **Retorno**: Nenhum (void).

### 11. `void deleteAll(Iterable<? extends T> entities)`

Remove várias entidades de uma vez.

- **Parâmetro**: Um `Iterable` contendo as entidades a serem removidas.
- **Retorno**: Nenhum (void).

### 12. `void deleteAll()`

Remove todas as entidades no repositório.

- **Parâmetro**: Nenhum.
- **Retorno**: Nenhum (void).

---

# Anotação: `@NoRepositoryBean`

A anotação `@NoRepositoryBean` indica que essa interface não será diretamente considerada como um bean repositório pelo Spring. Isso significa que ela serve como uma interface de base, que deve ser estendida por outras interfaces repositório, mas não deve ser instanciada diretamente.
