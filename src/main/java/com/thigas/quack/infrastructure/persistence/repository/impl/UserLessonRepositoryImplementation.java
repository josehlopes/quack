package com.thigas.quack.infrastructure.persistence.repository.impl;

import com.thigas.quack.domain.repository.IUserLessonRepository;
import com.thigas.quack.infrastructure.persistence.entity.UserLessonModel;
import com.thigas.quack.infrastructure.persistence.repository.jpa.IUserLessonModelRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserLessonRepositoryImplementation  implements IUserLessonRepository {

    @Autowired
    private IUserLessonModelRepository userLessonModelRepository;

    @Override
    @Transactional
    public UserLessonModel save(UserLessonModel userLessonModel) {
        return userLessonModelRepository.save(userLessonModel);
    }

    @Override
    @Transactional
    public Optional<UserLessonModel> findById(int id) {
        return userLessonModelRepository.findById(id);
    }

    @Override
    @Transactional
    public List<UserLessonModel> findAll() {
        return userLessonModelRepository.findAll();
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        userLessonModelRepository.deleteById(id);
    }

    @Override
    @Transactional
    public Boolean existsById(int id) {
        return userLessonModelRepository.existsById(id);
    }
}
