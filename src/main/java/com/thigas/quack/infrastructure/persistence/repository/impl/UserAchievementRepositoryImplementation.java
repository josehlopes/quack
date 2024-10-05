//package com.thigas.quack.infrastructure.persistence.repository.impl;
//
//import com.thigas.quack.adapter.mapper.UserAchievementMapper;
//import com.thigas.quack.domain.repository.IUserAchievementRepository;
//import com.thigas.quack.infrastructure.persistence.entity.UserAchievementModel;
//import com.thigas.quack.infrastructure.persistence.repository.jpa.IUserAchievementModelRepository;
//import jakarta.transaction.Transactional;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//
//import java.util.Optional;
//
//@Repository
//public class UserAchievementRepositoryImplementation implements IUserAchievementRepository {
//
//    @Autowired
//    private UserAchievementMapper userAchievementMapper;
//
//    @Autowired
//    private IUserAchievementModelRepository userAchievementModelRepository;
//
//    @Override
//    @Transactional
//    public UserAchievementModel save(UserAchievementModel userAchievementModel) {
//        return userAchievementModelRepository.save(userAchievementModel);
//    }
//
//    @Override
//    @Transactional
//    public Boolean existsById(int id) {
//        return userAchievementModelRepository.existsById(id);
//    }
//
//    @Override
//    @Transactional
//    public Optional<UserAchievementModel> findById(int id) {
//        return userAchievementModelRepository.findById(id);
//    }
//
//    @Override
//    @Transactional
//    public Iterable<UserAchievementModel> findAll() {
//        return userAchievementModelRepository.findAll();
//    }
//
//    @Override
//    @Transactional
//    public void deleteById(int id) {
//        userAchievementModelRepository.deleteById(id);
//    }
//}
