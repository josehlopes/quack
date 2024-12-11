package com.thigas.quack.Adapter.Repository;

import com.thigas.quack.Adapter.Entity.UserDataMapper;
import com.thigas.quack.Adapter.Entity.UserFollowersAndFollowingDataMapper;
import jakarta.persistence.EntityManager;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@AllArgsConstructor
public class UserRelationshipRepository {
    
    private static final Logger logger = LoggerFactory.getLogger(UserRelationshipRepository.class);
    private final EntityManager entityManager;
    
    @Transactional
    public void saveFollowing(UserFollowersAndFollowingDataMapper userFollowing) {
        try {
            entityManager.persist(userFollowing);
        } catch (Exception e) {
            logger.error("Error saving following relationship: {}", e.getMessage(), e);
        }
    }
    
    @Transactional
    public void saveFollower(UserFollowersAndFollowingDataMapper userFollower) {
        try {
            entityManager.persist(userFollower);
        } catch (Exception e) {
            logger.error("Error saving follower relationship: {}", e.getMessage(), e);
        }
    }
    
    @Transactional
    public void updateFollower(UserFollowersAndFollowingDataMapper userFollower) {
        try {
            entityManager.merge(userFollower);
        } catch (Exception e) {
            logger.error("Error updating follower relationship: {}", e.getMessage(), e);
        }
    }
    
    @Transactional
    public UserFollowersAndFollowingDataMapper findRelationship(Integer followedId, Integer followerId) {
        try {
            return entityManager.createQuery("SELECT uf FROM UserFollowersAndFollowingDataMapper uf WHERE uf.followed.id = :followedId AND uf.follower.id = :followerId", UserFollowersAndFollowingDataMapper.class)
                    .setParameter("followedId", followedId)
                    .setParameter("followerId", followerId)
                    .getSingleResult();
        } catch (Exception e) {
            logger.error("Error finding follower relationship: {}", e.getMessage(), e);
            return null;
        }
    }
    
    @Transactional
    public List<UserDataMapper> getAllFollowers(Integer userId) {
        try {
            return entityManager.createQuery(
                            "SELECT uf.follower FROM UserFollowersAndFollowingDataMapper uf WHERE uf.followed.id = :userId AND uf.isActive = true", UserDataMapper.class)
                    .setParameter("userId", userId)
                    .getResultList();
        } catch (Exception e) {
            logger.error("Error getting all followers: {}", e.getMessage(), e);
            return List.of();
        }
    }

    
    @Transactional
    public List<UserDataMapper> getAllFollowing(Integer userId) {
        try {
            return entityManager.createQuery(
                            "SELECT uf.followed FROM UserFollowersAndFollowingDataMapper uf WHERE uf.follower.id = :userId AND uf.isActive = true", UserDataMapper.class)
                    .setParameter("userId", userId)
                    .getResultList();
        } catch (Exception e) {
            logger.error("Error getting all following: {}", e.getMessage(), e);
            return List.of();
        }
    }

    
}