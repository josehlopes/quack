package com.thigas.quack.Adapter.Persistence;

import com.thigas.quack.UseCase.Mapper.MapStructMapper;
import com.thigas.quack.Adapter.Entity.UserDataMapper;
import com.thigas.quack.Adapter.Repository.UserRepository;
import com.thigas.quack.UseCase.Gateway.UserDsGateway;
import com.thigas.quack.UseCase.Mapper.UserMapper;
import com.thigas.quack.UseCase.Model.Request.UserDsDtoRequestModel;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * Implementação da interface {@link UserDsGateway} que fornece acesso aos dados persistidos dos usuários.
 *
 * <p>Essa classe atua como um adaptador entre a camada de domínio e a camada de persistência,
 * utilizando o repositório {@link UserRepository} para realizar operações no banco de dados
 * e o mapeador {@link MapStructMapper} para converter entre modelos de dados das camadas de aplicação e persistência.</p>
 *
 * <p>Fornece métodos para criar, buscar, atualizar e excluir usuários, além de operações
 * para verificar a existência de usuários com base em identificadores específicos.</p>
 *
 * @see UserDsGateway
 * @see UserRepository
 * @see MapStructMapper
 * @see UserDsDtoRequestModel
 * @see UserDataMapper
 */
@AllArgsConstructor
public class UserDsGatewayImplementation implements UserDsGateway {

    private final UserRepository repository;
    private final UserMapper mapper;

    /**
     * Salva um novo usuário no banco de dados.
     *
     * @param requestModel O modelo de dados contendo as informações do usuário a ser salvo.
     */
    @Override
    public void save(UserDsDtoRequestModel requestModel) {
        UserDataMapper userDataMapper = mapper.toDataMapper(requestModel);
        repository.save(userDataMapper);
    }

    /**
     * Busca um usuário pelo seu ID.
     *
     * @param id O ID do usuário a ser buscado.
     * @return Um {@link Optional} contendo o modelo de dados do usuário, caso encontrado.
     */
    @Override
    public Optional<UserDsDtoRequestModel> getById(int id) {
        Optional<UserDataMapper> user = repository.findById(id);
        return user.map(mapper::toDsModel);
    }

    /**
     * Verifica se um usuário existe com base no seu ID.
     *
     * @param id O ID do usuário.
     * @return {@code true} se o usuário existir, {@code false} caso contrário.
     */
    @Override
    public Boolean findById(int id) {
        return repository.existsById(id);
    }

    /**
     * Atualiza os dados de um usuário existente no banco de dados.
     *
     * @param user O modelo de dados contendo as novas informações do usuário.
     * @return {@code true} se a atualização foi bem-sucedida.
     * @throws EntityNotFoundException Se o usuário não for encontrado pelo ID fornecido.
     */
    public Boolean update(UserDsDtoRequestModel user) {
        UserDataMapper existingUser = repository.findById(user.id())
                .orElseThrow(() -> new EntityNotFoundException("User not found"));
        existingUser.setName(user.name());
        existingUser.setSurname(user.surname());
        existingUser.setFullName(user.fullName());
        existingUser.setUsername(user.username());
        existingUser.setPhone(user.phone());
        existingUser.setEmail(user.email());
        existingUser.setBornDate(LocalDate.parse(user.bornDate()));
        existingUser.setRegisterOn(OffsetDateTime.parse(user.registerOn()));
        existingUser.setImagePath(user.imagePath());
        repository.update(existingUser);
        return true;
    }

    /**
     * Obtém todos os usuários do banco de dados.
     *
     * @return Uma lista iterável contendo os modelos de dados dos usuários.
     */
    @Override
    public Iterable<UserDsDtoRequestModel> getAll() {
        Iterable<UserDataMapper> users = repository.getAll();
        return StreamSupport.stream(users.spliterator(), false)
                .map(mapper::toDsModel)
                .collect(Collectors.toList());
    }

    /**
     * Exclui um usuário do banco de dados com base no seu ID.
     *
     * @param id O ID do usuário a ser excluído.
     */
    @Override
    public void deleteById(int id) {
        repository.deleteById(id);
    }

    /**
     * Busca um usuário pelo seu e-mail.
     *
     * @param email O e-mail do usuário a ser buscado.
     * @return Um {@link Optional} contendo o modelo de dados do usuário, caso encontrado.
     */
    @Override
    public Optional<UserDsDtoRequestModel> getByEmail(String email) {
        Optional<UserDataMapper> user = repository.findByEmail(email);
        return user.map(mapper::toDsModel);
    }

    /**
     * Busca um usuário pelo seu nome de usuário (username).
     *
     * @param username O nome de usuário a ser buscado.
     * @return Um {@link Optional} contendo o modelo de dados do usuário, caso encontrado.
     */
    @Override
    public Optional<UserDsDtoRequestModel> getByUsername(String username) {
        Optional<UserDataMapper> user = repository.findByUsername(username);
        return user.map(mapper::toDsModel);
    }

    /**
     * Verifica se um usuário existe com base no e-mail.
     *
     * @param email O e-mail do usuário.
     * @return {@code true} se o usuário existir, {@code false} caso contrário.
     */
    @Override
    public Boolean findByEmail(String email) {
        return repository.existsByEmail(email);
    }

    /**
     * Verifica se um usuário existe com base no nome de usuário (username).
     *
     * @param username O nome de usuário.
     * @return {@code true} se o usuário existir, {@code false} caso contrário.
     */
    @Override
    public Boolean findByUsername(String username) {
        return repository.existsByUsername(username);
    }
}
