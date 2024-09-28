package com.thigas.quack.adapter.mapper;

import com.thigas.quack.adapter.dto.LessonDTO;
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
    date = "2024-09-28T12:33:09-0300",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.40.0.v20240919-1711, environment: Java 17.0.12 (Eclipse Adoptium)"
)
@Component
public class LessonMapperImpl implements LessonMapper {

    @Override
    public LessonDTO entityToDto(LessonEntity lesson) {
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
    public LessonEntity dtoToEntity(LessonDTO lessonDTO) {
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

    @Override
    public LessonEntity modelToEntity(LessonModel lessonModel) {
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

    @Override
    public LessonModel entityToModel(LessonEntity lesson) {
        if ( lesson == null ) {
            return null;
        }

        LessonModel lessonModel = new LessonModel();

        lessonModel.setDescription( lesson.getDescription() );
        lessonModel.setId( lesson.getId() );
        lessonModel.setImagePath( lesson.getImagePath() );
        lessonModel.setLanguage( lesson.getLanguage() );
        lessonModel.setSteps( stepEntitySetToStepModelSet( lesson.getSteps() ) );
        lessonModel.setTitle( lesson.getTitle() );

        return lessonModel;
    }

    @Override
    public LessonModel dtoToModel(LessonDTO lessonDTO) {
        if ( lessonDTO == null ) {
            return null;
        }

        LessonModel lessonModel = new LessonModel();

        lessonModel.setDescription( lessonDTO.getDescription() );
        lessonModel.setId( lessonDTO.getId() );
        lessonModel.setImagePath( lessonDTO.getImagePath() );
        lessonModel.setLanguage( lessonDTO.getLanguage() );
        lessonModel.setTitle( lessonDTO.getTitle() );

        return lessonModel;
    }

    @Override
    public LessonDTO modelToDto(LessonModel lessonModel) {
        if ( lessonModel == null ) {
            return null;
        }

        LessonDTO lessonDTO = new LessonDTO();

        lessonDTO.setDescription( lessonModel.getDescription() );
        lessonDTO.setId( lessonModel.getId() );
        lessonDTO.setImagePath( lessonModel.getImagePath() );
        lessonDTO.setLanguage( lessonModel.getLanguage() );
        lessonDTO.setTitle( lessonModel.getTitle() );

        return lessonDTO;
    }

    protected Set<LessonEntity> lessonModelSetToLessonEntitySet(Set<LessonModel> set) {
        if ( set == null ) {
            return null;
        }

        Set<LessonEntity> set1 = new LinkedHashSet<LessonEntity>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( LessonModel lessonModel : set ) {
            set1.add( modelToEntity( lessonModel ) );
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

    protected RoadmapEntity roadmapModelToRoadmapEntity(RoadmapModel roadmapModel) {
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

    protected Set<LessonModel> lessonEntitySetToLessonModelSet(Set<LessonEntity> set) {
        if ( set == null ) {
            return null;
        }

        Set<LessonModel> set1 = new LinkedHashSet<LessonModel>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( LessonEntity lessonEntity : set ) {
            set1.add( entityToModel( lessonEntity ) );
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

    protected RoadmapModel roadmapEntityToRoadmapModel(RoadmapEntity roadmapEntity) {
        if ( roadmapEntity == null ) {
            return null;
        }

        RoadmapModel roadmapModel = new RoadmapModel();

        roadmapModel.setDescription( roadmapEntity.getDescription() );
        roadmapModel.setId( roadmapEntity.getId() );
        roadmapModel.setImagePath( roadmapEntity.getImagePath() );
        roadmapModel.setStatus( roadmapEntity.getStatus() );
        roadmapModel.setSteps( stepEntitySetToStepModelSet( roadmapEntity.getSteps() ) );
        roadmapModel.setTitle( roadmapEntity.getTitle() );

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
}
