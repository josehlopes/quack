package com.thigas.quack.infrastructure.persistence.repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.thigas.quack.adapter.mapper.LessonMapper;
import com.thigas.quack.domain.entity.Lesson;
import com.thigas.quack.domain.repository.ILessonRepository;
import com.thigas.quack.infrastructure.persistence.entity.LessonModel;

@Repository
public class LessonRepositoryImplementation implements ILessonRepository {

    @Autowired
    private ILessonModelRepository lessonModelRepository;

    private final LessonMapper lessonMapper = LessonMapper.INSTANCE;

    public Optional<Lesson> findById(Long id) {
        Optional<LessonModel> lessonModelOptional = lessonModelRepository.findById(id);
        return lessonModelOptional.map(lessonMapper::toLesson);
    }

    public List<Lesson> findAll() {
        List<LessonModel> lessonModels = lessonModelRepository.findAll();
        return lessonModels.stream()
                .map(lessonMapper::toLesson)
                .collect(Collectors.toList());
    }

    public void deleteById(Long id) {
        lessonModelRepository.deleteById(id);
    }

    public Lesson save(Lesson lesson) {
        LessonModel lessonModel = lessonMapper.toLessonModel(lesson);
        LessonModel savedLessonModel = lessonModelRepository.save(lessonModel);
        return lessonMapper.toLesson(savedLessonModel);
    }
}
