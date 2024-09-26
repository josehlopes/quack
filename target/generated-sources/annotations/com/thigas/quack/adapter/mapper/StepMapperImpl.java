package com.thigas.quack.adapter.mapper;

import com.thigas.quack.adapter.dto.StepDTO;
import com.thigas.quack.domain.entity.LessonEntity;
import com.thigas.quack.domain.entity.RoadmapEntity;
import com.thigas.quack.domain.entity.StepEntity;
import com.thigas.quack.infrastructure.persistence.entity.LessonModel;
import com.thigas.quack.infrastructure.persistence.entity.RoadmapModel;
import com.thigas.quack.infrastructure.persistence.entity.StepModel;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-09-25T22:32:29-0300",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.39.0.v20240820-0604, environment: Java 17.0.12 (Eclipse Adoptium)"
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
        stepDTO.setDescription( stepEntity.getDescription() );
        stepDTO.setId( stepEntity.getId() );
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
        stepEntity.setDescription( stepDTO.getDescription() );
        stepEntity.setId( stepDTO.getId() );
        stepEntity.setImagePath( stepDTO.getImagePath() );

        return stepEntity;
    }

    @Override
    public StepModel entityToModel(StepEntity stepEntity) {
        if ( stepEntity == null ) {
            return null;
        }

        StepModel stepModel = new StepModel();

        stepModel.setRoadmaps( roadmapEntitySetToRoadmapModelSet( stepEntity.getRoadmaps() ) );
        stepModel.setLessons( lessonEntitySetToLessonModelSet( stepEntity.getLessons() ) );
        stepModel.setDescription( stepEntity.getDescription() );
        stepModel.setId( stepEntity.getId() );
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

        stepEntity.setRoadmaps( roadmapModelSetToRoadmapEntitySet( stepModel.getRoadmaps() ) );
        stepEntity.setLessons( lessonModelSetToLessonEntitySet( stepModel.getLessons() ) );
        stepEntity.setDescription( stepModel.getDescription() );
        stepEntity.setId( stepModel.getId() );
        stepEntity.setImagePath( stepModel.getImagePath() );
        stepEntity.setStatus( stepModel.getStatus() );

        return stepEntity;
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

    protected RoadmapEntity roadmapModelToRoadmapEntity(RoadmapModel roadmapModel) {
        if ( roadmapModel == null ) {
            return null;
        }

        RoadmapEntity roadmapEntity = new RoadmapEntity();

        roadmapEntity.setDescription( roadmapModel.getDescription() );
        roadmapEntity.setId( roadmapModel.getId() );
        roadmapEntity.setImagePath( roadmapModel.getImagePath() );
        roadmapEntity.setStatus( roadmapModel.getStatus() );
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
