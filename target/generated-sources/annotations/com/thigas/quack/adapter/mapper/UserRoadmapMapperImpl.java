package com.thigas.quack.adapter.mapper;

import com.thigas.quack.adapter.dto.UserRoadmapDTO;
import com.thigas.quack.domain.entity.LessonEntity;
import com.thigas.quack.domain.entity.RoadmapEntity;
import com.thigas.quack.domain.entity.StepEntity;
import com.thigas.quack.domain.entity.TaskEntity;
import com.thigas.quack.domain.entity.UserEntity;
import com.thigas.quack.domain.entity.UserRoadmapEntity;
import com.thigas.quack.infrastructure.persistence.entity.LessonModel;
import com.thigas.quack.infrastructure.persistence.entity.RoadmapModel;
import com.thigas.quack.infrastructure.persistence.entity.StepModel;
import com.thigas.quack.infrastructure.persistence.entity.TaskModel;
import com.thigas.quack.infrastructure.persistence.entity.UserModel;
import com.thigas.quack.infrastructure.persistence.entity.UserRoadmapModel;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor"
)
@Component
public class UserRoadmapMapperImpl implements UserRoadmapMapper {

    @Autowired
    private RoadmapMapper roadmapMapper;

    @Override
    public UserRoadmapDTO entityToDto(UserRoadmapEntity userRoadmapEntity, CycleAvoidingMappingContext context) {
        if ( userRoadmapEntity == null ) {
            return null;
        }

        UserRoadmapDTO userRoadmapDTO = new UserRoadmapDTO();

        userRoadmapDTO.setUser( userRoadmapEntityUserId( userRoadmapEntity ) );
        userRoadmapDTO.setRoadmap( userRoadmapEntityRoadmapId( userRoadmapEntity ) );
        userRoadmapDTO.setStatus( userRoadmapMapStatusToInteger( userRoadmapEntity.getStatus() ) );
        userRoadmapDTO.setId( userRoadmapEntity.getId() );
        userRoadmapDTO.setProgress( userRoadmapEntity.getProgress() );
        if ( userRoadmapEntity.getStartedAt() != null ) {
            userRoadmapDTO.setStartedAt( DateTimeFormatter.ISO_LOCAL_DATE.format( userRoadmapEntity.getStartedAt() ) );
        }
        if ( userRoadmapEntity.getFinishedAt() != null ) {
            userRoadmapDTO.setFinishedAt( DateTimeFormatter.ISO_LOCAL_DATE.format( userRoadmapEntity.getFinishedAt() ) );
        }

        return userRoadmapDTO;
    }

    @Override
    public UserRoadmapEntity dtoToEntity(UserRoadmapDTO userRoadmapDTO, CycleAvoidingMappingContext context) {
        if ( userRoadmapDTO == null ) {
            return null;
        }

        UserRoadmapEntity userRoadmapEntity = new UserRoadmapEntity();

        userRoadmapEntity.setUser( userRoadmapDTOToUserEntity( userRoadmapDTO, context ) );
        userRoadmapEntity.setRoadmap( userRoadmapDTOToRoadmapEntity( userRoadmapDTO, context ) );
        userRoadmapEntity.setStatus( userRoadmapMapIntegerToStatus( userRoadmapDTO.getStatus() ) );
        userRoadmapEntity.setId( userRoadmapDTO.getId() );
        userRoadmapEntity.setProgress( userRoadmapDTO.getProgress() );
        if ( userRoadmapDTO.getStartedAt() != null ) {
            userRoadmapEntity.setStartedAt( LocalDate.parse( userRoadmapDTO.getStartedAt() ) );
        }
        if ( userRoadmapDTO.getFinishedAt() != null ) {
            userRoadmapEntity.setFinishedAt( LocalDate.parse( userRoadmapDTO.getFinishedAt() ) );
        }

        return userRoadmapEntity;
    }

    @Override
    public UserRoadmapModel entityToModel(UserRoadmapEntity userRoadmapEntity, CycleAvoidingMappingContext context) {
        if ( userRoadmapEntity == null ) {
            return null;
        }

        UserRoadmapModel userRoadmapModel = new UserRoadmapModel();

        userRoadmapModel.setUser( userEntityToUserModel( userRoadmapEntity.getUser(), context ) );
        userRoadmapModel.setRoadmap( roadmapEntityToRoadmapModel( userRoadmapEntity.getRoadmap(), context ) );
        userRoadmapModel.setId( userRoadmapEntity.getId() );
        userRoadmapModel.setProgress( userRoadmapEntity.getProgress() );
        userRoadmapModel.setStartedAt( userRoadmapEntity.getStartedAt() );
        userRoadmapModel.setFinishedAt( userRoadmapEntity.getFinishedAt() );
        userRoadmapModel.setStatus( userRoadmapEntity.getStatus() );

        return userRoadmapModel;
    }

