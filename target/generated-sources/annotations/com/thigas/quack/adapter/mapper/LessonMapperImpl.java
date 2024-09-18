package com.thigas.quack.adapter.mapper;

import com.thigas.quack.adapter.dto.LessonDTO;
import com.thigas.quack.domain.entity.LessonEntity;
import com.thigas.quack.infrastructure.persistence.entity.LessonModel;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-09-18T11:57:35-0300",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.39.0.v20240820-0604, environment: Java 17.0.12 (Eclipse Adoptium)"
)
@Component
public class LessonMapperImpl implements LessonMapper {

    @Override
    public LessonModel EntityToModel(LessonEntity lesson) {
        if ( lesson == null ) {
            return null;
        }

        LessonModel lessonModel = new LessonModel();

        lessonModel.setDescription( lesson.getDescription() );
        lessonModel.setId( lesson.getId() );
        lessonModel.setImagePath( lesson.getImagePath() );
        lessonModel.setLanguage( lesson.getLanguage() );
        lessonModel.setTitle( lesson.getTitle() );

        return lessonModel;
    }

    @Override
    public LessonEntity ModelToEntity(LessonModel lessonModel) {
        if ( lessonModel == null ) {
            return null;
        }

        LessonEntity lessonEntity = new LessonEntity();

        lessonEntity.setDescription( lessonModel.getDescription() );
        lessonEntity.setId( lessonModel.getId() );
        lessonEntity.setImagePath( lessonModel.getImagePath() );
        lessonEntity.setLanguage( lessonModel.getLanguage() );
        lessonEntity.setTitle( lessonModel.getTitle() );

        return lessonEntity;
    }

    @Override
    public LessonDTO EntityToDto(LessonEntity lesson) {
        if ( lesson == null ) {
            return null;
        }

        LessonDTO lessonDTO = new LessonDTO();

        lessonDTO.setDescription( lesson.getDescription() );
        lessonDTO.setId( lesson.getId() );
        lessonDTO.setImagePath( lesson.getImagePath() );
        lessonDTO.setLanguage( lesson.getLanguage() );
        lessonDTO.setTitle( lesson.getTitle() );

        return lessonDTO;
    }

    @Override
    public LessonEntity DtoToEntity(LessonDTO lessonDTO) {
        if ( lessonDTO == null ) {
            return null;
        }

        LessonEntity lessonEntity = new LessonEntity();

        lessonEntity.setDescription( lessonDTO.getDescription() );
        lessonEntity.setId( lessonDTO.getId() );
        lessonEntity.setImagePath( lessonDTO.getImagePath() );
        lessonEntity.setLanguage( lessonDTO.getLanguage() );
        lessonEntity.setTitle( lessonDTO.getTitle() );

        return lessonEntity;
    }
}
