package com.thigas.quack.Infrastructure.Persistence;

import com.thigas.quack.Infrastructure.Model.UserLessonDataMapper;
import com.thigas.quack.UseCase.Gateway.UserLessonDsGateway;
import com.thigas.quack.Infrastructure.Repository.JpaUserLessonRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class UserLessonDsGatewayImplementation implements UserLessonDsGateway {

    @Autowired
    private JpaUserLessonRepository userLessonModelRepository;

    @Override
    public void save(UserLessonDataMapper userLessonDataMapper) {
        userLessonModelRepository.save(userLessonDataMapper);
    }

    @Override
    public Optional<UserLessonDataMapper> findById(int id) {
        return userLessonModelRepository.findById(id);
    }

    @Override
    public List<UserLessonDataMapper> findAll() {
        return userLessonModelRepository.findAll();
    }

    @Override
    public void deleteById(int id) {
        userLessonModelRepository.deleteById(id);
    }

    @Override
    public boolean existsById(int id) {
        return userLessonModelRepository.existsById(id);
    }
}
