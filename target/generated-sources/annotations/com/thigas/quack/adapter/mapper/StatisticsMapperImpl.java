package com.thigas.quack.adapter.mapper;

import com.thigas.quack.adapter.dto.StatisticsDTO;
import com.thigas.quack.domain.entity.StatisticsEntity;
import com.thigas.quack.domain.entity.UserEntity;
import com.thigas.quack.infrastructure.persistence.entity.StatisticsModel;
import com.thigas.quack.infrastructure.persistence.entity.UserModel;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-09-25T22:32:28-0300",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.39.0.v20240820-0604, environment: Java 17.0.12 (Eclipse Adoptium)"
)
@Component
public class StatisticsMapperImpl implements StatisticsMapper {

    @Override
    public StatisticsDTO entityToDto(StatisticsEntity statistics) {
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
    public StatisticsEntity dtoToEntity(StatisticsDTO statisticsDTO) {
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
    public StatisticsModel entityToModel(StatisticsEntity statistics) {
        if ( statistics == null ) {
            return null;
        }

        StatisticsModel statisticsModel = new StatisticsModel();

        statisticsModel.setUser( map( statisticsUserId1( statistics ) ) );
        statisticsModel.setBestStreak( statistics.getBestStreak() );
        statisticsModel.setChallengesCompleted( statistics.getChallengesCompleted() );
        statisticsModel.setId( statistics.getId() );
        statisticsModel.setLessonsCompleted( statistics.getLessonsCompleted() );
        statisticsModel.setStreakDays( statistics.getStreakDays() );
        statisticsModel.setUserExperience( statistics.getUserExperience() );
        statisticsModel.setUserLevel( statistics.getUserLevel() );

        return statisticsModel;
    }

    @Override
    public StatisticsEntity modelToEntity(StatisticsModel statisticsModel) {
        if ( statisticsModel == null ) {
            return null;
        }

        StatisticsEntity statisticsEntity = new StatisticsEntity();

        statisticsEntity.setUser( userModelToUserEntity( statisticsModel.getUser() ) );
        statisticsEntity.setBestStreak( statisticsModel.getBestStreak() );
        statisticsEntity.setChallengesCompleted( statisticsModel.getChallengesCompleted() );
        statisticsEntity.setId( statisticsModel.getId() );
        statisticsEntity.setLessonsCompleted( statisticsModel.getLessonsCompleted() );
        statisticsEntity.setStreakDays( statisticsModel.getStreakDays() );
        statisticsEntity.setUserExperience( statisticsModel.getUserExperience() );
        statisticsEntity.setUserLevel( statisticsModel.getUserLevel() );

        return statisticsEntity;
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

    protected UserEntity statisticsDTOToUserEntity(StatisticsDTO statisticsDTO) {
        if ( statisticsDTO == null ) {
            return null;
        }

        UserEntity userEntity = new UserEntity();

        userEntity.setId( statisticsDTO.getUserId() );

        return userEntity;
    }

    private Integer statisticsUserId1(StatisticsEntity statisticsEntity) {
        if ( statisticsEntity == null ) {
            return null;
        }
        UserEntity user = statisticsEntity.getUser();
        if ( user == null ) {
            return null;
        }
        int id = user.getId();
        return id;
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
        userEntity.setStatus( userModel.getStatus() );
        userEntity.setUsername( userModel.getUsername() );

        return userEntity;
    }
}
