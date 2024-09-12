package com.thigas.quack.adapter.mapper;

import com.thigas.quack.adapter.dto.StatisticsDTO;
import com.thigas.quack.domain.entity.StatisticsEntity;
import com.thigas.quack.domain.entity.UserEntity;
import com.thigas.quack.infrastructure.persistence.entity.StatisticsModel;
import com.thigas.quack.infrastructure.persistence.entity.UserModel;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-09-12T17:15:58-0300",
    comments = "version: 1.6.0, compiler: Eclipse JDT (IDE) 3.39.0.v20240820-0604, environment: Java 17.0.12 (Eclipse Adoptium)"
)
public class StatisticsMapperImpl implements StatisticsMapper {

    @Override
    public StatisticsDTO toStatisticsDTO(StatisticsEntity statistics) {
        if ( statistics == null ) {
            return null;
        }

        StatisticsDTO statisticsDTO = new StatisticsDTO();

        statisticsDTO.setUserId( statisticsUserId( statistics ) );
        statisticsDTO.setBestStreak( statistics.getBestStreak() );
        statisticsDTO.setChallengesCompleted( statistics.getChallengesCompleted() );
        statisticsDTO.setId( statistics.getId() );
        statisticsDTO.setLessonsCompleted( statistics.getLessonsCompleted() );
        statisticsDTO.setStreakDays( statistics.getStreakDays() );
        statisticsDTO.setUserExperience( statistics.getUserExperience() );
        statisticsDTO.setUserLevel( statistics.getUserLevel() );

        return statisticsDTO;
    }

    @Override
    public StatisticsEntity toStatistics(StatisticsDTO statisticsDTO) {
        if ( statisticsDTO == null ) {
            return null;
        }

        StatisticsEntity statisticsEntity = new StatisticsEntity();

        statisticsEntity.setUser( statisticsDTOToUserEntity( statisticsDTO ) );
        statisticsEntity.setBestStreak( statisticsDTO.getBestStreak() );
        statisticsEntity.setChallengesCompleted( statisticsDTO.getChallengesCompleted() );
        statisticsEntity.setId( statisticsDTO.getId() );
        statisticsEntity.setLessonsCompleted( statisticsDTO.getLessonsCompleted() );
        statisticsEntity.setStreakDays( statisticsDTO.getStreakDays() );
        statisticsEntity.setUserExperience( statisticsDTO.getUserExperience() );
        statisticsEntity.setUserLevel( statisticsDTO.getUserLevel() );

        return statisticsEntity;
    }

    @Override
    public StatisticsModel toStatisticsModel(StatisticsEntity statistics) {
        if ( statistics == null ) {
            return null;
        }

        StatisticsModel statisticsModel = new StatisticsModel();

        statisticsModel.setUser( userEntityToUserModel( statistics.getUser() ) );
        statisticsModel.setChallengesCompleted( statistics.getChallengesCompleted() );
        statisticsModel.setId( statistics.getId() );
        statisticsModel.setLessonsCompleted( statistics.getLessonsCompleted() );
        statisticsModel.setUserExperience( statistics.getUserExperience() );
        statisticsModel.setUserLevel( statistics.getUserLevel() );
        statisticsModel.setbestStreak( statistics.getBestStreak() );
        statisticsModel.setstreakDays( statistics.getStreakDays() );

        return statisticsModel;
    }

    @Override
    public StatisticsEntity toStatistics(StatisticsModel statisticsModel) {
        if ( statisticsModel == null ) {
            return null;
        }

        StatisticsEntity statisticsEntity = new StatisticsEntity();

        statisticsEntity.setUser( userModelToUserEntity( statisticsModel.getUser() ) );
        statisticsEntity.setBestStreak( statisticsModel.getbestStreak() );
        statisticsEntity.setChallengesCompleted( statisticsModel.getChallengesCompleted() );
        statisticsEntity.setId( statisticsModel.getId() );
        statisticsEntity.setLessonsCompleted( statisticsModel.getLessonsCompleted() );
        statisticsEntity.setStreakDays( statisticsModel.getstreakDays() );
        statisticsEntity.setUserExperience( statisticsModel.getUserExperience() );
        statisticsEntity.setUserLevel( statisticsModel.getUserLevel() );

        return statisticsEntity;
    }

    private int statisticsUserId(StatisticsEntity statisticsEntity) {
        UserEntity user = statisticsEntity.getUser();
        if ( user == null ) {
            return 0;
        }
        return user.getId();
    }

    protected UserEntity statisticsDTOToUserEntity(StatisticsDTO statisticsDTO) {
        if ( statisticsDTO == null ) {
            return null;
        }

        UserEntity userEntity = new UserEntity();

        userEntity.setId( statisticsDTO.getUserId() );

        return userEntity;
    }

    protected UserModel userEntityToUserModel(UserEntity userEntity) {
        if ( userEntity == null ) {
            return null;
        }

        UserModel userModel = new UserModel();

        userModel.setId( userEntity.getId() );
        userModel.setBornAt( userEntity.getBornAt() );
        userModel.setCpf( userEntity.getCpf() );
        userModel.setEmail( userEntity.getEmail() );
        userModel.setImagePath( userEntity.getImagePath() );
        userModel.setName( userEntity.getName() );
        userModel.setPassword( userEntity.getPassword() );
        userModel.setPhone( userEntity.getPhone() );
        userModel.setPoints( userEntity.getPoints() );
        userModel.setRegisterAt( userEntity.getRegisterAt() );

        return userModel;
    }

    protected UserEntity userModelToUserEntity(UserModel userModel) {
        if ( userModel == null ) {
            return null;
        }

        UserEntity userEntity = new UserEntity();

        userEntity.setId( userModel.getId() );
        userEntity.setBornAt( userModel.getBornAt() );
        userEntity.setCpf( userModel.getCpf() );
        userEntity.setEmail( userModel.getEmail() );
        userEntity.setImagePath( userModel.getImagePath() );
        userEntity.setName( userModel.getName() );
        userEntity.setPassword( userModel.getPassword() );
        userEntity.setPhone( userModel.getPhone() );
        userEntity.setPoints( userModel.getPoints() );
        userEntity.setRegisterAt( userModel.getRegisterAt() );

        return userEntity;
    }
}
