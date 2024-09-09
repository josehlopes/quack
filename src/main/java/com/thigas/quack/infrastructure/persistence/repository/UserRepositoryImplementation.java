package com.thigas.quack.infrastructure.persistence.repository;

import com.thigas.quack.domain.entity.User;
import com.thigas.quack.domain.repository.IUserRepository;
import com.thigas.quack.infrastructure.persistence.entity.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

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


    //Transforma os dados do banco em objeto
    private User mapToUser(UserModel userModel) {
        User user = new User();
        user.setId(userModel.getId());
        user.setName(userModel.getName());
        user.setPhone(userModel.getPhone());
        user.setEmail(userModel.getEmail());
        user.setPassword(userModel.getPassword());
        user.setCpf(userModel.getCpf());
        user.setBornAt(userModel.getBornAt());
        user.setPoints(userModel.getPoints());
        user.setRegisterAt(userModel.getRegisterAt());
        user.setImagePath(userModel.getImagePath());
        return user;
    }

    private UserModel mapToUserModel(User user) {
        UserModel userModel = new UserModel();
        userModel.setId(user.getId());
        userModel.setName(user.getName());
        userModel.setPhone(user.getPhone());
        userModel.setEmail(user.getEmail());
        userModel.setPassword(user.getPassword());
        userModel.setCpf(user.getCpf());
        userModel.setBornAt(user.getBornAt());
        userModel.setPoints(user.getPoints());
        userModel.setRegisterAt(user.getRegisterAt());
        userModel.setImagePath(user.getImagePath());
        return userModel;
    }
}
