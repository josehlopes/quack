package com.thigas.quack.adapter.mapper;

import com.thigas.quack.adapter.dto.StepDTO;
import com.thigas.quack.domain.entity.StepEntity;
import com.thigas.quack.domain.entity.TaskEntity;
import com.thigas.quack.infrastructure.persistence.entity.StepModel;
import com.thigas.quack.infrastructure.persistence.entity.TaskModel;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-09-27T00:28:41-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.4 (Oracle Corporation)"
)
@Component
public class StepMapperImpl implements StepMapper {

    @Override
    public StepDTO entityToDto(StepEntity stepEntity) {
        if ( stepEntity == null ) {
            return null;
        }

        StepDTO stepDTO = new StepDTO();

        stepDTO.setRoadmapIds( roadmapsToIds( stepEntity.getRoadmaps() ) );
        stepDTO.setLessonIds( lessonsToIds( stepEntity.getLessons() ) );
        stepDTO.setStatus( statusToInt( stepEntity.getStatus() ) );
        stepDTO.setId( stepEntity.getId() );
        stepDTO.setDescription( stepEntity.getDescription() );
        stepDTO.setImagePath( stepEntity.getImagePath() );

        return stepDTO;
    }

    @Override
    public StepEntity dtoToEntity(StepDTO stepDTO) {
        if ( stepDTO == null ) {
            return null;
        }

        StepEntity stepEntity = new StepEntity();

        stepEntity.setRoadmaps( idsToRoadmaps( stepDTO.getRoadmapIds() ) );
        stepEntity.setLessons( idsToLessons( stepDTO.getLessonIds() ) );
        stepEntity.setStatus( intToStatus( stepDTO.getStatus() ) );
        stepEntity.setId( stepDTO.getId() );
        stepEntity.setDescription( stepDTO.getDescription() );
        stepEntity.setImagePath( stepDTO.getImagePath() );

        return stepEntity;
    }

    @Override
    public StepModel entityToModel(StepEntity stepEntity) {
        if ( stepEntity == null ) {
            return null;
        }

        StepModel stepModel = new StepModel();

        stepModel.setId( stepEntity.getId() );
        stepModel.setTasks( taskEntitySetToTaskModelSet( stepEntity.getTasks() ) );
        stepModel.setDescription( stepEntity.getDescription() );
        stepModel.setImagePath( stepEntity.getImagePath() );
        stepModel.setStatus( stepEntity.getStatus() );

        return stepModel;
    }

    @Override
    public StepEntity modelToEntity(StepModel stepModel) {
        if ( stepModel == null ) {
            return null;
        }

        StepEntity stepEntity = new StepEntity();

        stepEntity.setId( stepModel.getId() );
        stepEntity.setTasks( taskModelSetToTaskEntitySet( stepModel.getTasks() ) );
        stepEntity.setDescription( stepModel.getDescription() );
        stepEntity.setImagePath( stepModel.getImagePath() );
        stepEntity.setStatus( stepModel.getStatus() );

        return stepEntity;
    }

    protected Set<StepModel> stepEntitySetToStepModelSet(Set<StepEntity> set) {
        if ( set == null ) {
            return null;
        }

        Set<StepModel> set1 = new LinkedHashSet<StepModel>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( StepEntity stepEntity : set ) {
            set1.add( entityToModel( stepEntity ) );
        }

        return set1;
    }

    protected TaskModel taskEntityToTaskModel(TaskEntity taskEntity) {
        if ( taskEntity == null ) {
            return null;
        }

        TaskModel taskModel = new TaskModel();

        taskModel.setId( taskEntity.getId() );
        taskModel.setSteps( stepEntitySetToStepModelSet( taskEntity.getSteps() ) );
        taskModel.setDescription( taskEntity.getDescription() );
        taskModel.setImagePath( taskEntity.getImagePath() );

        return taskModel;
    }

    protected Set<TaskModel> taskEntitySetToTaskModelSet(Set<TaskEntity> set) {
        if ( set == null ) {
            return null;
        }

        Set<TaskModel> set1 = new LinkedHashSet<TaskModel>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( TaskEntity taskEntity : set ) {
            set1.add( taskEntityToTaskModel( taskEntity ) );
        }

        return set1;
    }

    protected Set<StepEntity> stepModelSetToStepEntitySet(Set<StepModel> set) {
        if ( set == null ) {
            return null;
        }

        Set<StepEntity> set1 = new LinkedHashSet<StepEntity>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( StepModel stepModel : set ) {
            set1.add( modelToEntity( stepModel ) );
        }

        return set1;
    }

    protected TaskEntity taskModelToTaskEntity(TaskModel taskModel) {
        if ( taskModel == null ) {
            return null;
        }

        TaskEntity taskEntity = new TaskEntity();

        taskEntity.setId( taskModel.getId() );
        taskEntity.setSteps( stepModelSetToStepEntitySet( taskModel.getSteps() ) );
        taskEntity.setDescription( taskModel.getDescription() );
        taskEntity.setImagePath( taskModel.getImagePath() );

        return taskEntity;
    }

    protected Set<TaskEntity> taskModelSetToTaskEntitySet(Set<TaskModel> set) {
        if ( set == null ) {
            return null;
        }

        Set<TaskEntity> set1 = new LinkedHashSet<TaskEntity>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( TaskModel taskModel : set ) {
            set1.add( taskModelToTaskEntity( taskModel ) );
        }

        return set1;
    }
}
