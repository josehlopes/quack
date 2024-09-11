# Documentação do Código

Este documento explica o funcionamento dos principais componentes do código, com detalhes sobre serviços, repositórios, controladores e como as diferentes partes da aplicação interagem entre si.

## Índice

- [Documentação do Código](#documentação-do-código)
  - [Índice](#índice)
  - [Serviços (application/service)](#serviços-applicationservice)
    - [Descrição](#descrição)
    - [Exemplo](#exemplo)
  - [Casos de Uso (application/usecase)](#casos-de-uso-applicationusecase)
    - [Descrição:](#descrição-1)
    - [Exemplo: RunUserCodeUseCase](#exemplo-runusercodeusecase)
  - [Modelos de Domínio (domain/model)](#modelos-de-domínio-domainmodel)
    - [Descrição](#descrição-2)
    - [Exemplo: User](#exemplo-user)
  - [Repositórios (domain/repository)](#repositórios-domainrepository)
    - [Descrição](#descrição-3)
    - [Exemplo: IUserRepository](#exemplo-iuserrepository)
  - [Controladores (presentation/controller)](#controladores-presentationcontroller)
    - [Descrição](#descrição-4)
    - [Exemplo: UserController](#exemplo-usercontroller)
    - [DTO/MAPPERS](#dtomappers)
  - [Persistência (infrastructure/persistence)](#persistência-infrastructurepersistence)
    - [Descrição](#descrição-5)
    - [Exemplo: UserModelRepository](#exemplo-usermodelrepository)

---

## Serviços (application/service)

### Descrição

Os serviços na camada de `application` orquestram a execução de casos de uso e interagem com a camada de domínio. Eles não contêm lógica de negócio, mas coordenam as operações.

### Exemplo

```java
@Service
public class UserService {

    @Autowired
    private IUserRepository userRepository;

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

    public void updateUser(User user) {
        userRepository.save(user);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
```

## Casos de Uso (application/usecase)

### Descrição:

Os casos de uso `"usecases"` implementam regras de negócio específicas e descrevem ações que o sistema pode executar, como criar um usuário, processar uma transação, etc.

### Exemplo: RunUserCodeUseCase

```java
@Service
public class RunUserCodeUseCase {

    public String runTests(String userCode) {
        String result = CodeExecutor.runCode(userCode);

        StringBuilder resultBuilder = new StringBuilder("Resultados dos Testes:\n");
        resultBuilder.append(result);
        return resultBuilder.toString();
    }
}
```

## Modelos de Domínio (domain/model)

### Descrição

Os modelos de domínio `"domain models"` representam entidades e agregados que encapsulam a lógica de negócios principal. Eles não dependem de frameworks e são totalmente focados na lógica de negócios.

### Exemplo: User

```java
public class User {

    private Long id;
    private String name;
    private String phone;
    private String email;
    private String password;
    private String cpf;
    private LocalDate bornAt;
    private Double points;
    private LocalDateTime registerAt;
    private String imagePath;

    // Getters e Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
```

## Repositórios (domain/repository)

### Descrição

Os repositórios `"repositories"` são responsáveis por abstrair o acesso ao banco de dados ou outras fontes de dados. Eles fornecem interfaces que a camada de aplicação ou domínio utiliza.

### Exemplo: IUserRepository

```java

public interface IUserRepository {
    User save(User user);
    Optional<User> findById(Long id);
    Iterable<User> findAll();
    void deleteById(Long id);
}
```

## Controladores (presentation/controller)

### Descrição

Os controladores `"controllers"` recebem as requisições da interface do usuário (geralmente HTTP) e delegam a execução para os serviços e casos de uso. Eles são responsáveis por enviar as respostas adequadas de volta ao cliente.

### Exemplo: UserController

```java
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @GetMapping("/{id}")
    public Optional<User> getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @GetMapping
    public Iterable<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PutMapping("/{id}")
    public void updateUser(@PathVariable Long id, @RequestBody User user) {
        user.setId(id);
        userService.updateUser(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }
}
```

### DTO/MAPPERS

DTOs e Mapeadores (presentation/dto e presentation/mapper)
Descrição
Os DTOs (Data Transfer Objects) são usados para transferir dados entre a camada de apresentação e a camada de aplicação. Os mapeadores convertem entre entidades de domínio e DTOs.

## Persistência (infrastructure/persistence)

### Descrição

Nesta camada, são implementadas as interfaces de repositório definidas no domínio. Aqui você pode usar frameworks de persistência, como JPA, para conectar a aplicação ao banco de dados.

### Exemplo: UserModelRepository

```java
@Repository
public class UserRepositoryImplementation implements IUserRepository {

    @Autowired
    private UserModelRepository userModelRepository;

    @Override
    public User save(User user) {
        UserModel userModel = mapToUserModel(user);
        return mapToUser(userModelRepository.save(userModel));
    }

    @Override
    public Optional<User> findById(Long id) {
        return userModelRepository.findById(id).map(this::mapToUser);
    }

    @Override
    public Iterable<User> findAll() {
        return userModelRepository.findAll().stream().map(this::mapToUser).toList();
    }

    @Override
    public void deleteById(Long id) {
        userModelRepository.deleteById(id);
    }
}
```
