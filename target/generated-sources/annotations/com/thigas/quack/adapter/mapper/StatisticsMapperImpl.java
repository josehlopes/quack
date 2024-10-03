package com.thigas.quack.adapter.mapper;

import com.thigas.quack.adapter.dto.StatisticsDTO;
import com.thigas.quack.domain.entity.AchievementEntity;
import com.thigas.quack.domain.entity.StatisticsEntity;
import com.thigas.quack.domain.entity.UserAchievementEntity;
import com.thigas.quack.domain.entity.UserEntity;
import com.thigas.quack.infrastructure.persistence.entity.AchievementModel;
import com.thigas.quack.infrastructure.persistence.entity.StatisticsModel;
import com.thigas.quack.infrastructure.persistence.entity.UserAchievementModel;
import com.thigas.quack.infrastructure.persistence.entity.UserModel;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-10-03T01:18:06-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.4 (Oracle Corporation)"
)
@Component
public class StatisticsMapperImpl implements StatisticsMapper {

    @Override
    public StatisticsDTO entityToDto(StatisticsEntity statistics, CycleAvoidingMappingContext context) {
        if ( statistics == null ) {
            return null;
        }

        StatisticsDTO statisticsDTO = new StatisticsDTO();

        statisticsDTO.setUser( statisticsUserId( statistics ) );
        statisticsDTO.setRoadmapsCompleted( roadmapEntityToIntegers( statistics.getRoadmapsCompleted() ) );
        statisticsDTO.setStepsCompleted( stepEntityToIntegers( statistics.getStepsCompleted() ) );
        statisticsDTO.setId( statistics.getId() );
        statisticsDTO.setStreakDays( statistics.getStreakDays() );
        statisticsDTO.setBestStreak( statistics.getBestStreak() );
        statisticsDTO.setUserLevel( statistics.getUserLevel() );
        statisticsDTO.setUserExperience( statistics.getUserExperience() );
        statisticsDTO.setChallengesCompletedCount( statistics.getChallengesCompletedCount() );
        statisticsDTO.setRoadmapsCompletedCount( statistics.getRoadmapsCompletedCount() );

        return statisticsDTO;
    }

    @Override
    public StatisticsEntity dtoToEntity(StatisticsDTO statisticsDTO, CycleAvoidingMappingContext context) {
        if ( statisticsDTO == null ) {
            return null;
        }

        StatisticsEntity statisticsEntity = new StatisticsEntity();

        statisticsEntity.setUser( statisticsDTOToUserEntity( statisticsDTO, context ) );
        statisticsEntity.setRoadmapsCompleted( integersToRoadmapEntityId( statisticsDTO.getRoadmapsCompleted(), context ) );
        statisticsEntity.setStepsCompleted( integersToStepEntityId( statisticsDTO.getStepsCompleted(), context ) );
        statisticsEntity.setId( statisticsDTO.getId() );
        statisticsEntity.setStreakDays( statisticsDTO.getStreakDays() );
        statisticsEntity.setBestStreak( statisticsDTO.getBestStreak() );
        statisticsEntity.setUserLevel( statisticsDTO.getUserLevel() );
        statisticsEntity.setUserExperience( statisticsDTO.getUserExperience() );
        statisticsEntity.setChallengesCompletedCount( statisticsDTO.getChallengesCompletedCount() );
        statisticsEntity.setRoadmapsCompletedCount( statisticsDTO.getRoadmapsCompletedCount() );

        return statisticsEntity;
    }

    @Override
    public StatisticsModel entityToModel(StatisticsEntity statistics, CycleAvoidingMappingContext context) {
        if ( statistics == null ) {
            return null;
        }

        StatisticsModel statisticsModel = new StatisticsModel();

        statisticsModel.setUser( userEntityToUserModel( statistics.getUser(), context ) );
        statisticsModel.setRoadmapsCompleted( integersToRoadmapModelId( roadmapEntityToIntegers( statistics.getRoadmapsCompleted() ), context ) );
        statisticsModel.setStepsCompleted( integersToStepModelId( stepEntityToIntegers( statistics.getStepsCompleted() ), context ) );
        statisticsModel.setId( statistics.getId() );
        statisticsModel.setStreakDays( statistics.getStreakDays() );
        statisticsModel.setBestStreak( statistics.getBestStreak() );
        statisticsModel.setUserLevel( statistics.getUserLevel() );
        statisticsModel.setUserExperience( statistics.getUserExperience() );
        statisticsModel.setChallengesCompletedCount( statistics.getChallengesCompletedCount() );
        statisticsModel.setRoadmapsCompletedCount( statistics.getRoadmapsCompletedCount() );

        return statisticsModel;
    }

