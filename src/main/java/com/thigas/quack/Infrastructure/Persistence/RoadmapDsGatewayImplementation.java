package com.thigas.quack.Infrastructure.Persistence;

import com.thigas.quack.Infrastructure.Entity.RoadmapDataMapper;
import com.thigas.quack.UseCase.Gateway.RoadmapDsGateway;
import com.thigas.quack.Infrastructure.Repository.JpaRoadmapRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class RoadmapDsGatewayImplementation implements RoadmapDsGateway {

    @Autowired
    private JpaRoadmapRepository roadmapModelRepository;

    @Override
    public void save(RoadmapDataMapper roadmapDataMapper) {
         roadmapModelRepository.save(roadmapDataMapper);
    }

    @Override
    public Optional<RoadmapDataMapper> findById(int id) {
        return roadmapModelRepository.findById(id);
    }

    @Override
    public boolean existsById(int id) {
        return roadmapModelRepository.existsById(id);
    }

    @Override
    public Iterable<RoadmapDataMapper> findAll() {
        return roadmapModelRepository.findAll();
    }

    @Override
    public void deleteById(int id) {
        roadmapModelRepository.deleteById(id);
    }
}
