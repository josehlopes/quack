package com.thigas.quack.adapter.mapper;

import com.thigas.quack.adapter.dto.TaskDTO;
import com.thigas.quack.domain.entity.LessonEntity;
import com.thigas.quack.domain.entity.RoadmapEntity;
import com.thigas.quack.domain.entity.StepEntity;
import com.thigas.quack.domain.entity.TaskEntity;
import com.thigas.quack.infrastructure.persistence.entity.LessonModel;
import com.thigas.quack.infrastructure.persistence.entity.RoadmapModel;
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
public class TaskMapperImpl implements TaskMapper {

    @Override
    public TaskDTO entityToDto(TaskEntity taskEntity) {
        if ( taskEntity == null ) {
            return null;
        }

        TaskDTO taskDTO = new TaskDTO();

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

        taskModel.setId( taskEntity.getId() );
        taskModel.setSteps( stepEntitySetToStepModelSet( taskEntity.getSteps() ) );
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

        taskEntity.setId( taskModel.getId() );
        taskEntity.setSteps( stepModelSetToStepEntitySet( taskModel.getSteps() ) );
        taskEntity.setDescription( taskModel.getDescription() );
        taskEntity.setImagePath( taskModel.getImagePath() );

        return taskEntity;
    }

    protected RoadmapModel roadmapEntityToRoadmapModel(RoadmapEntity roadmapEntity) {
        if ( roadmapEntity == null ) {
            return null;
        }

        RoadmapModel roadmapModel = new RoadmapModel();

        roadmapModel.setId( roadmapEntity.getId() );
        roadmapModel.setTitle( roadmapEntity.getTitle() );
        roadmapModel.setDescription( roadmapEntity.getDescription() );
        roadmapModel.setImagePath( roadmapEntity.getImagePath() );
        roadmapModel.setStatus( roadmapEntity.getStatus() );

        return roadmapModel;
    }

    protected Set<RoadmapModel> roadmapEntitySetToRoadmapModelSet(Set<RoadmapEntity> set) {
        if ( set == null ) {
            return null;
        }

        Set<RoadmapModel> set1 = new LinkedHashSet<RoadmapModel>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( RoadmapEntity roadmapEntity : set ) {
            set1.add( roadmapEntityToRoadmapModel( roadmapEntity ) );
        }

        return set1;
    }

    protected Set<TaskModel> taskEntitySetToTaskModelSet(Set<TaskEntity> set) {
        if ( set == null ) {
            return null;
        }

        Set<TaskModel> set1 = new LinkedHashSet<TaskModel>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( TaskEntity taskEntity : set ) {
            set1.add( entityToModel( taskEntity ) );
        }

        return set1;
    }

    protected Set<StepModel> stepEntitySetToStepModelSet(Set<StepEntity> set) {
        if ( set == null ) {
            return null;
        }

        Set<StepModel> set1 = new LinkedHashSet<StepModel>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( StepEntity stepEntity : set ) {
            set1.add( stepEntityToStepModel( stepEntity ) );
        }

        return set1;
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
        lessonModel.setSteps( stepEntitySetToStepModelSet( lessonEntity.getSteps() ) );

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

    protected StepModel stepEntityToStepModel(StepEntity stepEntity) {
        if ( stepEntity == null ) {
            return null;
        }

        StepModel stepModel = new StepModel();

        stepModel.setId( stepEntity.getId() );
        stepModel.setRoadmaps( roadmapEntitySetToRoadmapModelSet( stepEntity.getRoadmaps() ) );
        stepModel.setTasks( taskEntitySetToTaskModelSet( stepEntity.getTasks() ) );
        stepModel.setLessons( lessonEntitySetToLessonModelSet( stepEntity.getLessons() ) );
        stepModel.setDescription( stepEntity.getDescription() );
        stepModel.setImagePath( stepEntity.getImagePath() );
        stepModel.setStatus( stepEntity.getStatus() );

        return stepModel;
    }

    protected RoadmapEntity roadmapModelToRoadmapEntity(RoadmapModel roadmapModel) {
        if ( roadmapModel == null ) {
            return null;
        }

        RoadmapEntity roadmapEntity = new RoadmapEntity();

        roadmapEntity.setId( roadmapModel.getId() );
        roadmapEntity.setTitle( roadmapModel.getTitle() );
        roadmapEntity.setDescription( roadmapModel.getDescription() );
        roadmapEntity.setImagePath( roadmapModel.getImagePath() );
        roadmapEntity.setStatus( roadmapModel.getStatus() );

        return roadmapEntity;
    }

    protected Set<RoadmapEntity> roadmapModelSetToRoadmapEntitySet(Set<RoadmapModel> set) {
        if ( set == null ) {
            return null;
        }

        Set<RoadmapEntity> set1 = new LinkedHashSet<RoadmapEntity>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( RoadmapModel roadmapModel : set ) {
            set1.add( roadmapModelToRoadmapEntity( roadmapModel ) );
        }

        return set1;
    }

    protected Set<StepEntity> stepModelSetToStepEntitySet(Set<StepModel> set) {
        if ( set == null ) {
            return null;
        }

        Set<StepEntity> set1 = new LinkedHashSet<StepEntity>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( StepModel stepModel : set ) {
            set1.add( stepModelToStepEntity( stepModel ) );
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
        lessonEntity.setSteps( stepModelSetToStepEntitySet( lessonModel.getSteps() ) );

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

    protected Set<TaskEntity> taskModelSetToTaskEntitySet(Set<TaskModel> set) {
        if ( set == null ) {
            return null;
        }

        Set<TaskEntity> set1 = new LinkedHashSet<TaskEntity>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( TaskModel taskModel : set ) {
            set1.add( modelToEntity( taskModel ) );
        }

        return set1;
    }

    protected StepEntity stepModelToStepEntity(StepModel stepModel) {
        if ( stepModel == null ) {
            return null;
        }

        StepEntity stepEntity = new StepEntity();

        stepEntity.setId( stepModel.getId() );
        stepEntity.setRoadmaps( roadmapModelSetToRoadmapEntitySet( stepModel.getRoadmaps() ) );
        stepEntity.setLessons( lessonModelSetToLessonEntitySet( stepModel.getLessons() ) );
        stepEntity.setTasks( taskModelSetToTaskEntitySet( stepModel.getTasks() ) );
        stepEntity.setDescription( stepModel.getDescription() );
        stepEntity.setImagePath( stepModel.getImagePath() );
        stepEntity.setStatus( stepModel.getStatus() );

        return stepEntity;
    }
}