    @Override
    public UserRoadmapEntity modelToEntity(UserRoadmapModel userRoadmapModel, CycleAvoidingMappingContext context) {
        if ( userRoadmapModel == null ) {
            return null;
        }

        UserRoadmapEntity userRoadmapEntity = new UserRoadmapEntity();

        userRoadmapEntity.setUser( userModelToUserEntity( userRoadmapModel.getUser(), context ) );
        userRoadmapEntity.setRoadmap( roadmapModelToRoadmapEntity( userRoadmapModel.getRoadmap(), context ) );
        userRoadmapEntity.setId( userRoadmapModel.getId() );
        userRoadmapEntity.setProgress( userRoadmapModel.getProgress() );
        userRoadmapEntity.setStartedAt( userRoadmapModel.getStartedAt() );
        userRoadmapEntity.setFinishedAt( userRoadmapModel.getFinishedAt() );
        userRoadmapEntity.setStatus( userRoadmapModel.getStatus() );

        return userRoadmapEntity;
    }

    @Override
    public UserRoadmapModel dtoToModel(UserRoadmapDTO userRoadmapDTO, CycleAvoidingMappingContext context) {
        if ( userRoadmapDTO == null ) {
            return null;
        }

        UserRoadmapModel userRoadmapModel = new UserRoadmapModel();

        userRoadmapModel.setUser( userRoadmapDTOToUserModel( userRoadmapDTO, context ) );
        userRoadmapModel.setRoadmap( userRoadmapDTOToRoadmapModel( userRoadmapDTO, context ) );
        userRoadmapModel.setStatus( userRoadmapMapIntegerToStatus( userRoadmapDTO.getStatus() ) );
        userRoadmapModel.setId( userRoadmapDTO.getId() );
        userRoadmapModel.setProgress( userRoadmapDTO.getProgress() );
        if ( userRoadmapDTO.getStartedAt() != null ) {
            userRoadmapModel.setStartedAt( LocalDate.parse( userRoadmapDTO.getStartedAt() ) );
        }
        if ( userRoadmapDTO.getFinishedAt() != null ) {
            userRoadmapModel.setFinishedAt( LocalDate.parse( userRoadmapDTO.getFinishedAt() ) );
        }

        return userRoadmapModel;
    }

    @Override
    public UserRoadmapDTO modelToDto(UserRoadmapModel userRoadmapModel, CycleAvoidingMappingContext context) {
        if ( userRoadmapModel == null ) {
            return null;
        }

        UserRoadmapDTO userRoadmapDTO = new UserRoadmapDTO();

        userRoadmapDTO.setUser( userRoadmapModelUserId( userRoadmapModel ) );
        userRoadmapDTO.setRoadmap( userRoadmapModelRoadmapId( userRoadmapModel ) );
        userRoadmapDTO.setStatus( userRoadmapMapStatusToInteger( userRoadmapModel.getStatus() ) );
        userRoadmapDTO.setId( userRoadmapModel.getId() );
        userRoadmapDTO.setProgress( userRoadmapModel.getProgress() );
        if ( userRoadmapModel.getStartedAt() != null ) {
            userRoadmapDTO.setStartedAt( DateTimeFormatter.ISO_LOCAL_DATE.format( userRoadmapModel.getStartedAt() ) );
        }
        if ( userRoadmapModel.getFinishedAt() != null ) {
            userRoadmapDTO.setFinishedAt( DateTimeFormatter.ISO_LOCAL_DATE.format( userRoadmapModel.getFinishedAt() ) );
        }

        return userRoadmapDTO;
    }

    private int userRoadmapEntityUserId(UserRoadmapEntity userRoadmapEntity) {
        if ( userRoadmapEntity == null ) {
            return 0;
        }
        UserEntity user = userRoadmapEntity.getUser();
        if ( user == null ) {
            return 0;
        }
        int id = user.getId();
        return id;
    }

    private int userRoadmapEntityRoadmapId(UserRoadmapEntity userRoadmapEntity) {
        if ( userRoadmapEntity == null ) {
            return 0;
        }
        RoadmapEntity roadmap = userRoadmapEntity.getRoadmap();
        if ( roadmap == null ) {
            return 0;
        }
        int id = roadmap.getId();
        return id;
    }

    protected UserEntity userRoadmapDTOToUserEntity(UserRoadmapDTO userRoadmapDTO, CycleAvoidingMappingContext context) {
        if ( userRoadmapDTO == null ) {
            return null;
        }

        UserEntity userEntity = new UserEntity();

        userEntity.setId( userRoadmapDTO.getUser() );

        return userEntity;
    }

    protected RoadmapEntity userRoadmapDTOToRoadmapEntity(UserRoadmapDTO userRoadmapDTO, CycleAvoidingMappingContext context) {
        if ( userRoadmapDTO == null ) {
            return null;
        }

        RoadmapEntity roadmapEntity = new RoadmapEntity();

        roadmapEntity.setId( userRoadmapDTO.getRoadmap() );

        return roadmapEntity;
    }

