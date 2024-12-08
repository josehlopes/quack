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
    public void updateFollowing(UserFollowersAndFollowingDataMapper userFollowing) {
        try {
            entityManager.merge(userFollowing);
        } catch (Exception e) {
            logger.error("Error updating following relationship: {}", e.getMessage(), e);
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
    public UserFollowersAndFollowingDataMapper findFollowingRelationship(Integer userId, Integer followingId) {
        try {
            return entityManager.createQuery("SELECT uf FROM UserFollowingDataMapper uf WHERE uf.user.id = :userId AND uf.following.id = :followingId", UserFollowersAndFollowingDataMapper.class)
                    .setParameter("userId", userId)
                    .setParameter("followingId", followingId)
                    .getSingleResult();
        } catch (Exception e) {
            logger.error("Error finding following relationship: {}", e.getMessage(), e);
            return null;
        }
    }
    
    @Transactional
    public UserFollowersAndFollowingDataMapper findFollowerRelationship(Integer userId, Integer followerId) {
        try {
            return entityManager.createQuery("SELECT uf FROM UserFollowersAndFollowingDataMapper uf WHERE uf.user.id = :userId AND uf.follower.id = :followerId", UserFollowersAndFollowingDataMapper.class)
                    .setParameter("userId", userId)
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
            return entityManager.createQuery("SELECT uf.follower FROM UserFollowersAndFollowingDataMapper uf WHERE uf.user.id = :userId", UserDataMapper.class)
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
            return entityManager.createQuery("SELECT uf.following FROM UserFollowingDataMapper uf WHERE uf.user.id = :userId", UserDataMapper.class)
                    .setParameter("userId", userId)
                    .getResultList();
        } catch (Exception e) {
            logger.error("Error getting all following: {}", e.getMessage(), e);
            return List.of();
        }
    }
    
}