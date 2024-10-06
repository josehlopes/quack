package com.thigas.quack.adapter.mapper;

import com.thigas.quack.adapter.dto.LessonDTO;
import com.thigas.quack.domain.entity.LessonEntity;
import com.thigas.quack.domain.entity.StepEntity;
import com.thigas.quack.infrastructure.persistence.entity.LessonModel;
import com.thigas.quack.infrastructure.persistence.entity.StepModel;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor"
)
@Component
public class LessonMapperImpl implements LessonMapper {

    @Autowired
    private StepMapper stepMapper;

    @Override
    public LessonDTO entityToDto(LessonEntity lessonEntity, CycleAvoidingMappingContext context) {
        if ( lessonEntity == null ) {
            return null;
        }

        LessonDTO lessonDTO = new LessonDTO();

        lessonDTO.setSteps( stepMapper.stepEntityToIntegers( lessonEntity.getSteps(), context ) );
        lessonDTO.setId( lessonEntity.getId() );
        lessonDTO.setTitle( lessonEntity.getTitle() );
        lessonDTO.setDescription( lessonEntity.getDescription() );
        lessonDTO.setLanguage( lessonEntity.getLanguage() );
        lessonDTO.setImagePath( lessonEntity.getImagePath() );

        return lessonDTO;
    }

    @Override
    public LessonEntity dtoToEntity(LessonDTO lessonDTO, CycleAvoidingMappingContext context) {
        if ( lessonDTO == null ) {
            return null;
        }

        LessonEntity lessonEntity = new LessonEntity();

        lessonEntity.setSteps( stepMapper.integersToStepEntityId( lessonDTO.getSteps(), context ) );
        lessonEntity.setId( lessonDTO.getId() );
        lessonEntity.setTitle( lessonDTO.getTitle() );
        lessonEntity.setDescription( lessonDTO.getDescription() );
        lessonEntity.setLanguage( lessonDTO.getLanguage() );
        lessonEntity.setImagePath( lessonDTO.getImagePath() );

        return lessonEntity;
    }

    @Override
    public LessonModel entityToModel(LessonEntity lessonEntity, CycleAvoidingMappingContext context) {
        if ( lessonEntity == null ) {
            return null;
        }

        LessonModel lessonModel = new LessonModel();

        lessonModel.setSteps( stepEntitySetToStepModelSet( lessonEntity.getSteps(), context ) );
        lessonModel.setId( lessonEntity.getId() );
        lessonModel.setTitle( lessonEntity.getTitle() );
        lessonModel.setDescription( lessonEntity.getDescription() );
        lessonModel.setLanguage( lessonEntity.getLanguage() );
        lessonModel.setImagePath( lessonEntity.getImagePath() );

        return lessonModel;
    }

    @Override
    public LessonEntity modelToEntity(LessonModel lessonModel, CycleAvoidingMappingContext context) {
        if ( lessonModel == null ) {
            return null;
        }

        LessonEntity lessonEntity = new LessonEntity();

        lessonEntity.setSteps( stepModelSetToStepEntitySet( lessonModel.getSteps(), context ) );
        lessonEntity.setId( lessonModel.getId() );
        lessonEntity.setTitle( lessonModel.getTitle() );
        lessonEntity.setDescription( lessonModel.getDescription() );
        lessonEntity.setLanguage( lessonModel.getLanguage() );
        lessonEntity.setImagePath( lessonModel.getImagePath() );

        return lessonEntity;
    }

    @Override
    public LessonDTO modelToDto(LessonModel lessonModel, CycleAvoidingMappingContext context) {
        if ( lessonModel == null ) {
            return null;
        }

        LessonDTO lessonDTO = new LessonDTO();

        lessonDTO.setSteps( stepMapper.stepModelsToIntegers( lessonModel.getSteps() ) );
        lessonDTO.setId( lessonModel.getId() );
        lessonDTO.setTitle( lessonModel.getTitle() );
        lessonDTO.setDescription( lessonModel.getDescription() );
        lessonDTO.setLanguage( lessonModel.getLanguage() );
        lessonDTO.setImagePath( lessonModel.getImagePath() );

        return lessonDTO;
    }

    @Override
    public LessonModel dtoToModel(LessonDTO lessonDTO, CycleAvoidingMappingContext context) {
        if ( lessonDTO == null ) {
            return null;
        }

        LessonModel lessonModel = new LessonModel();

        lessonModel.setSteps( stepMapper.integersToStepModels( lessonDTO.getSteps(), context ) );
        lessonModel.setId( lessonDTO.getId() );
        lessonModel.setTitle( lessonDTO.getTitle() );
        lessonModel.setDescription( lessonDTO.getDescription() );
        lessonModel.setLanguage( lessonDTO.getLanguage() );
        lessonModel.setImagePath( lessonDTO.getImagePath() );

        return lessonModel;
    }

    protected Set<StepModel> stepEntitySetToStepModelSet(Set<StepEntity> set, CycleAvoidingMappingContext context) {
        if ( set == null ) {
            return null;
        }

        Set<StepModel> set1 = new LinkedHashSet<StepModel>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( StepEntity stepEntity : set ) {
            set1.add( stepMapper.entityToModel( stepEntity, context ) );
        }

        return set1;
    }

    protected Set<StepEntity> stepModelSetToStepEntitySet(Set<StepModel> set, CycleAvoidingMappingContext context) {
        if ( set == null ) {
            return null;
        }

        Set<StepEntity> set1 = new LinkedHashSet<StepEntity>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( StepModel stepModel : set ) {
            set1.add( stepMapper.modelToEntity( stepModel, context ) );
        }

        return set1;
    }
}
