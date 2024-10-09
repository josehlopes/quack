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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor"
)
@Component
public class TaskMapperImpl implements TaskMapper {

    @Autowired
    private DefaultMapper defaultMapper;

    @Override
    public TaskDTO entityToDto(TaskEntity taskEntity, CycleAvoidingMappingContext context) {
        if ( taskEntity == null ) {
            return null;
        }

        TaskDTO taskDTO = new TaskDTO();

        taskDTO.setSteps( defaultMapper.stepEntityToIntegers( taskEntity.getSteps(), context ) );
        taskDTO.setId( taskEntity.getId() );
        taskDTO.setDescription( taskEntity.getDescription() );
        taskDTO.setImagePath( taskEntity.getImagePath() );

        return taskDTO;
    }

    @Override
    public TaskEntity dtoToEntity(TaskDTO taskDTO, CycleAvoidingMappingContext context) {
        if ( taskDTO == null ) {
            return null;
        }

        TaskEntity taskEntity = new TaskEntity();

        taskEntity.setSteps( defaultMapper.integersToStepEntityId( taskDTO.getSteps(), context ) );
        taskEntity.setId( taskDTO.getId() );
        taskEntity.setDescription( taskDTO.getDescription() );
        taskEntity.setImagePath( taskDTO.getImagePath() );

        return taskEntity;
    }

    @Override
    public TaskModel entityToModel(TaskEntity taskEntity, CycleAvoidingMappingContext context) {
        if ( taskEntity == null ) {
            return null;
        }

        TaskModel taskModel = new TaskModel();

        taskModel.setSteps( stepEntitySetToStepModelSet( taskEntity.getSteps(), context ) );
        taskModel.setId( taskEntity.getId() );
        taskModel.setDescription( taskEntity.getDescription() );
        taskModel.setImagePath( taskEntity.getImagePath() );

        return taskModel;
    }

    @Override
    public TaskEntity modelToEntity(TaskModel taskModel, CycleAvoidingMappingContext context) {
        if ( taskModel == null ) {
            return null;
        }

        TaskEntity taskEntity = new TaskEntity();

        taskEntity.setSteps( stepModelSetToStepEntitySet( taskModel.getSteps(), context ) );
        taskEntity.setId( taskModel.getId() );
        taskEntity.setDescription( taskModel.getDescription() );
        taskEntity.setImagePath( taskModel.getImagePath() );

        return taskEntity;
    }

    @Override
    public TaskDTO modelToDto(TaskModel taskModel, CycleAvoidingMappingContext context) {
        if ( taskModel == null ) {
            return null;
        }

        TaskDTO taskDTO = new TaskDTO();

        taskDTO.setSteps( defaultMapper.stepModelsToIntegers( taskModel.getSteps() ) );
        taskDTO.setId( taskModel.getId() );
        taskDTO.setDescription( taskModel.getDescription() );
        taskDTO.setImagePath( taskModel.getImagePath() );

        return taskDTO;
    }

    @Override
    public TaskModel dtoToModel(TaskDTO taskDTO, CycleAvoidingMappingContext context) {
        if ( taskDTO == null ) {
            return null;
        }

        TaskModel taskModel = new TaskModel();

        taskModel.setSteps( defaultMapper.integersToStepModels( taskDTO.getSteps(), context ) );
        taskModel.setId( taskDTO.getId() );
        taskModel.setDescription( taskDTO.getDescription() );
        taskModel.setImagePath( taskDTO.getImagePath() );

        return taskModel;
    }

    protected Set<StepModel> stepEntitySetToStepModelSet(Set<StepEntity> set, CycleAvoidingMappingContext context) {
        if ( set == null ) {
            return null;
        }

        Set<StepModel> set1 = new LinkedHashSet<StepModel>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( StepEntity stepEntity : set ) {
            set1.add( stepEntityToStepModel( stepEntity, context ) );
        }

        return set1;
    }

