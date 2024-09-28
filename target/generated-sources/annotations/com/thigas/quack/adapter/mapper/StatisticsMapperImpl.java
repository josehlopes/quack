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
    date = "2024-09-28T12:33:13-0300",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.40.0.v20240919-1711, environment: Java 17.0.12 (Eclipse Adoptium)"
)
@Component
public class StatisticsMapperImpl implements StatisticsMapper {

    @Override
    public StatisticsDTO entityToDto(StatisticsEntity statistics) {
        if ( statistics == null ) {
            return null;
        }

        StatisticsDTO statisticsDTO = new StatisticsDTO();

        statisticsDTO.setUser( statisticsUserId( statistics ) );
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

    @Override
    public StatisticsModel dtoToModel(StatisticsDTO statisticsDTO) {
        if ( statisticsDTO == null ) {
            return null;
        }

        StatisticsModel statisticsModel = new StatisticsModel();

        statisticsModel.setUser( statisticsDTOToUserModel( statisticsDTO ) );
        statisticsModel.setBestStreak( statisticsDTO.getBestStreak() );
        statisticsModel.setChallengesCompleted( statisticsDTO.getChallengesCompleted() );
        statisticsModel.setId( statisticsDTO.getId() );
        statisticsModel.setLessonsCompleted( statisticsDTO.getLessonsCompleted() );
        statisticsModel.setStreakDays( statisticsDTO.getStreakDays() );
        statisticsModel.setUserExperience( statisticsDTO.getUserExperience() );
        statisticsModel.setUserLevel( statisticsDTO.getUserLevel() );

        return statisticsModel;
    }

    @Override
    public StatisticsDTO modelToDto(StatisticsModel statisticsModel) {
        if ( statisticsModel == null ) {
            return null;
        }

        StatisticsDTO statisticsDTO = new StatisticsDTO();

        statisticsDTO.setUser( statisticsModelUserId( statisticsModel ) );
        statisticsDTO.setBestStreak( statisticsModel.getBestStreak() );
        statisticsDTO.setChallengesCompleted( statisticsModel.getChallengesCompleted() );
        statisticsDTO.setId( statisticsModel.getId() );
        statisticsDTO.setLessonsCompleted( statisticsModel.getLessonsCompleted() );
        statisticsDTO.setStreakDays( statisticsModel.getStreakDays() );
        statisticsDTO.setUserExperience( statisticsModel.getUserExperience() );
        statisticsDTO.setUserLevel( statisticsModel.getUserLevel() );

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

    protected UserEntity statisticsDTOToUserEntity(StatisticsDTO statisticsDTO) {
        if ( statisticsDTO == null ) {
            return null;
        }

        UserEntity userEntity = new UserEntity();

        userEntity.setId( statisticsDTO.getUser() );

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

    protected UserModel statisticsDTOToUserModel(StatisticsDTO statisticsDTO) {
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
