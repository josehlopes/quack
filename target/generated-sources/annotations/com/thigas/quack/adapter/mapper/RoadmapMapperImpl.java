package com.thigas.quack.adapter.mapper;

import com.thigas.quack.adapter.dto.RoadmapDTO;
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
    date = "2024-09-28T12:33:12-0300",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.40.0.v20240919-1711, environment: Java 17.0.12 (Eclipse Adoptium)"
)
@Component
public class RoadmapMapperImpl implements RoadmapMapper {

    @Override
    public RoadmapDTO entityToDto(RoadmapEntity roadmap) {
        if ( roadmap == null ) {
            return null;
        }

        RoadmapDTO roadmapDTO = new RoadmapDTO();

        roadmapDTO.setStatus( statusToInt( roadmap.getStatus() ) );
        roadmapDTO.setDescription( roadmap.getDescription() );
        roadmapDTO.setId( roadmap.getId() );
        roadmapDTO.setImagePath( roadmap.getImagePath() );
        roadmapDTO.setTitle( roadmap.getTitle() );

        return roadmapDTO;
    }

    @Override
    public RoadmapEntity dtoToEntity(RoadmapDTO roadmapDTO) {
        if ( roadmapDTO == null ) {
            return null;
        }

        RoadmapEntity roadmapEntity = new RoadmapEntity();

        roadmapEntity.setStatus( intToStatus( roadmapDTO.getStatus() ) );
        roadmapEntity.setDescription( roadmapDTO.getDescription() );
        roadmapEntity.setId( roadmapDTO.getId() );
        roadmapEntity.setImagePath( roadmapDTO.getImagePath() );
        roadmapEntity.setTitle( roadmapDTO.getTitle() );

        return roadmapEntity;
    }

    @Override
    public RoadmapModel entityToModel(RoadmapEntity roadmap) {
        if ( roadmap == null ) {
            return null;
        }

        RoadmapModel roadmapModel = new RoadmapModel();

        roadmapModel.setDescription( roadmap.getDescription() );
        roadmapModel.setId( roadmap.getId() );
        roadmapModel.setImagePath( roadmap.getImagePath() );
        roadmapModel.setStatus( roadmap.getStatus() );
        roadmapModel.setSteps( stepEntitySetToStepModelSet( roadmap.getSteps() ) );
        roadmapModel.setTitle( roadmap.getTitle() );

        return roadmapModel;
    }

    @Override
    public RoadmapEntity modelToEntity(RoadmapModel roadmapModel) {
        if ( roadmapModel == null ) {
            return null;
        }

        RoadmapEntity roadmapEntity = new RoadmapEntity();

        roadmapEntity.setDescription( roadmapModel.getDescription() );
        roadmapEntity.setId( roadmapModel.getId() );
        roadmapEntity.setImagePath( roadmapModel.getImagePath() );
        roadmapEntity.setStatus( roadmapModel.getStatus() );
        roadmapEntity.setSteps( stepModelSetToStepEntitySet( roadmapModel.getSteps() ) );
        roadmapEntity.setTitle( roadmapModel.getTitle() );

        return roadmapEntity;
    }

    @Override
    public RoadmapModel dtoToModel(RoadmapDTO roadmapDTO) {
        if ( roadmapDTO == null ) {
            return null;
        }

        RoadmapModel roadmapModel = new RoadmapModel();

        roadmapModel.setStatus( intToStatus( roadmapDTO.getStatus() ) );
        roadmapModel.setDescription( roadmapDTO.getDescription() );
        roadmapModel.setId( roadmapDTO.getId() );
        roadmapModel.setImagePath( roadmapDTO.getImagePath() );
        roadmapModel.setTitle( roadmapDTO.getTitle() );

        return roadmapModel;
    }

