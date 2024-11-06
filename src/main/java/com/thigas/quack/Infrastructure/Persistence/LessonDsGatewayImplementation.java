package com.thigas.quack.Infrastructure.Persistence;

import com.thigas.quack.Infrastructure.Repository.JpaLessonRepository;
import com.thigas.quack.UseCase.Gateway.LessonDsGateway;
import com.thigas.quack.UseCase.Model.Request.LessonDtoRequestModel;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public class LessonDsGatewayImplementation implements LessonDsGateway {

    @Autowired
    private JpaLessonRepository lessonModelRepository;

    @Override
    public void save(LessonDtoRequestModel lessonDtoRequest) {
         lessonModelRepository.save(lessonDtoRequest);
    }

    @Override
    public boolean existsById(int id) {
        return lessonModelRepository.existsById(id);
    }

    @Override
    public Set<LessonDtoRequestModel> saveAll(Set<LessonDtoRequestModel> lessons) {
        List<LessonDtoRequestModel> savedLessonDtoRequestModels = lessonModelRepository.saveAll(lessons);

        return new HashSet<>(savedLessonDtoRequestModels);
    }

    @Override
    public Optional<LessonDtoRequestModel> findById(int id) {
        return lessonModelRepository.findById(id); // Usando lambda para passar contexto
    }

    @Override
    public Set<LessonDtoRequestModel> findAll() {
        List<LessonDtoRequestModel> lessonDtoRequests = lessonModelRepository.findAll();

        return new HashSet<>(lessonDtoRequests);
    }

    @Override
    public void deleteById(int id) {
        lessonModelRepository.deleteById(id);
    }

}
