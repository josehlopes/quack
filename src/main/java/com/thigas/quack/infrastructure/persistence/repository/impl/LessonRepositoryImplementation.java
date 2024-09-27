package com.thigas.quack.infrastructure.persistence.repository.impl;

import com.thigas.quack.adapter.mapper.LessonMapper;
import com.thigas.quack.domain.entity.LessonEntity;
import com.thigas.quack.domain.repository.ILessonRepository;
import com.thigas.quack.infrastructure.persistence.entity.LessonModel;
import com.thigas.quack.infrastructure.persistence.repository.jpa.ILessonModelRepository;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Repository
public class LessonRepositoryImplementation implements ILessonRepository {

    private final LessonMapper lessonMapper = LessonMapper.INSTANCE;
    @Autowired
    private ILessonModelRepository lessonModelRepository;

    @Override
    @Transactional
    public LessonEntity save(LessonEntity lessonEntity) {
        LessonModel lessonModel = lessonMapper.entityToModel(lessonEntity);
        LessonModel savedLessonModel = lessonModelRepository.save(lessonModel);
        return lessonMapper.modelToEntity(savedLessonModel);
    }

    @Override
    @Transactional
    public Set<LessonEntity> saveAll(Set<LessonEntity> lessons) {
        List<LessonModel> lessonModels = lessons.stream().map(lessonMapper::entityToModel).collect(Collectors.toList());
        List<LessonModel> savedLessonModels = lessonModelRepository.saveAll(lessonModels);
        return savedLessonModels.stream().map(lessonMapper::modelToEntity).collect(Collectors.toSet());
    }

    @Override
    @Transactional
    public Optional<LessonEntity> findById(int id) {
        Optional<LessonModel> lessonModelOptional = lessonModelRepository.findById(id);
        return lessonModelOptional.map(lessonMapper::modelToEntity);
    }

    @Override
    @Transactional
    public List<LessonEntity> findAll() {
        List<LessonModel> lessonModels = lessonModelRepository.findAll();
        return lessonModels.stream().map(lessonMapper::modelToEntity).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        lessonModelRepository.deleteById(id);
    }

}
