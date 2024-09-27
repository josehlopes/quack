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
    date = "2024-09-27T00:28:42-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.4 (Oracle Corporation)"
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
        statisticsDTO.setId( statistics.getId() );
        statisticsDTO.setStreakDays( statistics.getStreakDays() );
        statisticsDTO.setBestStreak( statistics.getBestStreak() );
        statisticsDTO.setUserLevel( statistics.getUserLevel() );
        statisticsDTO.setUserExperience( statistics.getUserExperience() );
        statisticsDTO.setChallengesCompleted( statistics.getChallengesCompleted() );
        statisticsDTO.setLessonsCompleted( statistics.getLessonsCompleted() );

        return statisticsDTO;
    }

    @Override
    public StatisticsEntity dtoToEntity(StatisticsDTO statisticsDTO) {
        if ( statisticsDTO == null ) {
            return null;
        }

        StatisticsEntity statisticsEntity = new StatisticsEntity();

        statisticsEntity.setUser( statisticsDTOToUserEntity( statisticsDTO ) );
        statisticsEntity.setId( statisticsDTO.getId() );
        statisticsEntity.setStreakDays( statisticsDTO.getStreakDays() );
        statisticsEntity.setBestStreak( statisticsDTO.getBestStreak() );
        statisticsEntity.setUserLevel( statisticsDTO.getUserLevel() );
        statisticsEntity.setUserExperience( statisticsDTO.getUserExperience() );
        statisticsEntity.setChallengesCompleted( statisticsDTO.getChallengesCompleted() );
        statisticsEntity.setLessonsCompleted( statisticsDTO.getLessonsCompleted() );

        return statisticsEntity;
    }

    @Override
    public StatisticsModel entityToModel(StatisticsEntity statistics) {
        if ( statistics == null ) {
            return null;
        }

        StatisticsModel statisticsModel = new StatisticsModel();

        statisticsModel.setUser( map( statisticsUserId1( statistics ) ) );
        statisticsModel.setId( statistics.getId() );
        statisticsModel.setStreakDays( statistics.getStreakDays() );
        statisticsModel.setBestStreak( statistics.getBestStreak() );
        statisticsModel.setUserLevel( statistics.getUserLevel() );
        statisticsModel.setUserExperience( statistics.getUserExperience() );
        statisticsModel.setChallengesCompleted( statistics.getChallengesCompleted() );
        statisticsModel.setLessonsCompleted( statistics.getLessonsCompleted() );

        return statisticsModel;
    }

    @Override
    public StatisticsEntity modelToEntity(StatisticsModel statisticsModel) {
        if ( statisticsModel == null ) {
            return null;
        }

        StatisticsEntity statisticsEntity = new StatisticsEntity();

        statisticsEntity.setUser( userModelToUserEntity( statisticsModel.getUser() ) );
        statisticsEntity.setId( statisticsModel.getId() );
        statisticsEntity.setStreakDays( statisticsModel.getStreakDays() );
        statisticsEntity.setBestStreak( statisticsModel.getBestStreak() );
        statisticsEntity.setUserLevel( statisticsModel.getUserLevel() );
        statisticsEntity.setUserExperience( statisticsModel.getUserExperience() );
        statisticsEntity.setChallengesCompleted( statisticsModel.getChallengesCompleted() );
        statisticsEntity.setLessonsCompleted( statisticsModel.getLessonsCompleted() );

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
}