    @Override
    public StatisticsEntity modelToEntity(StatisticsModel statisticsModel, CycleAvoidingMappingContext context) {
        if ( statisticsModel == null ) {
            return null;
        }

        StatisticsEntity statisticsEntity = new StatisticsEntity();

        statisticsEntity.setUser( userModelToUserEntity( statisticsModel.getUser(), context ) );
        statisticsEntity.setRoadmapsCompleted( integersToRoadmapEntityId( roadmapModelIdToIntegers( statisticsModel.getRoadmapsCompleted() ), context ) );
        statisticsEntity.setStepsCompleted( integersToStepEntityId( stepModelIdToIntegers( statisticsModel.getStepsCompleted() ), context ) );
        statisticsEntity.setId( statisticsModel.getId() );
        statisticsEntity.setStreakDays( statisticsModel.getStreakDays() );
        statisticsEntity.setBestStreak( statisticsModel.getBestStreak() );
        statisticsEntity.setUserLevel( statisticsModel.getUserLevel() );
        statisticsEntity.setUserExperience( statisticsModel.getUserExperience() );
        statisticsEntity.setChallengesCompletedCount( statisticsModel.getChallengesCompletedCount() );
        statisticsEntity.setRoadmapsCompletedCount( statisticsModel.getRoadmapsCompletedCount() );

        return statisticsEntity;
    }

    @Override
    public StatisticsModel dtoToModel(StatisticsDTO statisticsDTO, CycleAvoidingMappingContext context) {
        if ( statisticsDTO == null ) {
            return null;
        }

        StatisticsModel statisticsModel = new StatisticsModel();

        statisticsModel.setUser( statisticsDTOToUserModel( statisticsDTO, context ) );
        statisticsModel.setRoadmapsCompleted( integersToRoadmapModelId( statisticsDTO.getRoadmapsCompleted(), context ) );
        statisticsModel.setStepsCompleted( integersToStepModelId( statisticsDTO.getStepsCompleted(), context ) );
        statisticsModel.setId( statisticsDTO.getId() );
        statisticsModel.setStreakDays( statisticsDTO.getStreakDays() );
        statisticsModel.setBestStreak( statisticsDTO.getBestStreak() );
        statisticsModel.setUserLevel( statisticsDTO.getUserLevel() );
        statisticsModel.setUserExperience( statisticsDTO.getUserExperience() );
        statisticsModel.setChallengesCompletedCount( statisticsDTO.getChallengesCompletedCount() );
        statisticsModel.setRoadmapsCompletedCount( statisticsDTO.getRoadmapsCompletedCount() );

        return statisticsModel;
    }

    @Override
    public StatisticsDTO modelToDto(StatisticsModel statisticsModel, CycleAvoidingMappingContext context) {
        if ( statisticsModel == null ) {
            return null;
        }

        StatisticsDTO statisticsDTO = new StatisticsDTO();

        statisticsDTO.setUser( statisticsModelUserId( statisticsModel ) );
        statisticsDTO.setRoadmapsCompleted( roadmapModelIdToIntegers( statisticsModel.getRoadmapsCompleted() ) );
        statisticsDTO.setStepsCompleted( stepModelIdToIntegers( statisticsModel.getStepsCompleted() ) );
        statisticsDTO.setId( statisticsModel.getId() );
        statisticsDTO.setStreakDays( statisticsModel.getStreakDays() );
        statisticsDTO.setBestStreak( statisticsModel.getBestStreak() );
        statisticsDTO.setUserLevel( statisticsModel.getUserLevel() );
        statisticsDTO.setUserExperience( statisticsModel.getUserExperience() );
        statisticsDTO.setChallengesCompletedCount( statisticsModel.getChallengesCompletedCount() );
        statisticsDTO.setRoadmapsCompletedCount( statisticsModel.getRoadmapsCompletedCount() );

        return statisticsDTO;
    }

    private int statisticsUserId(StatisticsEntity statisticsEntity) {
        if ( statisticsEntity == null ) {
            return 0;
        }
        UserEntity user = statisticsEntity.getUser();
        if ( user == null ) {
            return 0;
        }
        int id = user.getId();
        return id;
    }

    protected UserEntity statisticsDTOToUserEntity(StatisticsDTO statisticsDTO, CycleAvoidingMappingContext context) {
        if ( statisticsDTO == null ) {
            return null;
        }

        UserEntity userEntity = new UserEntity();

        userEntity.setId( statisticsDTO.getUser() );

        return userEntity;
    }

