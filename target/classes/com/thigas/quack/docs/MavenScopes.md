````markdown
# Escopos Maven

Os escopos Maven determinam a disponibilidade e a inclusão das dependências durante o ciclo de vida do projeto. Cada escopo tem um propósito específico e influencia como e quando as dependências são usadas.

## 1. Escopo `compile`

**Objetivo**: O escopo `compile` é o padrão se nenhum escopo for especificado. As dependências com este escopo estão disponíveis em todas as fases do ciclo de vida do Maven, incluindo a compilação, execução e o pacote final.

**Quando usar**: Utilize este escopo para dependências que são necessárias para a compilação e execução do projeto.

### Exemplo

```xml
<dependency>
    <groupId>com.example</groupId>
    <artifactId>example-lib</artifactId>
    <version>1.0.0</version>
    <scope>compile</scope>
</dependency>
```
````

## 2. Escopo `provided`

**Objetivo**: O escopo `provided` indica que a dependência é fornecida pelo ambiente de execução, como um servidor de aplicações. Ela é necessária para compilar e executar o projeto, mas não será incluída no pacote final.

**Quando usar**: Use este escopo para dependências que são fornecidas externamente pelo ambiente onde a aplicação será executada (como APIs de contêineres).

### Exemplo

```xml
<dependency>
    <groupId>javax.servlet</groupId>
    <artifactId>javax.servlet-api</artifactId>
    <version>4.0.1</version>
    <scope>provided</scope>
</dependency>
```

## 3. Escopo `runtime`

**Objetivo**: O escopo `runtime` indica que a dependência é necessária apenas em tempo de execução e não em tempo de compilação. As dependências com este escopo são incluídas no pacote final.

**Quando usar**: Utilize este escopo para dependências que são necessárias para executar o projeto, mas não para a compilação.

### Exemplo

```xml
<dependency>
    <groupId>org.postgresql</groupId>
    <artifactId>postgresql</artifactId>
    <version>42.2.5</version>
    <scope>runtime</scope>
</dependency>
```

## 4. Escopo `test`

**Objetivo**: O escopo `test` é usado para dependências necessárias apenas para a compilação e execução de testes. Essas dependências não são incluídas no pacote final.

**Quando usar**: Utilize este escopo para bibliotecas e ferramentas que são usadas apenas durante a fase de teste.

### Exemplo

```xml
<dependency>
    <groupId>junit</groupId>
    <artifactId>junit</artifactId>
    <version>4.13.1</version>
    <scope>test</scope>
</dependency>
```

## 5. Escopo `system`

**Objetivo**: O escopo `system` permite que você forneça explicitamente a dependência com um caminho de sistema. Esse escopo é raramente usado e pode causar problemas de portabilidade.

**Quando usar**: Use este escopo com cuidado, geralmente apenas quando for necessário referenciar uma dependência específica do sistema.

### Exemplo

```xml
<dependency>
    <groupId>com.example</groupId>
    <artifactId>example-system-lib</artifactId>
    <version>1.0.0</version>
    <scope>system</scope>
    <systemPath>${project.basedir}/lib/example-system-lib.jar</systemPath>
</dependency>
```

## 6. Escopo `import`

**Objetivo**: O escopo `import` é usado em dependências de tipo `pom` para importar dependências de outros projetos Maven. Esse escopo é usado apenas em arquivos `pom.xml` para gerenciar dependências comuns.

**Quando usar**: Utilize este escopo para importar e gerenciar dependências compartilhadas em vários projetos.

### Exemplo

```xml
<dependencyManagement>
    <dependencies>
        <dependency>
            <groupId>com.example</groupId>
            <artifactId>example-dependency-bom</artifactId>
            <version>1.0.0</version>
            <type>pom</type>
            <scope>import</scope>
        </dependency>
    </dependencies>
</dependencyManagement>
```

## Fluxo Geral

### Recebendo Dados:

1. **Adicionar Dependência**: Defina a dependência no arquivo `pom.xml` com o escopo apropriado.
2. **Compilação**: O Maven processa a dependência de acordo com o escopo definido durante a fase de compilação.

### Processando Dados:

1. **Inclusão no Pacote**: Dependências com escopos `compile`, `runtime` e `system` são incluídas no pacote final, enquanto as com escopo `provided` não são.
2. **Execução**: Durante a execução, o Maven utiliza as dependências conforme o escopo definido.

### Benefícios:

- **Controle**: O uso adequado dos escopos ajuda a controlar quais dependências são incluídas no pacote final e quando são necessárias.
- **Segurança**: Dependências não utilizadas não são incluídas, reduzindo a superfície de ataque e o tamanho do pacote.
- **Desempenho**: Otimização do tempo de construção e execução ao incluir apenas o necessário.

## Dicas Adicionais

- **Avaliação**: Avalie a necessidade de cada dependência para escolher o escopo adequado.
- **Documentação**: Mantenha a documentação do projeto atualizada para refletir as dependências e seus escopos.
- **Revisão**: Revise periodicamente as dependências e seus escopos para garantir que estão corretamente configurados.

A escolha adequada do escopo é fundamental para garantir que o projeto seja construído e executado de maneira eficiente e segura.

---

```

```