    @Override
    public RoadmapDTO modelToDto(RoadmapModel roadmapModel) {
        if ( roadmapModel == null ) {
            return null;
        }

        RoadmapDTO roadmapDTO = new RoadmapDTO();

        roadmapDTO.setStatus( statusToInt( roadmapModel.getStatus() ) );
        roadmapDTO.setDescription( roadmapModel.getDescription() );
        roadmapDTO.setId( roadmapModel.getId() );
        roadmapDTO.setImagePath( roadmapModel.getImagePath() );
        roadmapDTO.setTitle( roadmapModel.getTitle() );

        return roadmapDTO;
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

        lessonModel.setDescription( lessonEntity.getDescription() );
        lessonModel.setId( lessonEntity.getId() );
        lessonModel.setImagePath( lessonEntity.getImagePath() );
        lessonModel.setLanguage( lessonEntity.getLanguage() );
        lessonModel.setSteps( stepEntitySetToStepModelSet( lessonEntity.getSteps() ) );
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

    protected Set<RoadmapModel> roadmapEntitySetToRoadmapModelSet(Set<RoadmapEntity> set) {
        if ( set == null ) {
            return null;
        }

        Set<RoadmapModel> set1 = new LinkedHashSet<RoadmapModel>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( RoadmapEntity roadmapEntity : set ) {
            set1.add( entityToModel( roadmapEntity ) );
        }

        return set1;
    }

    protected TaskModel taskEntityToTaskModel(TaskEntity taskEntity) {
        if ( taskEntity == null ) {
            return null;
        }

        TaskModel taskModel = new TaskModel();

        taskModel.setDescription( taskEntity.getDescription() );
        taskModel.setId( taskEntity.getId() );
        taskModel.setImagePath( taskEntity.getImagePath() );
        taskModel.setSteps( stepEntitySetToStepModelSet( taskEntity.getSteps() ) );

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

    protected StepModel stepEntityToStepModel(StepEntity stepEntity) {
        if ( stepEntity == null ) {
            return null;
        }

        StepModel stepModel = new StepModel();

        stepModel.setDescription( stepEntity.getDescription() );
        stepModel.setId( stepEntity.getId() );
        stepModel.setImagePath( stepEntity.getImagePath() );
        stepModel.setLessons( lessonEntitySetToLessonModelSet( stepEntity.getLessons() ) );
        stepModel.setRoadmaps( roadmapEntitySetToRoadmapModelSet( stepEntity.getRoadmaps() ) );
        stepModel.setStatus( stepEntity.getStatus() );
        stepModel.setTasks( taskEntitySetToTaskModelSet( stepEntity.getTasks() ) );

        return stepModel;
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

        lessonEntity.setDescription( lessonModel.getDescription() );
        lessonEntity.setId( lessonModel.getId() );
        lessonEntity.setImagePath( lessonModel.getImagePath() );
        lessonEntity.setLanguage( lessonModel.getLanguage() );
        lessonEntity.setSteps( stepModelSetToStepEntitySet( lessonModel.getSteps() ) );
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

    protected Set<RoadmapEntity> roadmapModelSetToRoadmapEntitySet(Set<RoadmapModel> set) {
        if ( set == null ) {
            return null;
        }

        Set<RoadmapEntity> set1 = new LinkedHashSet<RoadmapEntity>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( RoadmapModel roadmapModel : set ) {
            set1.add( modelToEntity( roadmapModel ) );
        }

        return set1;
    }

    protected TaskEntity taskModelToTaskEntity(TaskModel taskModel) {
        if ( taskModel == null ) {
            return null;
        }

        TaskEntity taskEntity = new TaskEntity();

        taskEntity.setDescription( taskModel.getDescription() );
        taskEntity.setId( taskModel.getId() );
        taskEntity.setImagePath( taskModel.getImagePath() );
        taskEntity.setSteps( stepModelSetToStepEntitySet( taskModel.getSteps() ) );

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

    protected StepEntity stepModelToStepEntity(StepModel stepModel) {
        if ( stepModel == null ) {
            return null;
        }

        StepEntity stepEntity = new StepEntity();

        stepEntity.setDescription( stepModel.getDescription() );
        stepEntity.setId( stepModel.getId() );
        stepEntity.setImagePath( stepModel.getImagePath() );
        stepEntity.setLessons( lessonModelSetToLessonEntitySet( stepModel.getLessons() ) );
        stepEntity.setRoadmaps( roadmapModelSetToRoadmapEntitySet( stepModel.getRoadmaps() ) );
        stepEntity.setStatus( stepModel.getStatus() );
        stepEntity.setTasks( taskModelSetToTaskEntitySet( stepModel.getTasks() ) );

        return stepEntity;
    }
}