    protected Set<UserAchievementModel> userAchievementEntitySetToUserAchievementModelSet(Set<UserAchievementEntity> set, CycleAvoidingMappingContext context) {
        if ( set == null ) {
            return null;
        }

        Set<UserAchievementModel> set1 = new LinkedHashSet<UserAchievementModel>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( UserAchievementEntity userAchievementEntity : set ) {
            set1.add( userAchievementEntityToUserAchievementModel( userAchievementEntity, context ) );
        }

        return set1;
    }

    protected AchievementModel achievementEntityToAchievementModel(AchievementEntity achievementEntity, CycleAvoidingMappingContext context) {
        if ( achievementEntity == null ) {
            return null;
        }

        AchievementModel achievementModel = new AchievementModel();

        achievementModel.setId( achievementEntity.getId() );
        achievementModel.setName( achievementEntity.getName() );
        achievementModel.setDescription( achievementEntity.getDescription() );
        achievementModel.setImagePath( achievementEntity.getImagePath() );
        achievementModel.setUserAchievements( userAchievementEntitySetToUserAchievementModelSet( achievementEntity.getUserAchievements(), context ) );

        return achievementModel;
    }

    protected UserAchievementModel userAchievementEntityToUserAchievementModel(UserAchievementEntity userAchievementEntity, CycleAvoidingMappingContext context) {
        if ( userAchievementEntity == null ) {
            return null;
        }

        UserAchievementModel userAchievementModel = new UserAchievementModel();

        userAchievementModel.setId( userAchievementEntity.getId() );
        userAchievementModel.setUser( userEntityToUserModel( userAchievementEntity.getUser(), context ) );
        userAchievementModel.setAchievement( achievementEntityToAchievementModel( userAchievementEntity.getAchievement(), context ) );
        userAchievementModel.setEarnedAt( userAchievementEntity.getEarnedAt() );

        return userAchievementModel;
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
        userModel.setUserAchievements( userAchievementEntitySetToUserAchievementModelSet( userEntity.getUserAchievements(), context ) );

        return userModel;
    }

    protected Set<UserAchievementEntity> userAchievementModelSetToUserAchievementEntitySet(Set<UserAchievementModel> set, CycleAvoidingMappingContext context) {
        if ( set == null ) {
            return null;
        }

        Set<UserAchievementEntity> set1 = new LinkedHashSet<UserAchievementEntity>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( UserAchievementModel userAchievementModel : set ) {
            set1.add( userAchievementModelToUserAchievementEntity( userAchievementModel, context ) );
        }

        return set1;
    }

    protected AchievementEntity achievementModelToAchievementEntity(AchievementModel achievementModel, CycleAvoidingMappingContext context) {
        if ( achievementModel == null ) {
            return null;
        }

        AchievementEntity achievementEntity = new AchievementEntity();

        achievementEntity.setId( achievementModel.getId() );
        achievementEntity.setName( achievementModel.getName() );
        achievementEntity.setDescription( achievementModel.getDescription() );
        achievementEntity.setImagePath( achievementModel.getImagePath() );
        achievementEntity.setUserAchievements( userAchievementModelSetToUserAchievementEntitySet( achievementModel.getUserAchievements(), context ) );

        return achievementEntity;
    }

    protected UserAchievementEntity userAchievementModelToUserAchievementEntity(UserAchievementModel userAchievementModel, CycleAvoidingMappingContext context) {
        if ( userAchievementModel == null ) {
            return null;
        }

        UserAchievementEntity userAchievementEntity = new UserAchievementEntity();

        userAchievementEntity.setId( userAchievementModel.getId() );
        userAchievementEntity.setUser( userModelToUserEntity( userAchievementModel.getUser(), context ) );
        userAchievementEntity.setAchievement( achievementModelToAchievementEntity( userAchievementModel.getAchievement(), context ) );
        userAchievementEntity.setEarnedAt( userAchievementModel.getEarnedAt() );

        return userAchievementEntity;
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
        userEntity.setUserAchievements( userAchievementModelSetToUserAchievementEntitySet( userModel.getUserAchievements(), context ) );

        return userEntity;
    }

    protected UserModel statisticsDTOToUserModel(StatisticsDTO statisticsDTO, CycleAvoidingMappingContext context) {
        if ( statisticsDTO == null ) {
            return null;
        }

        UserModel userModel = new UserModel();

        userModel.setId( statisticsDTO.getUser() );

        return userModel;
    }

    private int statisticsModelUserId(StatisticsModel statisticsModel) {
        if ( statisticsModel == null ) {
            return 0;
        }
        UserModel user = statisticsModel.getUser();
        if ( user == null ) {
            return 0;
        }
        int id = user.getId();
        return id;
    }
}
