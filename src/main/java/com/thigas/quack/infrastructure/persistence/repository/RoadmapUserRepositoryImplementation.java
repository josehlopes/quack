package com.thigas.quack.infrastructure.persistence.repository;

import java.util.Optional;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.thigas.quack.domain.entity.Roadmap;
import com.thigas.quack.domain.entity.RoadmapUser;
import com.thigas.quack.domain.entity.User;
import com.thigas.quack.domain.repository.IRoadmapUserRepository;
import com.thigas.quack.infrastructure.persistence.entity.RoadmapModel;
import com.thigas.quack.infrastructure.persistence.entity.RoadmapUserModel;
import com.thigas.quack.infrastructure.persistence.entity.UserModel;

@Repository
public class RoadmapUserRepositoryImplementation implements IRoadmapUserRepository {

    @Autowired
    private IRoadmapUserModelRepository roadmapUserModelRepository;

    @Override
    public RoadmapUser save(RoadmapUser roadmapUser) {
        RoadmapUserModel roadmapUserModel = mapToRoadmapUserModel(roadmapUser);
        return mapToRoadmapUser(roadmapUserModelRepository.save(roadmapUserModel));
    }

    @Override
    public Optional<RoadmapUser> findById(Long id) {
        return roadmapUserModelRepository.findById(id).map(this::mapToRoadmapUser);
    }

    @Override
    public Iterable<RoadmapUser> findAll() {
        return StreamSupport.stream(roadmapUserModelRepository.findAll().spliterator(), false)
                .map(this::mapToRoadmapUser)
                .toList();
    }

    @Override
    public void deleteById(Long id) {
        roadmapUserModelRepository.deleteById(id);
    }

    // Transforma RoadmapUserModel em RoadmapUser
    private RoadmapUser mapToRoadmapUser(RoadmapUserModel roadmapUserModel) {
        RoadmapUser roadmapUser = new RoadmapUser();
        roadmapUser.setId(roadmapUserModel.getId());
        roadmapUser.setUser(mapToUser(roadmapUserModel.getUser()));
        roadmapUser.setRoadmap(mapToRoadmap(roadmapUserModel.getRoadmap()));
        return roadmapUser;
    }

    // Transforma RoadmapUser em RoadmapUserModel
    private RoadmapUserModel mapToRoadmapUserModel(RoadmapUser roadmapUser) {
        RoadmapUserModel roadmapUserModel = new RoadmapUserModel();
        roadmapUserModel.setId(roadmapUser.getId());
        roadmapUserModel.setUser(mapToUserModel(roadmapUser.getUser()));
        roadmapUserModel.setRoadmap(mapToRoadmapModel(roadmapUser.getRoadmap()));
        return roadmapUserModel;
    }

    // Métodos de mapeamento adicionais
    private User mapToUser(UserModel userModel) {
        User user = new User();
        user.setId(userModel.getId());
        // Preencha outros campos necessários
        return user;
    }

    private Roadmap mapToRoadmap(RoadmapModel roadmapModel) {
        Roadmap roadmap = new Roadmap();
        roadmap.setId(roadmapModel.getId());
        // Preencha outros campos necessários
        return roadmap;
    }

    private UserModel mapToUserModel(User user) {
        UserModel userModel = new UserModel();
        userModel.setId(user.getId());
        // Preencha outros campos necessários
        return userModel;
    }

    private RoadmapModel mapToRoadmapModel(Roadmap roadmap) {
        RoadmapModel roadmapModel = new RoadmapModel();
        roadmapModel.setId(roadmap.getId());
        // Preencha outros campos necessários
        return roadmapModel;
    }
}
