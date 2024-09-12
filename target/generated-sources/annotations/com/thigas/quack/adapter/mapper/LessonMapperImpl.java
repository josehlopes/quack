package com.thigas.quack.adapter.mapper;

import com.thigas.quack.adapter.dto.LessonDTO;
import com.thigas.quack.domain.entity.LessonEntity;
import com.thigas.quack.domain.entity.RoadmapEntity;
import com.thigas.quack.infrastructure.persistence.entity.LessonModel;
import com.thigas.quack.infrastructure.persistence.entity.RoadmapModel;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-09-12T17:15:28-0300",
    comments = "version: 1.6.0, compiler: Eclipse JDT (IDE) 3.39.0.v20240820-0604, environment: Java 17.0.12 (Eclipse Adoptium)"
)
public class LessonMapperImpl implements LessonMapper {

    @Override
    public LessonModel toLessonModel(LessonEntity lesson) {
        if ( lesson == null ) {
            return null;
        }

        LessonModel lessonModel = new LessonModel();

        lessonModel.setId( lesson.getId() );
        lessonModel.setTitle( lesson.getTitle() );
        lessonModel.setDescription( lesson.getDescription() );
        lessonModel.setLanguage( lesson.getLanguage() );
        lessonModel.setImagePath( lesson.getImagePath() );
        lessonModel.setRoadmaps( mapIdsToRoadmapModels( mapRoadmapsToIds( lesson.getRoadmaps() ) ) );

        return lessonModel;
    }

    @Override
    public LessonEntity toLesson(LessonModel lessonModel) {
        if ( lessonModel == null ) {
            return null;
        }

        LessonEntity lessonEntity = new LessonEntity();

        lessonEntity.setId( lessonModel.getId() );
        lessonEntity.setTitle( lessonModel.getTitle() );
        lessonEntity.setDescription( lessonModel.getDescription() );
        lessonEntity.setLanguage( lessonModel.getLanguage() );
        lessonEntity.setImagePath( lessonModel.getImagePath() );
        lessonEntity.setRoadmaps( roadmapModelSetToRoadmapEntitySet( lessonModel.getRoadmaps() ) );

        return lessonEntity;
    }

    @Override
    public LessonDTO toLessonDTO(LessonEntity lesson) {
        if ( lesson == null ) {
            return null;
        }

        LessonDTO lessonDTO = new LessonDTO();

        lessonDTO.setId( lesson.getId() );
        lessonDTO.setTitle( lesson.getTitle() );
        lessonDTO.setDescription( lesson.getDescription() );
        lessonDTO.setLanguage( lesson.getLanguage() );
        lessonDTO.setImagePath( lesson.getImagePath() );
        lessonDTO.setRoadmapIds( mapRoadmapsToIds( lesson.getRoadmaps() ) );

        return lessonDTO;
    }

    @Override
    public LessonEntity toLesson(LessonDTO lessonDTO) {
        if ( lessonDTO == null ) {
            return null;
        }

        LessonEntity lessonEntity = new LessonEntity();

        lessonEntity.setId( lessonDTO.getId() );
        lessonEntity.setTitle( lessonDTO.getTitle() );
        lessonEntity.setDescription( lessonDTO.getDescription() );
        lessonEntity.setLanguage( lessonDTO.getLanguage() );
        lessonEntity.setImagePath( lessonDTO.getImagePath() );
        lessonEntity.setRoadmaps( mapIdsToRoadmaps( lessonDTO.getRoadmapIds() ) );

        return lessonEntity;
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
}
