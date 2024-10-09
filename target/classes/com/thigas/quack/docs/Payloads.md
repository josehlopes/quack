Aqui está o markdown para o padrão de payload para a criação de um novo usuário, baseado na classe `UserDTO` que você forneceu:

```markdown
# Payload para Criação de Novo Usuário

### Classe `UserDTO`

```java
public class UserDTO {

    private int id;
    private String name;
    private String username;
    private String phone;
    private String email;
    private String password;
    private String cpf;
    private String bornAt;
    private Double points;
    private String registerAt;
    private String imagePath;
    private int status;
}
```

### Exemplo de Payload em JSON

```json
{
  "name": "João Silva",
  "username": "joao2",
  "email": "joao2@gmail.com",
  "password": "senha12345",
  "cpf": "12345678901",
  "phone": "991114020",
  "bornAt": "1990-01-01",
  "points": 0,
  "registerAt": "2024-10-02T10:00:00Z",
  "imagePath": "/images/user/joao2.jpg",
  "status": 1
}
```

### Descrição dos Campos

- **name** (`String`): Nome completo do usuário.
- **username** (`String`): Nome de usuário único.
- **email** (`String`): E-mail do usuário.
- **password** (`String`): Senha do usuário (criptografar antes de armazenar).
- **cpf** (`String`): CPF do usuário (formato: `"12345678901"`).
- **phone** (`String`): Número de telefone do usuário.
- **bornAt** (`String`): Data de nascimento no formato `"YYYY-MM-DD"`.
- **points** (`Double`): Pontos acumulados pelo usuário (começa com `0`).
- **registerAt** (`String`): Data e hora de registro no formato ISO 8601 (`"YYYY-MM-DDTHH:MM:SSZ"`).
- **imagePath** (`String`): Caminho da imagem de perfil do usuário.
- **status** (`int`): Status do usuário (ex: `1` para ativo, `0` para inativo).

### Observações

- O campo `id` não deve ser enviado no payload de criação, pois ele será gerado automaticamente pelo sistema.
- Certifique-se de que a senha seja armazenada de forma segura (preferencialmente, criptografada).
- O formato ISO 8601 é utilizado para a data de registro (`registerAt`) para garantir a compatibilidade com fuso horário.
```

Claro! Vamos continuar o markdown com o padrão de payload para a criação de um novo **UserRoadmapDTO**. 

```markdown
# Payload para Criação de UserRoadmap

### Classe `UserRoadmapDTO`

```java
package com.thigas.quack.adapter.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class UserRoadmapDTO {

    private int id;
    private int user;
    private int roadmap;
    private Double progress;
    private String startedAt;
    private String finishedAt;
    private int status;
}
```

### Exemplo de Payload em JSON

```json
{
  "user": 28,
  "roadmap": 1,
  "progress": 75.5,
  "startedAt": "2024-10-01",
  "status": 1
}
```

### Descrição dos Campos

- **id** (`int`): ID do UserRoadmap. Esse campo é geralmente gerado automaticamente no backend e não deve ser enviado no payload de criação.
- **user** (`int`): ID do usuário associado a este roadmap.
- **roadmap** (`int`): ID do roadmap que o usuário está seguindo.
- **progress** (`Double`): Progresso do usuário no roadmap, representado em percentual (ex: `75.5` significa 75,5% completo).
- **startedAt** (`String`): Data de início do roadmap no formato `"YYYY-MM-DD"`.
- **finishedAt** (`String`): Data de finalização do roadmap no formato `"YYYY-MM-DD"`. Se o roadmap ainda não estiver concluído, este campo pode ser omitido ou preenchido com `null`.
- **status** (`int`): Status do roadmap, por exemplo, `1` para ativo, `0` para inativo ou pausado.

### Observações

- O campo `finishedAt` pode ser omitido caso o roadmap ainda não tenha sido concluído.
- O progresso deve ser um número de ponto flutuante entre 0 e 100, indicando o percentual de conclusão.
- O formato de data utilizado para `startedAt` e `finishedAt` deve seguir o padrão `"YYYY-MM-DD"` para garantir consistência.
```

Esses markdown inclui a definição da classe, o exemplo de payload em JSON e uma explicação clara de cada campo. Ele pode ser útil para documentar e padronizar a criação de usuários na sua aplicação.