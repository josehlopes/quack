package com.thigas.quack.adapter.mapper;

import com.thigas.quack.adapter.dto.LessonDTO;
import com.thigas.quack.domain.entity.LessonEntity;
import com.thigas.quack.infrastructure.persistence.entity.LessonModel;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-09-16T15:11:41-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.4 (Oracle Corporation)"
)
public class LessonMapperImpl implements LessonMapper {

    @Override
    public LessonModel EntityToModel(LessonEntity lesson) {
        if ( lesson == null ) {
            return null;
        }

        LessonModel lessonModel = new LessonModel();

        lessonModel.setId( lesson.getId() );
        lessonModel.setTitle( lesson.getTitle() );
        lessonModel.setDescription( lesson.getDescription() );
        lessonModel.setLanguage( lesson.getLanguage() );
        lessonModel.setImagePath( lesson.getImagePath() );

        return lessonModel;
    }

    @Override
    public LessonEntity ModelToEntity(LessonModel lessonModel) {
        if ( lessonModel == null ) {
            return null;
        }

        LessonEntity lessonEntity = new LessonEntity();

        lessonEntity.setId( lessonModel.getId() );
        lessonEntity.setTitle( lessonModel.getTitle() );
        lessonEntity.setDescription( lessonModel.getDescription() );
        lessonEntity.setLanguage( lessonModel.getLanguage() );
        lessonEntity.setImagePath( lessonModel.getImagePath() );

        return lessonEntity;
    }

    @Override
    public LessonDTO EntityToDto(LessonEntity lesson) {
        if ( lesson == null ) {
            return null;
        }

        LessonDTO lessonDTO = new LessonDTO();

        lessonDTO.setId( lesson.getId() );
        lessonDTO.setTitle( lesson.getTitle() );
        lessonDTO.setDescription( lesson.getDescription() );
        lessonDTO.setLanguage( lesson.getLanguage() );
        lessonDTO.setImagePath( lesson.getImagePath() );

        return lessonDTO;
    }

    @Override
    public LessonEntity DtoToEntity(LessonDTO lessonDTO) {
        if ( lessonDTO == null ) {
            return null;
        }

        LessonEntity lessonEntity = new LessonEntity();

        lessonEntity.setId( lessonDTO.getId() );
        lessonEntity.setTitle( lessonDTO.getTitle() );
        lessonEntity.setDescription( lessonDTO.getDescription() );
        lessonEntity.setLanguage( lessonDTO.getLanguage() );
        lessonEntity.setImagePath( lessonDTO.getImagePath() );

        return lessonEntity;
    }
}
