package com.thigas.quack.adapter.mapper;

import com.thigas.quack.adapter.dto.StepDTO;
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
public class StepMapperImpl implements StepMapper {

    @Autowired
    private RoadmapMapper roadmapMapper;
    @Autowired
    private LessonMapper lessonMapper;
    @Autowired
    private TaskMapper taskMapper;

    @Override
    public StepDTO entityToDto(StepEntity stepEntity, CycleAvoidingMappingContext context) {
        if ( stepEntity == null ) {
            return null;
        }

        StepDTO stepDTO = new StepDTO();

        stepDTO.setRoadmaps( roadmapMapper.roadmapEntityToIntegers( stepEntity.getRoadmaps(), context ) );
        stepDTO.setLessons( lessonMapper.lessonEntityToIntegers( stepEntity.getLessons(), context ) );
        stepDTO.setTasks( taskMapper.taskEntityToIntegers( stepEntity.getTasks(), context ) );
        stepDTO.setId( stepEntity.getId() );
        stepDTO.setDescription( stepEntity.getDescription() );
        stepDTO.setImagePath( stepEntity.getImagePath() );
        stepDTO.setStatus( roadmapMapper.statusValueToInteger( stepEntity.getStatus() ) );

        return stepDTO;
    }

    @Override
    public StepEntity dtoToEntity(StepDTO stepDTO, CycleAvoidingMappingContext context) {
        if ( stepDTO == null ) {
            return null;
        }

        StepEntity stepEntity = new StepEntity();

        stepEntity.setRoadmaps( roadmapMapper.integersToRoadmapEntityId( stepDTO.getRoadmaps(), context ) );
        stepEntity.setLessons( lessonMapper.integersToLessonEntityId( stepDTO.getLessons(), context ) );
        stepEntity.setTasks( taskMapper.integersToTaskEntityId( stepDTO.getTasks(), context ) );
        stepEntity.setId( stepDTO.getId() );
        stepEntity.setDescription( stepDTO.getDescription() );
        stepEntity.setImagePath( stepDTO.getImagePath() );
        stepEntity.setStatus( roadmapMapper.integerToStatusValue( stepDTO.getStatus() ) );

        return stepEntity;
    }

    @Override
    public StepModel entityToModel(StepEntity stepEntity, CycleAvoidingMappingContext context) {
        if ( stepEntity == null ) {
            return null;
        }

        StepModel stepModel = new StepModel();

        stepModel.setRoadmaps( roadmapEntitySetToRoadmapModelSet( stepEntity.getRoadmaps(), context ) );
        stepModel.setLessons( lessonEntitySetToLessonModelSet( stepEntity.getLessons(), context ) );
        stepModel.setTasks( taskEntitySetToTaskModelSet( stepEntity.getTasks(), context ) );
        stepModel.setId( stepEntity.getId() );
        stepModel.setDescription( stepEntity.getDescription() );
        stepModel.setImagePath( stepEntity.getImagePath() );
        stepModel.setStatus( stepEntity.getStatus() );

        return stepModel;
    }

    @Override
    public StepEntity modelToEntity(StepModel stepModel, CycleAvoidingMappingContext context) {
        if ( stepModel == null ) {
            return null;
        }

        StepEntity stepEntity = new StepEntity();

        stepEntity.setRoadmaps( roadmapModelSetToRoadmapEntitySet( stepModel.getRoadmaps(), context ) );
        stepEntity.setLessons( lessonModelSetToLessonEntitySet( stepModel.getLessons(), context ) );
        stepEntity.setTasks( taskModelSetToTaskEntitySet( stepModel.getTasks(), context ) );
        stepEntity.setId( stepModel.getId() );
        stepEntity.setDescription( stepModel.getDescription() );
        stepEntity.setImagePath( stepModel.getImagePath() );
        stepEntity.setStatus( stepModel.getStatus() );

        return stepEntity;
    }

