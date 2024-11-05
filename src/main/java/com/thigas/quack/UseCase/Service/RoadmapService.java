package com.thigas.quack.UseCase.Service;

import com.thigas.quack.Adapter.Dto.RoadmapDTO;
import com.thigas.quack.Adapter.Mapper.ObjectMapperService;
import com.thigas.quack.UseCase.Gateway.RoadmapDsGateway;
import com.thigas.quack.UseCase.Gateway.UserDsGateway;
import com.thigas.quack.Infrastructure.Entity.RoadmapDataMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class RoadmapService {

    @Autowired
    private RoadmapDsGateway roadmapRepository;

    @Autowired
    private UserDsGateway userRepository;

    @Autowired
    private ObjectMapperService objectMapperService = new ObjectMapperService();

    public void create(RoadmapDTO roadmapDTO) {
        RoadmapDataMapper roadmap = objectMapperService.toModel(roadmapDTO);
        roadmapRepository.save(roadmap);
    }

    public Optional<RoadmapDTO> getById(int id) {
        Optional<RoadmapDataMapper> roadmapOpt = roadmapRepository.findById(id);
        return roadmapOpt.map(objectMapperService::toDto);
    }

    public Iterable<RoadmapDTO> getAll() {
        Iterable<RoadmapDataMapper> roadmaps = roadmapRepository.findAll();
        return StreamSupport.stream(roadmaps.spliterator(), false)
                .map(objectMapperService::toDto)
                .collect(Collectors.toList());
    }

    public void update(RoadmapDTO roadmapDTO) {
        RoadmapDataMapper roadmap = objectMapperService.toModel(roadmapDTO);
        roadmapRepository.save(roadmap);
    }

    public void delete(int id) {
        roadmapRepository.deleteById(id);
    }

    public Boolean existsById(int roadmapId) {
        return userRepository.existsById(roadmapId);
    }
}
