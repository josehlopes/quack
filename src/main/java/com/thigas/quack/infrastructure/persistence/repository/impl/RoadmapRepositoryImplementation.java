package com.thigas.quack.infrastructure.persistence.repository.impl;

import com.thigas.quack.adapter.mapper.RoadmapMapper;
import com.thigas.quack.domain.entity.RoadmapEntity;
import com.thigas.quack.domain.repository.IRoadmapRepository;
import com.thigas.quack.infrastructure.persistence.entity.RoadmapModel;
import com.thigas.quack.infrastructure.persistence.entity.UserModel;
import com.thigas.quack.infrastructure.persistence.entity.UserRoadmapModel;
import com.thigas.quack.infrastructure.persistence.repository.jpa.IRoadmapModelRepository;
import com.thigas.quack.infrastructure.persistence.repository.jpa.IUserModelRepository;
import com.thigas.quack.infrastructure.persistence.repository.jpa.IUserRoadmapModelRepository;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class RoadmapRepositoryImplementation implements IRoadmapRepository {

    private final RoadmapMapper userMapper = RoadmapMapper.INSTANCE;
    @Autowired
    private IRoadmapModelRepository roadmapModelRepository;
    private IUserModelRepository userModelRepository;
    private IUserRoadmapModelRepository userRoadmapModelRepository;

    @Override
    public RoadmapEntity save(RoadmapEntity roadmapEntity) {
        RoadmapModel roadmapModel = userMapper.entityToModel(roadmapEntity);
        RoadmapModel savedRoadmapModel = roadmapModelRepository.save(roadmapModel);
        return userMapper.modelToEntity(savedRoadmapModel);
    }

    @Override
    public Optional<RoadmapEntity> findById(int id) {
        return roadmapModelRepository.findById(id).map(userMapper::modelToEntity);
    }

    @Override
    public Iterable<RoadmapEntity> findAll() {
        return roadmapModelRepository.findAll().stream().map(userMapper::modelToEntity).collect(Collectors.toList());
    }

    @Override
    public void deleteById(int id) {
        roadmapModelRepository.deleteById(id);
    }

    @Transactional
    @Override
    public Boolean startRoadmap(int userId, int roadmapId) {

        UserRoadmapModel userRoadmapModel = new UserRoadmapModel();

        try {
            // Verificar se o usuário e o roadmap existem
            Optional<UserModel> userOptional = userModelRepository.findById(userId);
            Optional<RoadmapModel> roadmapOptional = roadmapModelRepository.findById(roadmapId);

            if (userOptional.isEmpty() || roadmapOptional.isEmpty()) {
                System.out.println("Usuário ou roadmap não encontrado.");
                return false;
            }

            // Criar um novo UserRoadmapEntity para associar o usuário ao roadmap
            userRoadmapModel.setUserId(userOptional.get());
            userRoadmapModel.setRoadmapId(roadmapOptional.get());
            userRoadmapModel.setProgress(0.0);
            userRoadmapModel.setStartedAt(LocalDate.now());

            // Salvar a associação no banco de dados
            userRoadmapModelRepository.save(userRoadmapModel);
            return true;

        } catch (Exception e) {
            System.out.println("Erro ao iniciar o roadmap: " + e.getMessage());
            return false;
        }
    }
}