    protected UserModel userEntityToUserModel(UserEntity userEntity, CycleAvoidingMappingContext context) {
        if ( userEntity == null ) {
            return null;
        }

        UserModel userModel = new UserModel();

        userModel.setId( userEntity.getId() );
        userModel.setName( userEntity.getName() );
        userModel.setUsername( userEntity.getUsername() );
        userModel.setPhone( userEntity.getPhone() );
        userModel.setEmail( userEntity.getEmail() );
        userModel.setPassword( userEntity.getPassword() );
        userModel.setCpf( userEntity.getCpf() );
        userModel.setBornAt( userEntity.getBornAt() );
        userModel.setPoints( userEntity.getPoints() );
        userModel.setRegisterAt( userEntity.getRegisterAt() );
        userModel.setStatus( userEntity.getStatus() );
        userModel.setImagePath( userEntity.getImagePath() );

        return userModel;
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

    protected TaskModel taskEntityToTaskModel(TaskEntity taskEntity, CycleAvoidingMappingContext context) {
        if ( taskEntity == null ) {
            return null;
        }

        TaskModel taskModel = new TaskModel();

        taskModel.setId( taskEntity.getId() );
        taskModel.setSteps( stepEntitySetToStepModelSet( taskEntity.getSteps(), context ) );
        taskModel.setDescription( taskEntity.getDescription() );
        taskModel.setImagePath( taskEntity.getImagePath() );

        return taskModel;
    }

    protected Set<TaskModel> taskEntitySetToTaskModelSet(Set<TaskEntity> set, CycleAvoidingMappingContext context) {
        if ( set == null ) {
            return null;
        }

        Set<TaskModel> set1 = new LinkedHashSet<TaskModel>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( TaskEntity taskEntity : set ) {
            set1.add( taskEntityToTaskModel( taskEntity, context ) );
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

    protected UserEntity userModelToUserEntity(UserModel userModel, CycleAvoidingMappingContext context) {
        if ( userModel == null ) {
            return null;
        }

        UserEntity userEntity = new UserEntity();

        userEntity.setId( userModel.getId() );
        userEntity.setName( userModel.getName() );
        userEntity.setUsername( userModel.getUsername() );
        userEntity.setPhone( userModel.getPhone() );
        userEntity.setEmail( userModel.getEmail() );
        userEntity.setPassword( userModel.getPassword() );
        userEntity.setCpf( userModel.getCpf() );
        userEntity.setBornAt( userModel.getBornAt() );
        userEntity.setPoints( userModel.getPoints() );
        userEntity.setRegisterAt( userModel.getRegisterAt() );
        userEntity.setImagePath( userModel.getImagePath() );
        userEntity.setStatus( userModel.getStatus() );

        return userEntity;
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

    protected TaskEntity taskModelToTaskEntity(TaskModel taskModel, CycleAvoidingMappingContext context) {
        if ( taskModel == null ) {
            return null;
        }

        TaskEntity taskEntity = new TaskEntity();

        taskEntity.setId( taskModel.getId() );
        taskEntity.setDescription( taskModel.getDescription() );
        taskEntity.setImagePath( taskModel.getImagePath() );
        taskEntity.setSteps( stepModelSetToStepEntitySet( taskModel.getSteps(), context ) );

        return taskEntity;
    }

    protected Set<TaskEntity> taskModelSetToTaskEntitySet(Set<TaskModel> set, CycleAvoidingMappingContext context) {
        if ( set == null ) {
            return null;
        }

        Set<TaskEntity> set1 = new LinkedHashSet<TaskEntity>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( TaskModel taskModel : set ) {
            set1.add( taskModelToTaskEntity( taskModel, context ) );
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

    protected UserModel userRoadmapDTOToUserModel(UserRoadmapDTO userRoadmapDTO, CycleAvoidingMappingContext context) {
        if ( userRoadmapDTO == null ) {
            return null;
        }

        UserModel userModel = new UserModel();

        userModel.setId( userRoadmapDTO.getUser() );

        return userModel;
    }

    protected RoadmapModel userRoadmapDTOToRoadmapModel(UserRoadmapDTO userRoadmapDTO, CycleAvoidingMappingContext context) {
        if ( userRoadmapDTO == null ) {
            return null;
        }

        RoadmapModel roadmapModel = new RoadmapModel();

        roadmapModel.setId( userRoadmapDTO.getRoadmap() );

        return roadmapModel;
    }

    private int userRoadmapModelUserId(UserRoadmapModel userRoadmapModel) {
        if ( userRoadmapModel == null ) {
            return 0;
        }
        UserModel user = userRoadmapModel.getUser();
        if ( user == null ) {
            return 0;
        }
        int id = user.getId();
        return id;
    }

    private int userRoadmapModelRoadmapId(UserRoadmapModel userRoadmapModel) {
        if ( userRoadmapModel == null ) {
            return 0;
        }
        RoadmapModel roadmap = userRoadmapModel.getRoadmap();
        if ( roadmap == null ) {
            return 0;
        }
        int id = roadmap.getId();
        return id;
    }
}
