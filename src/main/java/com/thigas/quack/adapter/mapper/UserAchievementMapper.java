//package com.thigas.quack.adapter.mapper;
//
//
//import com.thigas.quack.adapter.dto.UserAchievementDTO;
//import com.thigas.quack.domain.entity.UserAchievementEntity;
//import com.thigas.quack.infrastructure.persistence.entity.AchievementModel;
//import com.thigas.quack.infrastructure.persistence.entity.UserAchievementModel;
//import com.thigas.quack.infrastructure.persistence.entity.UserModel;
//import org.mapstruct.Mapper;
//import org.mapstruct.Mapping;
//
//@Mapper(uses = {UserMapper.class, AchievementMapper.class}, componentModel = "spring")
//public interface UserAchievementMapper {
//
//    @Mapping(source = "user.id", target = "user")
//    @Mapping(source = "achievement.id", target = "achievement")
//    UserAchievementDTO entityToDto(UserAchievementEntity userAchievementEntity);
//
//    @Mapping(source = "user", target = "user.id")
//    @Mapping(source = "achievement", target = "achievement.id")
//    UserAchievementEntity dtoToEntity(UserAchievementDTO userAchievementDTO);
//
//    @Mapping(source = "user.id", target = "user")
//    @Mapping(source = "achievement.id", target = "achievement")
//    UserAchievementModel entityToModel(UserAchievementEntity userAchievementEntity);
//
//    @Mapping(source = "user", target = "user.id")
//    @Mapping(source = "achievement", target = "achievement.id")
//    UserAchievementEntity modelToEntity(UserAchievementModel userAchievementModel);
//
//    @Mapping(source = "user", target = "user.id")
//    @Mapping(source = "achievement", target = "achievement.id")
//    UserAchievementModel dtoToModel(UserAchievementDTO userAchievementDTO);
//
//    @Mapping(source = "user.id", target = "user")
//    @Mapping(source = "achievement.id", target = "achievement")
//    UserAchievementDTO modelToDto(UserAchievementModel userAchievementModel);
//
//
//    default UserModel map(Integer user) {
//        if (user == null) {
//            return null;
//        }
//        UserModel userModel = new UserModel();
//        userModel.setId(user);
//        return userModel;
//    }
//
//    default Integer map(UserModel userModel) {
//        if (userModel == null) {
//            return null;
//        }
//        return userModel.getId();
//    }
//
//    default AchievementModel mapRoadmap(Integer achievement) {
//        if (achievement == null) {
//            return null;
//        }
//        AchievementModel achievementModel = new AchievementModel();
//        achievementModel.setId(achievement);
//        return achievementModel;
//    }
//
//    default Integer map(AchievementModel achievementModel) {
//        if (achievementModel == null) {
//            return null;
//        }
//        return achievementModel.getId();
//    }
//
//}
