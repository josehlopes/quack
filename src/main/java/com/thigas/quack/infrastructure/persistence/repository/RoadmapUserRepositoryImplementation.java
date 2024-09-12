package com.thigas.quack.infrastructure.persistence.repository;

import java.util.Optional;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.thigas.quack.domain.entity.RoadmapEntity;
import com.thigas.quack.domain.entity.RoadmapUserEntity;
import com.thigas.quack.domain.entity.UserEntity;
import com.thigas.quack.domain.repository.IRoadmapUserRepository;
import com.thigas.quack.infrastructure.persistence.entity.RoadmapModel;
import com.thigas.quack.infrastructure.persistence.entity.RoadmapUserModel;
import com.thigas.quack.infrastructure.persistence.entity.UserModel;

@Repository
public class RoadmapUserRepositoryImplementation implements IRoadmapUserRepository {

    @Autowired
    private IRoadmapUserModelRepository roadmapUserModelRepository;

    @Override
    public RoadmapUserEntity save(RoadmapUserEntity roadmapUser) {
        RoadmapUserModel roadmapUserModel = mapToRoadmapUserModel(roadmapUser);
        return mapToRoadmapUser(roadmapUserModelRepository.save(roadmapUserModel));
    }

    @Override
    public Optional<RoadmapUserEntity> findById(Long id) {
        return roadmapUserModelRepository.findById(id).map(this::mapToRoadmapUser);
    }

    @Override
    public Iterable<RoadmapUserEntity> findAll() {
        return StreamSupport.stream(roadmapUserModelRepository.findAll().spliterator(), false)
                .map(this::mapToRoadmapUser)
                .toList();
    }

    @Override
    public void deleteById(Long id) {
        roadmapUserModelRepository.deleteById(id);
    }

    // Transforma RoadmapUserModel em RoadmapUser
    private RoadmapUserEntity mapToRoadmapUser(RoadmapUserModel roadmapUserModel) {
        RoadmapUserEntity roadmapUser = new RoadmapUserEntity();
        roadmapUser.setId(roadmapUserModel.getId());
        roadmapUser.setUser(mapToUser(roadmapUserModel.getUser()));
        roadmapUser.setRoadmap(mapToRoadmap(roadmapUserModel.getRoadmap()));
        return roadmapUser;
    }

    // Transforma RoadmapUser em RoadmapUserModel
    private RoadmapUserModel mapToRoadmapUserModel(RoadmapUserEntity roadmapUser) {
        RoadmapUserModel roadmapUserModel = new RoadmapUserModel();
        roadmapUserModel.setId(roadmapUser.getId());
        roadmapUserModel.setUser(mapToUserModel(roadmapUser.getUser()));
        roadmapUserModel.setRoadmap(mapToRoadmapModel(roadmapUser.getRoadmap()));
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

    private RoadmapModel mapToRoadmapModel(RoadmapEntity roadmap) {
        RoadmapModel roadmapModel = new RoadmapModel();
        roadmapModel.setId(roadmap.getId());
        // Preencha outros campos necessários
        return roadmapModel;
    }
}