    @Override
    public StepModel dtoToModel(StepDTO stepDTO, CycleAvoidingMappingContext context) {
        if ( stepDTO == null ) {
            return null;
        }

        StepModel stepModel = new StepModel();

        stepModel.setRoadmaps( roadmapMapper.integersToRoadmapModelId( stepDTO.getRoadmaps(), context ) );
        stepModel.setLessons( lessonMapper.integersToLessonModelId( stepDTO.getLessons(), context ) );
        stepModel.setTasks( taskMapper.integersToTaskModelId( stepDTO.getTasks(), context ) );
        stepModel.setId( stepDTO.getId() );
        stepModel.setDescription( stepDTO.getDescription() );
        stepModel.setImagePath( stepDTO.getImagePath() );
        stepModel.setStatus( roadmapMapper.integerToStatusValue( stepDTO.getStatus() ) );

        return stepModel;
    }

    @Override
    public StepDTO modelToDto(StepModel stepModel, CycleAvoidingMappingContext context) {
        if ( stepModel == null ) {
            return null;
        }

        StepDTO stepDTO = new StepDTO();

        stepDTO.setRoadmaps( roadmapMapper.roadmapModelToIntegers( stepModel.getRoadmaps(), context ) );
        stepDTO.setLessons( lessonMapper.lessonModelToIntegers( stepModel.getLessons(), context ) );
        stepDTO.setTasks( taskMapper.taskModelToIntegers( stepModel.getTasks(), context ) );
        stepDTO.setId( stepModel.getId() );
        stepDTO.setDescription( stepModel.getDescription() );
        stepDTO.setImagePath( stepModel.getImagePath() );
        stepDTO.setStatus( roadmapMapper.statusValueToInteger( stepModel.getStatus() ) );

        return stepDTO;
    }

    protected Set<RoadmapModel> roadmapEntitySetToRoadmapModelSet(Set<RoadmapEntity> set, CycleAvoidingMappingContext context) {
        if ( set == null ) {
            return null;
        }

        Set<RoadmapModel> set1 = new LinkedHashSet<RoadmapModel>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( RoadmapEntity roadmapEntity : set ) {
            set1.add( roadmapMapper.entityToModel( roadmapEntity, context ) );
        }

        return set1;
    }

    protected Set<LessonModel> lessonEntitySetToLessonModelSet(Set<LessonEntity> set, CycleAvoidingMappingContext context) {
        if ( set == null ) {
            return null;
        }

        Set<LessonModel> set1 = new LinkedHashSet<LessonModel>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( LessonEntity lessonEntity : set ) {
            set1.add( lessonMapper.entityToModel( lessonEntity, context ) );
        }

        return set1;
    }

    protected Set<TaskModel> taskEntitySetToTaskModelSet(Set<TaskEntity> set, CycleAvoidingMappingContext context) {
        if ( set == null ) {
            return null;
        }

        Set<TaskModel> set1 = new LinkedHashSet<TaskModel>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( TaskEntity taskEntity : set ) {
            set1.add( taskMapper.entityToModel( taskEntity, context ) );
        }

        return set1;
    }

    protected Set<RoadmapEntity> roadmapModelSetToRoadmapEntitySet(Set<RoadmapModel> set, CycleAvoidingMappingContext context) {
        if ( set == null ) {
            return null;
        }

        Set<RoadmapEntity> set1 = new LinkedHashSet<RoadmapEntity>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( RoadmapModel roadmapModel : set ) {
            set1.add( roadmapMapper.modelToEntity( roadmapModel, context ) );
        }

        return set1;
    }

    protected Set<LessonEntity> lessonModelSetToLessonEntitySet(Set<LessonModel> set, CycleAvoidingMappingContext context) {
        if ( set == null ) {
            return null;
        }

        Set<LessonEntity> set1 = new LinkedHashSet<LessonEntity>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( LessonModel lessonModel : set ) {
            set1.add( lessonMapper.modelToEntity( lessonModel, context ) );
        }

        return set1;
    }

    protected Set<TaskEntity> taskModelSetToTaskEntitySet(Set<TaskModel> set, CycleAvoidingMappingContext context) {
        if ( set == null ) {
            return null;
        }

        Set<TaskEntity> set1 = new LinkedHashSet<TaskEntity>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( TaskModel taskModel : set ) {
            set1.add( taskMapper.modelToEntity( taskModel, context ) );
        }

        return set1;
    }
}
