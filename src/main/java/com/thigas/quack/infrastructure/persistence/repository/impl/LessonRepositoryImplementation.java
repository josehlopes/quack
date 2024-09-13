package com.thigas.quack.infrastructure.persistence.repository.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.thigas.quack.adapter.mapper.LessonMapper;
import com.thigas.quack.domain.entity.LessonEntity;
import com.thigas.quack.domain.repository.ILessonRepository;
import com.thigas.quack.infrastructure.persistence.entity.LessonModel;
import com.thigas.quack.infrastructure.persistence.repository.jpa.ILessonModelRepository;

@Repository
public class LessonRepositoryImplementation implements ILessonRepository {

    @Autowired
    private ILessonModelRepository lessonModelRepository;

    private final LessonMapper lessonMapper = LessonMapper.INSTANCE;

    public Optional<LessonEntity> findById(int id) {
        Optional<LessonModel> lessonModelOptional = lessonModelRepository.findById(id);
        return lessonModelOptional.map(lessonMapper::ModelToEntity);
    }

    public List<LessonEntity> findAll() {
        List<LessonModel> lessonModels = lessonModelRepository.findAll();
        return lessonModels.stream()
                .map(lessonMapper::ModelToEntity)
                .collect(Collectors.toList());
    }

    public void deleteById(int id) {
        lessonModelRepository.deleteById(id);
    }

    public LessonEntity save(LessonEntity lesson) {
        LessonModel lessonModel = lessonMapper.EntityToModel(lesson);
        LessonModel savedLessonModel = lessonModelRepository.save(lessonModel);
        return lessonMapper.ModelToEntity(savedLessonModel);
    }
}
