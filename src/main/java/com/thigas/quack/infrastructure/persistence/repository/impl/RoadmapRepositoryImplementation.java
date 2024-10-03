package com.thigas.quack.infrastructure.persistence.repository.impl;

import com.thigas.quack.adapter.mapper.CycleAvoidingMappingContext;
import com.thigas.quack.adapter.mapper.RoadmapMapper;
import com.thigas.quack.domain.repository.IRoadmapRepository;
import com.thigas.quack.infrastructure.persistence.entity.RoadmapModel;
import com.thigas.quack.infrastructure.persistence.repository.jpa.IRoadmapModelRepository;
import com.thigas.quack.infrastructure.persistence.repository.jpa.IUserModelRepository;
import com.thigas.quack.infrastructure.persistence.repository.jpa.IUserRoadmapModelRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class RoadmapRepositoryImplementation implements IRoadmapRepository {

    @Autowired
    private RoadmapMapper roadmapMapper;

    @Autowired
    private IRoadmapModelRepository roadmapModelRepository;

    @Autowired
    private IUserModelRepository userModelRepository;

    @Autowired
    private IUserRoadmapModelRepository userRoadmapModelRepository;

    @Autowired
    private CycleAvoidingMappingContext context;

    @Override
    @Transactional
    public RoadmapModel save(RoadmapModel roadmapModel) {
        return roadmapModelRepository.save(roadmapModel);
    }

    @Override
    @Transactional
    public Optional<RoadmapModel> findById(int id) {
        return roadmapModelRepository.findById(id);
    }

    @Override
    @Transactional
    public Boolean existsById(int id) {
        return roadmapModelRepository.existsById(id);
    }

    @Override
    @Transactional
    public Iterable<RoadmapModel> findAll() {
        return roadmapModelRepository.findAll();
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        roadmapModelRepository.deleteById(id);
    }
}
