# Estrutura de Pastas do Projeto

Este projeto foi desenvolvido seguindo os princípios do Clean Architecture, que promove a separação de preocupações e a modularidade do código, facilitando a testabilidade e a manutenção. Abaixo está a estrutura de pastas utilizada no projeto:

```bash
src
└── main
    ├── java
    │   └── com
    │       └── seuapp
    │           ├── application
    │           │   ├── service
    │           │   └── usecase
    │           ├── domain
    │           │   ├── model
    │           │   ├── repository
    │           │   └── service
    │           ├── infrastructure
    │           │   ├── persistence
    │           │   ├── configuration
    │           │   └── messaging
    │           ├── presentation
    │           │   ├── controller
    │           │   ├── dto
    │           │   └── mapper
    │           └── config
    └── resources
        └── application.properties

Descrição das Pastas
application: Contém a lógica de orquestração da aplicação, incluindo os serviços e os casos de uso. Esta camada é responsável por coordenar as interações entre a interface (UI) e o domínio.

service: Serviços que implementam a lógica de aplicação.
usecase: Casos de uso específicos que encapsulam regras de negócios.
domain: O núcleo da aplicação, onde reside a lógica de negócios pura. Esta camada é independente das demais, o que significa que as regras de negócios não dependem de infraestrutura externa.

model: Entidades do domínio e objetos de valor (Value Objects).
repository: Interfaces para repositórios, abstraindo a forma de acesso ao armazenamento de dados.
service: Serviços de domínio que contêm regras de negócios diretamente ligadas às entidades.
infrastructure: Implementações de infraestrutura, como persistência de dados, configurações de segurança e mensagens. Tudo o que depende de frameworks ou de tecnologias externas.

persistence: Implementação das interfaces de repositório, conectando a aplicação ao banco de dados.
configuration: Configurações específicas de infraestrutura, como segurança ou conexões.
messaging: Configurações e implementação de sistemas de mensagens, como filas ou eventos.
presentation: A camada responsável por interagir com a interface externa (UI ou API). Aqui, são definidos os controladores e DTOs que lidam com a troca de dados entre o usuário e a aplicação.

controller: Controladores REST ou interfaces que respondem às solicitações HTTP.
dto: Objetos de Transferência de Dados (Data Transfer Objects) usados para comunicar dados entre a interface e a lógica de aplicação.
mapper: Mapeadores que convertem entidades do domínio em DTOs e vice-versa.
config: Contém as configurações gerais da aplicação, como beans do Spring ou configurações de segurança.

resources: Arquivos de configuração, como o application.properties, que define as propriedades da aplicação e configurações para o Spring Boot.

Exemplo de Fluxo de Uso
Quando uma requisição é feita, ela segue o seguinte fluxo:

Requisição: O controlador na camada de presentation recebe a solicitação (ex: uma requisição HTTP).
Camada de Aplicação: O controlador chama o caso de uso apropriado, que reside em application/usecase, passando os dados necessários.
Camada de Domínio: O caso de uso, por sua vez, interage com o modelo de domínio (domain/model) e utiliza interfaces de repositório (domain/repository) para buscar ou salvar dados.
Camada de Infraestrutura: A implementação do repositório (em infrastructure/persistence) acessa o banco de dados ou outra fonte de dados externa.
Resposta: Após a execução das regras de negócio, o fluxo retorna para a camada de apresentação, onde o resultado é mapeado para um DTO e enviado como resposta ao cliente.
Regras de Dependência
A camada domain não deve depender de nenhuma outra camada.
A camada application pode depender da camada domain.
A camada infrastructure e presentation podem depender das camadas domain e application, mas não devem ser diretamente acopladas entre si.
```
