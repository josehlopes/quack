package com.thigas.quack.adapter.mapper;

import com.thigas.quack.adapter.dto.LessonDTO;
import com.thigas.quack.domain.entity.LessonEntity;
import com.thigas.quack.infrastructure.persistence.entity.LessonModel;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-10-01T00:04:23-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.4 (Oracle Corporation)"
)
@Component
public class LessonMapperImpl implements LessonMapper {

    @Override
    public LessonDTO entityToDto(LessonEntity lesson, CycleAvoidingMappingContext context) {
        if ( lesson == null ) {
            return null;
        }

        LessonDTO lessonDTO = new LessonDTO();

        lessonDTO.setSteps( stepEntityToIntegers( lesson.getSteps(), context ) );
        lessonDTO.setId( lesson.getId() );
        lessonDTO.setTitle( lesson.getTitle() );
        lessonDTO.setDescription( lesson.getDescription() );
        lessonDTO.setLanguage( lesson.getLanguage() );
        lessonDTO.setImagePath( lesson.getImagePath() );

        return lessonDTO;
    }

    @Override
    public LessonEntity dtoToEntity(LessonDTO lessonDTO, CycleAvoidingMappingContext context) {
        if ( lessonDTO == null ) {
            return null;
        }

        LessonEntity lessonEntity = new LessonEntity();

        lessonEntity.setSteps( integersToStepEntityId( lessonDTO.getSteps(), context ) );
        lessonEntity.setId( lessonDTO.getId() );
        lessonEntity.setTitle( lessonDTO.getTitle() );
        lessonEntity.setDescription( lessonDTO.getDescription() );
        lessonEntity.setLanguage( lessonDTO.getLanguage() );
        lessonEntity.setImagePath( lessonDTO.getImagePath() );

        return lessonEntity;
    }

    @Override
    public LessonEntity modelToEntity(LessonModel lessonModel, CycleAvoidingMappingContext context) {
        if ( lessonModel == null ) {
            return null;
        }

        LessonEntity lessonEntity = new LessonEntity();

        lessonEntity.setId( lessonModel.getId() );
        lessonEntity.setTitle( lessonModel.getTitle() );
        lessonEntity.setDescription( lessonModel.getDescription() );
        lessonEntity.setLanguage( lessonModel.getLanguage() );
        lessonEntity.setImagePath( lessonModel.getImagePath() );
        lessonEntity.setSteps( integersToStepEntityId( stepModelsToIntegers( lessonModel.getSteps() ), context ) );

        return lessonEntity;
    }

    @Override
    public LessonModel entityToModel(LessonEntity lesson, CycleAvoidingMappingContext context) {
        if ( lesson == null ) {
            return null;
        }

        LessonModel lessonModel = new LessonModel();

        lessonModel.setId( lesson.getId() );
        lessonModel.setTitle( lesson.getTitle() );
        lessonModel.setDescription( lesson.getDescription() );
        lessonModel.setLanguage( lesson.getLanguage() );
        lessonModel.setImagePath( lesson.getImagePath() );
        lessonModel.setSteps( integersToStepModels( stepEntityToIntegers( lesson.getSteps(), context ), context ) );

        return lessonModel;
    }

    @Override
    public LessonModel dtoToModel(LessonDTO lessonDTO, CycleAvoidingMappingContext context) {
        if ( lessonDTO == null ) {
            return null;
        }

        LessonModel lessonModel = new LessonModel();

        lessonModel.setSteps( integersToStepModels( lessonDTO.getSteps(), context ) );
        lessonModel.setId( lessonDTO.getId() );
        lessonModel.setTitle( lessonDTO.getTitle() );
        lessonModel.setDescription( lessonDTO.getDescription() );
        lessonModel.setLanguage( lessonDTO.getLanguage() );
        lessonModel.setImagePath( lessonDTO.getImagePath() );

        return lessonModel;
    }

    @Override
    public LessonDTO modelToDto(LessonModel lessonModel, CycleAvoidingMappingContext context) {
        if ( lessonModel == null ) {
            return null;
        }

        LessonDTO lessonDTO = new LessonDTO();

        lessonDTO.setSteps( stepModelsToIntegers( lessonModel.getSteps() ) );
        lessonDTO.setId( lessonModel.getId() );
        lessonDTO.setTitle( lessonModel.getTitle() );
        lessonDTO.setDescription( lessonModel.getDescription() );
        lessonDTO.setLanguage( lessonModel.getLanguage() );
        lessonDTO.setImagePath( lessonModel.getImagePath() );

        return lessonDTO;
    }
}
