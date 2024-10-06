package com.thigas.quack.adapter.mapper;

import com.thigas.quack.adapter.dto.StatisticsDTO;
import com.thigas.quack.domain.entity.StatisticsEntity;
import com.thigas.quack.domain.entity.UserEntity;
import com.thigas.quack.infrastructure.persistence.entity.StatisticsModel;
import com.thigas.quack.infrastructure.persistence.entity.UserModel;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor"
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
        statisticsEntity.setChallengesCompletedCount( statisticsDTO.getChallengesCompletedCount() );
        statisticsEntity.setRoadmapsCompletedCount( statisticsDTO.getRoadmapsCompletedCount() );

        return statisticsEntity;
    }

    @Override
    public StatisticsModel entityToModel(StatisticsEntity statistics) {
        if ( statistics == null ) {
            return null;
        }

        StatisticsModel statisticsModel = new StatisticsModel();

        statisticsModel.setId( statistics.getId() );
        statisticsModel.setUser( userEntityToUserModel( statistics.getUser() ) );
        statisticsModel.setStreakDays( statistics.getStreakDays() );
        statisticsModel.setBestStreak( statistics.getBestStreak() );
        statisticsModel.setUserLevel( statistics.getUserLevel() );
        statisticsModel.setUserExperience( statistics.getUserExperience() );
        statisticsModel.setChallengesCompletedCount( statistics.getChallengesCompletedCount() );
        statisticsModel.setRoadmapsCompletedCount( statistics.getRoadmapsCompletedCount() );

        return statisticsModel;
    }

    @Override
    public StatisticsEntity modelToEntity(StatisticsModel statisticsModel) {
        if ( statisticsModel == null ) {
            return null;
        }

        StatisticsEntity statisticsEntity = new StatisticsEntity();

        statisticsEntity.setId( statisticsModel.getId() );
        statisticsEntity.setUser( userModelToUserEntity( statisticsModel.getUser() ) );
        statisticsEntity.setStreakDays( statisticsModel.getStreakDays() );
        statisticsEntity.setBestStreak( statisticsModel.getBestStreak() );
        statisticsEntity.setUserLevel( statisticsModel.getUserLevel() );
        statisticsEntity.setUserExperience( statisticsModel.getUserExperience() );
        statisticsEntity.setChallengesCompletedCount( statisticsModel.getChallengesCompletedCount() );
        statisticsEntity.setRoadmapsCompletedCount( statisticsModel.getRoadmapsCompletedCount() );

        return statisticsEntity;
    }

    @Override
    public StatisticsModel dtoToModel(StatisticsDTO statisticsDTO) {
        if ( statisticsDTO == null ) {
            return null;
        }

        StatisticsModel statisticsModel = new StatisticsModel();

        statisticsModel.setUser( statisticsDTOToUserModel( statisticsDTO ) );
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
    public StatisticsDTO modelToDto(StatisticsModel statisticsModel) {
        if ( statisticsModel == null ) {
            return null;
        }

        StatisticsDTO statisticsDTO = new StatisticsDTO();

        statisticsDTO.setUser( statisticsModelUserId( statisticsModel ) );
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

    protected UserEntity statisticsDTOToUserEntity(StatisticsDTO statisticsDTO) {
        if ( statisticsDTO == null ) {
            return null;
        }

        UserEntity userEntity = new UserEntity();

        userEntity.setId( statisticsDTO.getUser() );

        return userEntity;
    }

    protected UserModel userEntityToUserModel(UserEntity userEntity) {
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
