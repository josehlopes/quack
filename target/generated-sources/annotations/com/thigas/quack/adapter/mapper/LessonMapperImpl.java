package com.thigas.quack.adapter.mapper;

import com.thigas.quack.adapter.dto.LessonDTO;
import com.thigas.quack.domain.entity.Lesson;
import com.thigas.quack.domain.entity.Roadmap;
import com.thigas.quack.infrastructure.persistence.entity.LessonModel;
import com.thigas.quack.infrastructure.persistence.entity.RoadmapModel;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-09-12T11:29:30-0300",
    comments = "version: 1.6.0, compiler: Eclipse JDT (IDE) 3.39.0.v20240820-0604, environment: Java 17.0.12 (Eclipse Adoptium)"
)
public class LessonMapperImpl implements LessonMapper {

    @Override
    public LessonModel toLessonModel(Lesson lesson) {
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
    public Lesson toLesson(LessonModel lessonModel) {
        if ( lessonModel == null ) {
            return null;
        }

        Lesson lesson = new Lesson();

        lesson.setId( lessonModel.getId() );
        lesson.setTitle( lessonModel.getTitle() );
        lesson.setDescription( lessonModel.getDescription() );
        lesson.setLanguage( lessonModel.getLanguage() );
        lesson.setImagePath( lessonModel.getImagePath() );
        lesson.setRoadmaps( roadmapModelSetToRoadmapSet( lessonModel.getRoadmaps() ) );

        return lesson;
    }

    @Override
    public LessonDTO toLessonDTO(Lesson lesson) {
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
    public Lesson toLesson(LessonDTO lessonDTO) {
        if ( lessonDTO == null ) {
            return null;
        }

        Lesson lesson = new Lesson();

        lesson.setId( lessonDTO.getId() );
        lesson.setTitle( lessonDTO.getTitle() );
        lesson.setDescription( lessonDTO.getDescription() );
        lesson.setLanguage( lessonDTO.getLanguage() );
        lesson.setImagePath( lessonDTO.getImagePath() );
        lesson.setRoadmaps( mapIdsToRoadmaps( lessonDTO.getRoadmapIds() ) );

        return lesson;
    }

    protected Roadmap roadmapModelToRoadmap(RoadmapModel roadmapModel) {
        if ( roadmapModel == null ) {
            return null;
        }

        Roadmap roadmap = new Roadmap();

        roadmap.setDescription( roadmapModel.getDescription() );
        roadmap.setId( roadmapModel.getId() );
        roadmap.setImagePath( roadmapModel.getImagePath() );
        roadmap.setTitle( roadmapModel.getTitle() );

        return roadmap;
    }

    protected Set<Roadmap> roadmapModelSetToRoadmapSet(Set<RoadmapModel> set) {
        if ( set == null ) {
            return null;
        }

        Set<Roadmap> set1 = new LinkedHashSet<Roadmap>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( RoadmapModel roadmapModel : set ) {
            set1.add( roadmapModelToRoadmap( roadmapModel ) );
        }

        return set1;
    }
}
