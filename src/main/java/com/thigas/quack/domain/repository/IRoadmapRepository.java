package com.thigas.quack.domain.repository;

import com.thigas.quack.domain.entity.Roadmap;
import java.util.Optional;

public interface IRoadmapRepository {

    Roadmap save(Roadmap roadmap);

    Optional<Roadmap> findById(Long id);

    Iterable<Roadmap> findAll();

    void deleteById(Long id);
}