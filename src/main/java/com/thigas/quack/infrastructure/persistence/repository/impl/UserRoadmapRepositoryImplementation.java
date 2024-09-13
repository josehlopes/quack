package com.thigas.quack.infrastructure.persistence.repository.impl;

import java.util.Optional;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.thigas.quack.domain.entity.RoadmapEntity;
import com.thigas.quack.domain.entity.UserRoadmapEntity;
import com.thigas.quack.domain.entity.UserEntity;
import com.thigas.quack.domain.repository.IUserRoadmapRepository;
import com.thigas.quack.infrastructure.persistence.entity.RoadmapModel;
import com.thigas.quack.infrastructure.persistence.entity.UserRoadmapModel;
import com.thigas.quack.infrastructure.persistence.entity.UserModel;
import com.thigas.quack.infrastructure.persistence.repository.jpa.IUserRoadmapModelRepository;

@Repository
public class UserRoadmapRepositoryImplementation implements IUserRoadmapRepository {

    @Autowired
    private IUserRoadmapModelRepository roadmapUserModelRepository;

    @Override
    public UserRoadmapEntity save(UserRoadmapEntity roadmapUser) {
        UserRoadmapModel roadmapUserModel = EntityToModel(roadmapUser);
        return mapToRoadmapUser(roadmapUserModelRepository.save(roadmapUserModel));
    }

    @Override
    public Optional<UserRoadmapEntity> findById(int id) {
        return roadmapUserModelRepository.findById(id).map(this::mapToRoadmapUser);
    }

    @Override
    public Iterable<UserRoadmapEntity> findAll() {
        return StreamSupport.stream(roadmapUserModelRepository.findAll().spliterator(), false)
                .map(this::mapToRoadmapUser)
                .toList();
    }

    @Override
    public void deleteById(int id) {
        roadmapUserModelRepository.deleteById(id);
    }

    // Transforma RoadmapUserModel em RoadmapUser
    private UserRoadmapEntity mapToRoadmapUser(UserRoadmapModel roadmapUserModel) {
        UserRoadmapEntity roadmapUser = new UserRoadmapEntity();
        roadmapUser.setId(roadmapUserModel.getId());
        roadmapUser.setUser(mapToUser(roadmapUserModel.getUser()));
        roadmapUser.setRoadmap(mapToRoadmap(roadmapUserModel.getRoadmap()));
        return roadmapUser;
    }

    // Transforma RoadmapUser em RoadmapUserModel
    private UserRoadmapModel EntityToModel(UserRoadmapEntity roadmapUser) {
        UserRoadmapModel roadmapUserModel = new UserRoadmapModel();
        roadmapUserModel.setId(roadmapUser.getId());
        roadmapUserModel.setUser(mapToUserModel(roadmapUser.getUser()));
        roadmapUserModel.setRoadmap(ModelToEntity(roadmapUser.getRoadmap()));
        return roadmapUserModel;
    }

    // Métodos de mapeamento adicionais
    private UserEntity mapToUser(UserModel userModel) {
        UserEntity user = new UserEntity();
        user.setId(userModel.getId());
        // Preencha outros campos necessários
        return user;
    }

    private RoadmapEntity mapToRoadmap(RoadmapModel roadmapModel) {
        RoadmapEntity roadmap = new RoadmapEntity();
        roadmap.setId(roadmapModel.getId());
        // Preencha outros campos necessários
        return roadmap;
    }

    private UserModel mapToUserModel(UserEntity user) {
        UserModel userModel = new UserModel();
        userModel.setId(user.getId());
        // Preencha outros campos necessários
        return userModel;
    }

    private RoadmapModel ModelToEntity(RoadmapEntity roadmap) {
        RoadmapModel roadmapModel = new RoadmapModel();
        roadmapModel.setId(roadmap.getId());
        // Preencha outros campos necessários
        return roadmapModel;
    }
}
