package com.thigas.quack.adapter.mapper;

import com.thigas.quack.adapter.dto.TaskDTO;
import com.thigas.quack.domain.entity.LessonEntity;
import com.thigas.quack.domain.entity.TaskEntity;
import com.thigas.quack.infrastructure.persistence.entity.LessonModel;
import com.thigas.quack.infrastructure.persistence.entity.TaskModel;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-09-21T19:22:21-0300",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.39.0.v20240820-0604, environment: Java 17.0.12 (Eclipse Adoptium)"
)
@Component
public class TaskMapperImpl implements TaskMapper {

    @Override
    public TaskDTO entityToDto(TaskEntity taskEntity) {
        if ( taskEntity == null ) {
            return null;
        }

        TaskDTO taskDTO = new TaskDTO();

        taskDTO.setLessonIds( lessonsToIds( taskEntity.getLessons() ) );
        taskDTO.setDescription( taskEntity.getDescription() );
        taskDTO.setId( taskEntity.getId() );
        taskDTO.setImagePath( taskEntity.getImagePath() );

        return taskDTO;
    }

    @Override
    public TaskEntity dtoToEntity(TaskDTO taskDTO) {
        if ( taskDTO == null ) {
            return null;
        }

        TaskEntity taskEntity = new TaskEntity();

        taskEntity.setLessons( idsToLessons( taskDTO.getLessonIds() ) );
        taskEntity.setDescription( taskDTO.getDescription() );
        taskEntity.setId( taskDTO.getId() );
        taskEntity.setImagePath( taskDTO.getImagePath() );

        return taskEntity;
    }

    @Override
    public TaskModel entityToModel(TaskEntity taskEntity) {
        if ( taskEntity == null ) {
            return null;
        }

        TaskModel taskModel = new TaskModel();

        taskModel.setLessons( lessonEntitySetToLessonModelSet( taskEntity.getLessons() ) );
        taskModel.setDescription( taskEntity.getDescription() );
        taskModel.setId( taskEntity.getId() );
        taskModel.setImagePath( taskEntity.getImagePath() );

        return taskModel;
    }

    @Override
    public TaskEntity modelToEntity(TaskModel taskModel) {
        if ( taskModel == null ) {
            return null;
        }

        TaskEntity taskEntity = new TaskEntity();

        taskEntity.setLessons( lessonModelSetToLessonEntitySet( taskModel.getLessons() ) );
        taskEntity.setDescription( taskModel.getDescription() );
        taskEntity.setId( taskModel.getId() );
        taskEntity.setImagePath( taskModel.getImagePath() );

        return taskEntity;
    }

    protected LessonModel lessonEntityToLessonModel(LessonEntity lessonEntity) {
        if ( lessonEntity == null ) {
            return null;
        }

        LessonModel lessonModel = new LessonModel();

        lessonModel.setDescription( lessonEntity.getDescription() );
        lessonModel.setId( lessonEntity.getId() );
        lessonModel.setImagePath( lessonEntity.getImagePath() );
        lessonModel.setLanguage( lessonEntity.getLanguage() );
        lessonModel.setTitle( lessonEntity.getTitle() );

        return lessonModel;
    }

    protected Set<LessonModel> lessonEntitySetToLessonModelSet(Set<LessonEntity> set) {
        if ( set == null ) {
            return null;
        }

        Set<LessonModel> set1 = new LinkedHashSet<LessonModel>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( LessonEntity lessonEntity : set ) {
            set1.add( lessonEntityToLessonModel( lessonEntity ) );
        }

        return set1;
    }

    protected LessonEntity lessonModelToLessonEntity(LessonModel lessonModel) {
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

    protected Set<LessonEntity> lessonModelSetToLessonEntitySet(Set<LessonModel> set) {
        if ( set == null ) {
            return null;
        }

        Set<LessonEntity> set1 = new LinkedHashSet<LessonEntity>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( LessonModel lessonModel : set ) {
            set1.add( lessonModelToLessonEntity( lessonModel ) );
        }

        return set1;
    }
}
