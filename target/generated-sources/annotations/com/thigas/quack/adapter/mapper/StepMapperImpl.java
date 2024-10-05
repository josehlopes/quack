package com.thigas.quack.adapter.mapper;

import com.thigas.quack.adapter.dto.StepDTO;
import com.thigas.quack.domain.entity.StepEntity;
import com.thigas.quack.infrastructure.persistence.entity.StepModel;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-10-05T18:22:47-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.4 (Oracle Corporation)"
)
@Component
public class StepMapperImpl implements StepMapper {

    @Override
    public StepDTO entityToDto(StepEntity stepEntity, CycleAvoidingMappingContext context) {
        if ( stepEntity == null ) {
            return null;
        }

        StepDTO stepDTO = new StepDTO();

        stepDTO.setRoadmaps( roadmapEntityToIntegers( stepEntity.getRoadmaps(), context ) );
        stepDTO.setLessons( lessonEntityToIntegers( stepEntity.getLessons(), context ) );
        stepDTO.setTasks( taskEntityToIntegers( stepEntity.getTasks(), context ) );
        stepDTO.setId( stepEntity.getId() );
        stepDTO.setDescription( stepEntity.getDescription() );
        stepDTO.setImagePath( stepEntity.getImagePath() );
        stepDTO.setStatus( statusValueToInteger( stepEntity.getStatus() ) );

        return stepDTO;
    }

    @Override
    public StepEntity dtoToEntity(StepDTO stepDTO, CycleAvoidingMappingContext context) {
        if ( stepDTO == null ) {
            return null;
        }

        StepEntity stepEntity = new StepEntity();

        stepEntity.setRoadmaps( integersToRoadmapEntityId( stepDTO.getRoadmaps(), context ) );
        stepEntity.setLessons( integersToLessonEntityId( stepDTO.getLessons(), context ) );
        stepEntity.setTasks( integersToTaskEntityId( stepDTO.getTasks(), context ) );
        stepEntity.setId( stepDTO.getId() );
        stepEntity.setDescription( stepDTO.getDescription() );
        stepEntity.setImagePath( stepDTO.getImagePath() );
        stepEntity.setStatus( integerToStatusValue( stepDTO.getStatus() ) );

        return stepEntity;
    }

    @Override
    public StepModel entityToModel(StepEntity stepEntity, CycleAvoidingMappingContext context) {
        if ( stepEntity == null ) {
            return null;
        }

        StepModel stepModel = new StepModel();

        stepModel.setRoadmaps( integersToRoadmapModelId( roadmapEntityToIntegers( stepEntity.getRoadmaps(), context ), context ) );
        stepModel.setLessons( integersToLessonModelId( lessonEntityToIntegers( stepEntity.getLessons(), context ), context ) );
        stepModel.setTasks( integersToTaskModelId( taskEntityToIntegers( stepEntity.getTasks(), context ), context ) );
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

        stepEntity.setRoadmaps( integersToRoadmapEntityId( roadmapModelIdToIntegers( stepModel.getRoadmaps() ), context ) );
        stepEntity.setLessons( integersToLessonEntityId( lessonModelToIntegers( stepModel.getLessons(), context ), context ) );
        stepEntity.setTasks( integersToTaskEntityId( taskModelToIntegers( stepModel.getTasks(), context ), context ) );
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

        stepModel.setRoadmaps( integersToRoadmapModelId( stepDTO.getRoadmaps(), context ) );
        stepModel.setLessons( integersToLessonModelId( stepDTO.getLessons(), context ) );
        stepModel.setTasks( integersToTaskModelId( stepDTO.getTasks(), context ) );
        stepModel.setId( stepDTO.getId() );
        stepModel.setDescription( stepDTO.getDescription() );
        stepModel.setImagePath( stepDTO.getImagePath() );
        stepModel.setStatus( integerToStatusValue( stepDTO.getStatus() ) );

        return stepModel;
    }

    @Override
    public StepDTO modelToDto(StepModel stepModel, CycleAvoidingMappingContext context) {
        if ( stepModel == null ) {
            return null;
        }

        StepDTO stepDTO = new StepDTO();

        stepDTO.setRoadmaps( roadmapModelIdToIntegers( stepModel.getRoadmaps() ) );
        stepDTO.setLessons( lessonModelToIntegers( stepModel.getLessons(), context ) );
        stepDTO.setTasks( taskModelToIntegers( stepModel.getTasks(), context ) );
        stepDTO.setId( stepModel.getId() );
        stepDTO.setDescription( stepModel.getDescription() );
        stepDTO.setImagePath( stepModel.getImagePath() );
        stepDTO.setStatus( statusValueToInteger( stepModel.getStatus() ) );

        return stepDTO;
    }
}
