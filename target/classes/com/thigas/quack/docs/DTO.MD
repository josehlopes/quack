# DTOs e Entidades de Domínio

## 1. DTOs para Comunicação com a API

**Objetivo**: DTOs (Data Transfer Objects) são usados para transportar dados entre a API e o cliente (por exemplo, navegadores, aplicativos móveis).

**Quando usar**: Sempre que você receber ou enviar dados através da API. Isso inclui criar, atualizar e buscar recursos. DTOs ajudam a controlar e formatar os dados expostos pela API, garantindo que apenas as informações necessárias sejam enviadas e recebidas.

## 2. Entidades de Domínio para Lógica de Negócio

**Objetivo**: Entidades de domínio representam os modelos de dados do seu sistema e encapsulam a lógica de negócio.

**Quando usar**: Quando você está manipulando ou processando dados internamente no seu sistema, como realizar operações de negócio ou interagir com o banco de dados.

## Fluxo Geral

### Recebendo Dados:

1. **API Recebe um DTO**: Quando uma requisição é feita para criar ou atualizar um recurso, os dados são recebidos como um DTO.
2. **Converter DTO para Entidade**: O controlador converte o DTO para a entidade de domínio correspondente. Isso permite que a lógica de negócio seja aplicada utilizando o modelo de domínio.

### Processando Dados:

1. **Lógica de Negócio**: O serviço ou repositório usa a entidade de domínio para processar dados e interagir com o banco de dados. A entidade pode ter métodos que encapsulam a lógica de negócio.

### Enviando Dados:

1. **Converter Entidade para DTO**: Quando uma resposta é enviada, o controlador converte a entidade de domínio de volta para um DTO.
2. **Retornar DTO**: O DTO é então retornado ao cliente, contendo apenas as informações necessárias.

## Exemplo Prático

Vamos supor que você tenha um endpoint para criar um endereço:

### Recebendo Dados:

1. O cliente envia um POST para `/addresses` com um `AddressDTO`.

### Processando Dados:

1. O controlador converte o `AddressDTO` para um `Address` (entidade de domínio).
2. O serviço aplica a lógica de negócio e salva o `Address` no banco de dados.

### Enviando Dados:

1. O serviço retorna a entidade `Address` (ou `AddressDTO`).
2. O controlador converte a entidade de volta para um `AddressDTO`.
3. O `AddressDTO` é retornado como resposta ao cliente.

## Benefícios

- **Segurança**: Você controla quais dados são expostos ao cliente.
- **Flexibilidade**: Facilita mudanças na estrutura dos dados sem afetar a API diretamente.
- **Desempenho**: Permite otimizar a quantidade de dados enviados e recebidos, evitando o tráfego desnecessário de dados.

## Dicas Adicionais

- **Validação**: Valide os dados nos DTOs antes de convertê-los para entidades.
- **Documentação**: Mantenha a documentação da API e dos DTOs atualizada para refletir as mudanças no modelo de dados.
- **Conversão**: Utilize bibliotecas de mapeamento (como MapStruct) para facilitar a conversão entre DTOs e entidades.

Essa separação entre DTOs e entidades ajuda a manter o código organizado e facilita a manutenção do sistema.
