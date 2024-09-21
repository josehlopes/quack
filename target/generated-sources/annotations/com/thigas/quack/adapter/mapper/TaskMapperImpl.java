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
    date = "2024-09-21T00:20:48-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.4 (Oracle Corporation)"
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
        taskDTO.setId( taskEntity.getId() );
        taskDTO.setDescription( taskEntity.getDescription() );
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
        taskEntity.setId( taskDTO.getId() );
        taskEntity.setDescription( taskDTO.getDescription() );
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
        taskModel.setId( taskEntity.getId() );
        taskModel.setDescription( taskEntity.getDescription() );
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
        taskEntity.setId( taskModel.getId() );
        taskEntity.setDescription( taskModel.getDescription() );
        taskEntity.setImagePath( taskModel.getImagePath() );

        return taskEntity;
    }

    protected LessonModel lessonEntityToLessonModel(LessonEntity lessonEntity) {
        if ( lessonEntity == null ) {
            return null;
        }

        LessonModel lessonModel = new LessonModel();

        lessonModel.setId( lessonEntity.getId() );
        lessonModel.setTitle( lessonEntity.getTitle() );
        lessonModel.setDescription( lessonEntity.getDescription() );
        lessonModel.setLanguage( lessonEntity.getLanguage() );
        lessonModel.setImagePath( lessonEntity.getImagePath() );

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

        lessonEntity.setId( lessonModel.getId() );
        lessonEntity.setTitle( lessonModel.getTitle() );
        lessonEntity.setDescription( lessonModel.getDescription() );
        lessonEntity.setLanguage( lessonModel.getLanguage() );
        lessonEntity.setImagePath( lessonModel.getImagePath() );

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
