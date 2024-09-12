package com.thigas.quack.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thigas.quack.domain.entity.RoadmapUser;
import com.thigas.quack.domain.repository.IRoadmapUserRepository;

@Service
public class RoadmapUserService {

    @Autowired
    private IRoadmapUserRepository roadmapUserRepository;

    public RoadmapUser create(RoadmapUser roadmapUser) {
        return roadmapUserRepository.save(roadmapUser);
    }

    public Iterable<RoadmapUser> getAll() {
        return roadmapUserRepository.findAll();
    }

    public void delete(Long id) {
        roadmapUserRepository.deleteById(id);
    }
}
