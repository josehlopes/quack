package com.thigas.quack.UseCase.Service;

import com.thigas.quack.Adapter.Dto.UserDTO;
import com.thigas.quack.Adapter.Dto.UserRegisterDTO;
import com.thigas.quack.Adapter.Mapper.ObjectMapperService;
import com.thigas.quack.Domain.Entity.User;
import com.thigas.quack.Domain.Factory.UserFactory;
import com.thigas.quack.Domain.Utils.Status;
import com.thigas.quack.UseCase.Boundary.UserInputBoundary;
import com.thigas.quack.UseCase.Gateway.UserDsGateway;
import com.thigas.quack.UseCase.Model.Request.UserDtoRequestModel;
import com.thigas.quack.UseCase.Model.Response.UserResponseModel;
import com.thigas.quack.UseCase.Presenter.UserPresenter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.Optional;

@Service
public class UserService implements UserInputBoundary {

    final UserDsGateway userDsGateway;
    final UserPresenter userPresenter;
    final UserFactory userFactory;

    public UserService(UserDsGateway userDsGateway, UserPresenter userPresenter, UserFactory userFactory) {
        this.userDsGateway = userDsGateway;
        this.userPresenter = userPresenter;
        this.userFactory = userFactory;
    }

    @Autowired
    private ObjectMapperService objectMapperService = new ObjectMapperService();

    @Override
    public UserResponseModel create(UserDtoRequestModel userRequest) {
        if (userDsGateway.existsByEmail(userRequest.getEmail())) {
            return userPresenter.prepareFailView("User already exists");
        }
        User user = userFactory.create(userRequest.getName(),userRequest.getPhone(),userRequest.getEmail(),userRequest.getPassword(),userRequest.getCpf(), userRequest.getBornDate(),userRequest.getImagePath());
        if (!user.passwordIsValid()) {
            return userPresenter.prepareFailView("User password must have more than 8 characters.");
        }
        OffsetDateTime now = OffsetDateTime.now();
        UserDtoRequestModel userDsModel = new UserDtoRequestModel();
        userDsModel.setName(user.getName());
        userDsModel.setPhone(user.getPhone());
        userDsModel.setEmail(user.getEmail());
        userDsModel.setPassword(user.getPassword());
        userDsModel.setCpf(user.getCpf());
        userDsModel.setBornDate(user.getBornDate());
        userDsModel.setRegisterOn(now);
        userDsModel.setImagePath(user.getImagePath());
        userDsModel.setStatus(Status.ACTIVE);

        userDsGateway.save(userDsModel);

        UserResponseModel accoutReponseModel = new UserResponseModel(user.getUsername(), now.toString(), "Usuário criado com sucesso!");
        return userPresenter.prepareSuccessView(accoutReponseModel);
    }


//    public Optional<UserDTO> getById(int id) {
//        return userRepository.findById(id)
//                .map(objectMapperService::toDto);
//    }
//
//    public Iterable<UserDTO> getAll() {
//        Iterable<UserDataMapper> users = userRepository.findAll();
//        return StreamSupport.stream(users.spliterator(), false)
//                .map(objectMapperService::toDto)
//                .collect(Collectors.toList());
//    }
//
//    public void update(UserDTO userDTO) {
//        UserDataMapper existingUser = userRepository.findById(userDTO.getId())
//                .orElseThrow(() -> new EntityNotFoundException("User not found"));
//
//        if (userDTO.getName() != null) {
//            existingUser.setName(userDTO.getName());
//        }
//        if (userDTO.getBornAt() != null) {
//            existingUser.setBornAt(LocalDate.parse(userDTO.getBornAt()));
//        }
//
//        userRepository.save(existingUser);
//    }
//
//    public void delete(int id) {
//        if (!userRepository.existsById(id)) {
//            throw new EntityNotFoundException("User not found");
//        }
//        userRepository.deleteById(id);
//    }
//
    public Optional<UserDtoRequestModel> findByEmail(String email) {
    return userDsGateway.findByEmail(email);
    }

    public Optional<UserDtoRequestModel> findByUsername(String username) {
        return userDsGateway.findByUsername(username);
    }

    public boolean existsByEmailOrUsername(String email, String username) {
        return userDsGateway.existsByEmail(email) || userDsGateway.existsByUsername(username);
    }
//
//
//    //TODO: Recuperar as outras classes, DTOS, Entities
//
//    public Boolean existsById(int userId) {
//        return userRepository.existsById(userId);
//    }
//

}
