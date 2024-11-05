package com.thigas.quack.Infrastructure.Persistence;

import com.thigas.quack.Infrastructure.Entity.LessonDataMapper;
import com.thigas.quack.Infrastructure.Repository.JpaLessonRepository;
import com.thigas.quack.UseCase.Gateway.LessonDsGateway;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public class LessonDsGatewayImplementation implements LessonDsGateway {

    @Autowired
    private JpaLessonRepository lessonModelRepository;

    @Override
    public void save(LessonDataMapper lessonDataMapper) {
         lessonModelRepository.save(lessonDataMapper);
    }

    @Override
    public boolean existsById(int id) {
        return lessonModelRepository.existsById(id);
    }

    @Override
    public Set<LessonDataMapper> saveAll(Set<LessonDataMapper> lessons) {
        List<LessonDataMapper> savedLessonDataMappers = lessonModelRepository.saveAll(lessons);

        return new HashSet<>(savedLessonDataMappers);
    }

    @Override
    public Optional<LessonDataMapper> findById(int id) {
        return lessonModelRepository.findById(id); // Usando lambda para passar contexto
    }

    @Override
    public Set<LessonDataMapper> findAll() {
        List<LessonDataMapper> lessonDataMappers = lessonModelRepository.findAll();

        return new HashSet<>(lessonDataMappers);
    }

    @Override
    public void deleteById(int id) {
        lessonModelRepository.deleteById(id);
    }

}