    protected RoadmapModel roadmapEntityToRoadmapModel(RoadmapEntity roadmapEntity, CycleAvoidingMappingContext context) {
        if ( roadmapEntity == null ) {
            return null;
        }

        RoadmapModel roadmapModel = new RoadmapModel();

        roadmapModel.setId( roadmapEntity.getId() );
        roadmapModel.setTitle( roadmapEntity.getTitle() );
        roadmapModel.setDescription( roadmapEntity.getDescription() );
        roadmapModel.setImagePath( roadmapEntity.getImagePath() );
        roadmapModel.setSteps( stepEntitySetToStepModelSet( roadmapEntity.getSteps(), context ) );
        roadmapModel.setStatus( roadmapEntity.getStatus() );

        return roadmapModel;
    }

    protected Set<RoadmapModel> roadmapEntitySetToRoadmapModelSet(Set<RoadmapEntity> set, CycleAvoidingMappingContext context) {
        if ( set == null ) {
            return null;
        }

        Set<RoadmapModel> set1 = new LinkedHashSet<RoadmapModel>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( RoadmapEntity roadmapEntity : set ) {
            set1.add( roadmapEntityToRoadmapModel( roadmapEntity, context ) );
        }

        return set1;
    }

    protected Set<TaskModel> taskEntitySetToTaskModelSet(Set<TaskEntity> set, CycleAvoidingMappingContext context) {
        if ( set == null ) {
            return null;
        }

        Set<TaskModel> set1 = new LinkedHashSet<TaskModel>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( TaskEntity taskEntity : set ) {
            set1.add( entityToModel( taskEntity, context ) );
        }

        return set1;
    }

    protected LessonModel lessonEntityToLessonModel(LessonEntity lessonEntity, CycleAvoidingMappingContext context) {
        if ( lessonEntity == null ) {
            return null;
        }

        LessonModel lessonModel = new LessonModel();

        lessonModel.setId( lessonEntity.getId() );
        lessonModel.setTitle( lessonEntity.getTitle() );
        lessonModel.setDescription( lessonEntity.getDescription() );
        lessonModel.setLanguage( lessonEntity.getLanguage() );
        lessonModel.setImagePath( lessonEntity.getImagePath() );
        lessonModel.setSteps( stepEntitySetToStepModelSet( lessonEntity.getSteps(), context ) );

        return lessonModel;
    }

    protected Set<LessonModel> lessonEntitySetToLessonModelSet(Set<LessonEntity> set, CycleAvoidingMappingContext context) {
        if ( set == null ) {
            return null;
        }

        Set<LessonModel> set1 = new LinkedHashSet<LessonModel>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( LessonEntity lessonEntity : set ) {
            set1.add( lessonEntityToLessonModel( lessonEntity, context ) );
        }

        return set1;
    }

    protected StepModel stepEntityToStepModel(StepEntity stepEntity, CycleAvoidingMappingContext context) {
        if ( stepEntity == null ) {
            return null;
        }

        StepModel stepModel = new StepModel();

        stepModel.setId( stepEntity.getId() );
        stepModel.setRoadmaps( roadmapEntitySetToRoadmapModelSet( stepEntity.getRoadmaps(), context ) );
        stepModel.setTasks( taskEntitySetToTaskModelSet( stepEntity.getTasks(), context ) );
        stepModel.setLessons( lessonEntitySetToLessonModelSet( stepEntity.getLessons(), context ) );
        stepModel.setDescription( stepEntity.getDescription() );
        stepModel.setImagePath( stepEntity.getImagePath() );
        stepModel.setStatus( stepEntity.getStatus() );

        return stepModel;
    }

    protected Set<StepModel> stepEntitySetToStepModelSet(Set<StepEntity> set, CycleAvoidingMappingContext context) {
        if ( set == null ) {
            return null;
        }

        Set<StepModel> set1 = new LinkedHashSet<StepModel>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( StepEntity stepEntity : set ) {
            set1.add( stepEntityToStepModel( stepEntity, context ) );
        }

        return set1;
    }

    protected Set<StepEntity> stepModelSetToStepEntitySet(Set<StepModel> set, CycleAvoidingMappingContext context) {
        if ( set == null ) {
            return null;
        }

        Set<StepEntity> set1 = new LinkedHashSet<StepEntity>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( StepModel stepModel : set ) {
            set1.add( stepModelToStepEntity( stepModel, context ) );
        }

        return set1;
    }

