package com.thigas.quack.adapter.mapper;

import com.thigas.quack.adapter.dto.StepDTO;
import com.thigas.quack.domain.entity.StepEntity;
import com.thigas.quack.infrastructure.persistence.entity.LessonModel;
import com.thigas.quack.infrastructure.persistence.entity.RoadmapModel;
import com.thigas.quack.infrastructure.persistence.entity.StepModel;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-09-13T11:47:14-0300",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.39.0.v20240820-0604, environment: Java 17.0.12 (Eclipse Adoptium)"
)
public class StepMapperImpl implements StepMapper {

    @Override
    public StepDTO EntityToDto(StepEntity stepEntity) {
        if ( stepEntity == null ) {
            return null;
        }

        StepDTO stepDTO = new StepDTO();

        stepDTO.setRoadmapIds( roadmapsToIds( stepEntity.getRoadmaps() ) );
        stepDTO.setLessonIds( lessonsToIds( stepEntity.getLessons() ) );
        stepDTO.setDescription( stepEntity.getDescription() );
        stepDTO.setId( stepEntity.getId() );

        return stepDTO;
    }

    @Override
    public StepEntity DtoToEntity(StepDTO stepDTO) {
        if ( stepDTO == null ) {
            return null;
        }

        StepEntity stepEntity = new StepEntity();

        stepEntity.setRoadmaps( idsToRoadmaps( stepDTO.getRoadmapIds() ) );
        stepEntity.setLessons( idsToLessons( stepDTO.getLessonIds() ) );
        stepEntity.setDescription( stepDTO.getDescription() );
        stepEntity.setId( stepDTO.getId() );

        return stepEntity;
    }

    @Override
    public StepModel EntityToModel(StepEntity stepEntity) {
        if ( stepEntity == null ) {
            return null;
        }

        StepModel stepModel = new StepModel();

        Set<RoadmapModel> set = stepEntity.getRoadmaps();
        if ( set != null ) {
            stepModel.setRoadmaps( new LinkedHashSet<RoadmapModel>( set ) );
        }
        Set<LessonModel> set1 = stepEntity.getLessons();
        if ( set1 != null ) {
            stepModel.setLessons( new LinkedHashSet<LessonModel>( set1 ) );
        }
        stepModel.setDescription( stepEntity.getDescription() );
        stepModel.setId( stepEntity.getId() );

        return stepModel;
    }

    @Override
    public StepEntity ModelToEntity(StepModel stepModel) {
        if ( stepModel == null ) {
            return null;
        }

        StepEntity stepEntity = new StepEntity();

        Set<RoadmapModel> set = stepModel.getRoadmaps();
        if ( set != null ) {
            stepEntity.setRoadmaps( new LinkedHashSet<RoadmapModel>( set ) );
        }
        Set<LessonModel> set1 = stepModel.getLessons();
        if ( set1 != null ) {
            stepEntity.setLessons( new LinkedHashSet<LessonModel>( set1 ) );
        }
        stepEntity.setDescription( stepModel.getDescription() );
        stepEntity.setId( stepModel.getId() );

        return stepEntity;
    }
}
