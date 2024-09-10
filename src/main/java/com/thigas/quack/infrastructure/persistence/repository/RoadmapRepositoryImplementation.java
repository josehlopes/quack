package com.thigas.quack.infrastructure.persistence.repository;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.thigas.quack.domain.entity.Roadmap;
import com.thigas.quack.domain.repository.IRoadmapRepository;
import com.thigas.quack.infrastructure.persistence.entity.RoadmapModel;

@Repository
public class RoadmapRepositoryImplementation implements IRoadmapRepository {

    @Autowired
    private IRoadmapModelRepository roadmapModelRepository;

    @Override
    public Roadmap save(Roadmap roadmap) {
        RoadmapModel roadmapModel = mapToRoadmapModel(roadmap);
        return mapToRoadmap(roadmapModelRepository.save(roadmapModel));
    }

    @Override
    public Optional<Roadmap> findById(Long id) {
        return roadmapModelRepository.findById(id).map(this::mapToRoadmap);
    }

    @Override
    public Iterable<Roadmap> findAll() {
        return roadmapModelRepository.findAll().stream().map(this::mapToRoadmap).toList();
    }

    @Override
    public void deleteById(Long id) {
        roadmapModelRepository.deleteById(id);
    }

    // Transforma os dados do banco em objeto Roadmap
    private Roadmap mapToRoadmap(RoadmapModel roadmapModel) {
        Roadmap roadmap = new Roadmap();
        roadmap.setId(roadmapModel.getId());
        roadmap.setTitle(roadmapModel.getTitle());
        roadmap.setDescription(roadmapModel.getDescription());
        roadmap.setImagePath(roadmapModel.getImagePath());
        return roadmap;
    }

    // Transforma o objeto Roadmap em RoadmapModel para o banco de dados
    private RoadmapModel mapToRoadmapModel(Roadmap roadmap) {
        RoadmapModel roadmapModel = new RoadmapModel();
        roadmapModel.setId(roadmap.getId());
        roadmapModel.setTitle(roadmap.getTitle());
        roadmapModel.setDescription(roadmap.getDescription());
        roadmapModel.setImagePath(roadmap.getImagePath());
        return roadmapModel;
    }
}
