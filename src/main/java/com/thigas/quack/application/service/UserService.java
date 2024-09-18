package com.thigas.quack.application.service;

import com.thigas.quack.adapter.dto.UserDTO;
import com.thigas.quack.adapter.mapper.UserMapper;
import com.thigas.quack.domain.entity.UserEntity;
import com.thigas.quack.domain.repository.IUserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class UserService {

    private final UserMapper userMapper = UserMapper.INSTANCE;
    @Autowired
    private IUserRepository userRepository;

    public UserDTO create(UserDTO userDTO) {
        // Converter DTO para entidade
        UserEntity user = userMapper.DtoToEntity(userDTO);
        // Salvar a entidade
        UserEntity toSaveUser = userRepository.save(user);
        // Converter entidade de volta para DTO
        return userMapper.EntityToDto(toSaveUser);
    }

    public Optional<UserDTO> getById(int id) {
        // Buscar a entidade do repositório
        Optional<UserEntity> user = userRepository.findById(id);
        // Converter a entidade para DTO
        return user.map(userMapper::EntityToDto);
    }

    public Iterable<UserDTO> getAll() {
        // Buscar todas as entidades
        Iterable<UserEntity> users = userRepository.findAll();
        // Converter todas as entidades para DTOs
        return StreamSupport.stream(users.spliterator(), false)
                .map(userMapper::EntityToDto)
                .collect(Collectors.toList());
    }

    public void update(UserDTO userDTO) {
        // Carregar a entidade existente
        UserEntity existingUser = userRepository.findById(userDTO.getId())
                .orElseThrow(() -> new EntityNotFoundException("User not found"));

        // Atualizar apenas os campos fornecidos no DTO
        if (userDTO.getName() != null) {
            existingUser.setName(userDTO.getName());
        }
        if (userDTO.getBornAt() != null) {
            existingUser.setBornAt(LocalDate.parse(userDTO.getBornAt()));
        }
        // Atualize outros campos conforme necessário...

        // Salvar a entidade atualizada
        userRepository.save(existingUser);
    }


    public void delete(int id) {
        userRepository.deleteById(id);
    }
}
