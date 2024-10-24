package com.thigas.quack.infrastructure.persistence.repository.impl;

import com.thigas.quack.domain.repository.ILessonRepository;
import com.thigas.quack.infrastructure.persistence.entity.LessonModel;
import com.thigas.quack.infrastructure.persistence.repository.jpa.ILessonModelRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public class LessonRepositoryImplementation implements ILessonRepository {

    @Autowired
    private ILessonModelRepository lessonModelRepository;

    @Override
    @Transactional
    public LessonModel save(LessonModel lessonModel) {
        return lessonModelRepository.save(lessonModel);
    }

    @Override
    @Transactional
    public Boolean existsById(int id) {
        return lessonModelRepository.existsById(id);
    }

    @Override
    @Transactional
    public Set<LessonModel> saveAll(Set<LessonModel> lessons) {
        List<LessonModel> savedLessonModels = lessonModelRepository.saveAll(lessons);

        return new HashSet<>(savedLessonModels);
    }

    @Override
    @Transactional
    public Optional<LessonModel> findById(int id) {
        return lessonModelRepository.findById(id); // Usando lambda para passar contexto
    }

    @Override
    @Transactional
    public Set<LessonModel> findAll() {
        List<LessonModel> lessonModels = lessonModelRepository.findAll();

        return new HashSet<>(lessonModels);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        lessonModelRepository.deleteById(id);
    }

}