    protected RoadmapEntity roadmapModelToRoadmapEntity(RoadmapModel roadmapModel, CycleAvoidingMappingContext context) {
        if ( roadmapModel == null ) {
            return null;
        }

        RoadmapEntity roadmapEntity = new RoadmapEntity();

        roadmapEntity.setId( roadmapModel.getId() );
        roadmapEntity.setTitle( roadmapModel.getTitle() );
        roadmapEntity.setDescription( roadmapModel.getDescription() );
        roadmapEntity.setImagePath( roadmapModel.getImagePath() );
        roadmapEntity.setStatus( roadmapModel.getStatus() );
        roadmapEntity.setSteps( stepModelSetToStepEntitySet( roadmapModel.getSteps(), context ) );

        return roadmapEntity;
    }

    protected Set<RoadmapEntity> roadmapModelSetToRoadmapEntitySet(Set<RoadmapModel> set, CycleAvoidingMappingContext context) {
        if ( set == null ) {
            return null;
        }

        Set<RoadmapEntity> set1 = new LinkedHashSet<RoadmapEntity>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( RoadmapModel roadmapModel : set ) {
            set1.add( roadmapModelToRoadmapEntity( roadmapModel, context ) );
        }

        return set1;
    }

    protected LessonEntity lessonModelToLessonEntity(LessonModel lessonModel, CycleAvoidingMappingContext context) {
        if ( lessonModel == null ) {
            return null;
        }

        LessonEntity lessonEntity = new LessonEntity();

        lessonEntity.setId( lessonModel.getId() );
        lessonEntity.setTitle( lessonModel.getTitle() );
        lessonEntity.setDescription( lessonModel.getDescription() );
        lessonEntity.setLanguage( lessonModel.getLanguage() );
        lessonEntity.setImagePath( lessonModel.getImagePath() );
        lessonEntity.setSteps( stepModelSetToStepEntitySet( lessonModel.getSteps(), context ) );

        return lessonEntity;
    }

    protected Set<LessonEntity> lessonModelSetToLessonEntitySet(Set<LessonModel> set, CycleAvoidingMappingContext context) {
        if ( set == null ) {
            return null;
        }

        Set<LessonEntity> set1 = new LinkedHashSet<LessonEntity>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( LessonModel lessonModel : set ) {
            set1.add( lessonModelToLessonEntity( lessonModel, context ) );
        }

        return set1;
    }

    protected Set<TaskEntity> taskModelSetToTaskEntitySet(Set<TaskModel> set, CycleAvoidingMappingContext context) {
        if ( set == null ) {
            return null;
        }

        Set<TaskEntity> set1 = new LinkedHashSet<TaskEntity>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( TaskModel taskModel : set ) {
            set1.add( modelToEntity( taskModel, context ) );
        }

        return set1;
    }

    protected StepEntity stepModelToStepEntity(StepModel stepModel, CycleAvoidingMappingContext context) {
        if ( stepModel == null ) {
            return null;
        }

        StepEntity stepEntity = new StepEntity();

        stepEntity.setId( stepModel.getId() );
        stepEntity.setRoadmaps( roadmapModelSetToRoadmapEntitySet( stepModel.getRoadmaps(), context ) );
        stepEntity.setLessons( lessonModelSetToLessonEntitySet( stepModel.getLessons(), context ) );
        stepEntity.setTasks( taskModelSetToTaskEntitySet( stepModel.getTasks(), context ) );
        stepEntity.setDescription( stepModel.getDescription() );
        stepEntity.setImagePath( stepModel.getImagePath() );
        stepEntity.setStatus( stepModel.getStatus() );

        return stepEntity;
    }

    protected Set<StepEntity> stepModelSetToStepEntitySet(Set<StepModel> set, CycleAvoidingMappingContext context) {
        if ( set == null ) {
            return null;
        }

        Set<StepEntity> set1 = new LinkedHashSet<StepEntity>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( StepModel stepModel : set ) {
            set1.add( stepModelToStepEntity( stepModel, context ) );
        }

        return set1;
    }
}
