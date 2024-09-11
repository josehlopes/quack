package com.thigas.quack.application.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thigas.quack.domain.entity.Roadmap;
import com.thigas.quack.domain.repository.IRoadmapRepository;

@Service
public class RoadmapService {

    @Autowired
    private IRoadmapRepository roadmapRepository;

    public Roadmap createRoadmap(Roadmap roadmap) {
        return roadmapRepository.save(roadmap);
    }

    public Optional<Roadmap> getRoadmapById(Long id) {
        return roadmapRepository.findById(id);
    }

    public Iterable<Roadmap> getAllRoadmaps() {
        return roadmapRepository.findAll();
    }

    public void updateRoadmap(Roadmap roadmap) {
        roadmapRepository.save(roadmap);
    }

    public void deleteRoadmap(Long id) {
        roadmapRepository.deleteById(id);
    }
}
