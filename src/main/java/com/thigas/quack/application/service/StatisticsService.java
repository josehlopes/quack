package com.thigas.quack.application.service;

import com.thigas.quack.adapter.dto.StatisticsDTO;
import com.thigas.quack.domain.repository.IStatisticsRepository;
import com.thigas.quack.domain.repository.IUserRepository;
import com.thigas.quack.infrastructure.persistence.entity.StatisticsModel;
import com.thigas.quack.infrastructure.persistence.entity.UserModel;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class StatisticsService {

    @Autowired
    private IStatisticsRepository statisticsRepository;

    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private ObjectMapperService objectMapperService = new ObjectMapperService();

    public StatisticsDTO create(StatisticsDTO statisticsDTO) {
        StatisticsModel statisticsModel = objectMapperService.toModel(statisticsDTO);
        StatisticsModel savedStatistics = statisticsRepository.save(statisticsModel);
        return objectMapperService.toDto(savedStatistics);
    }

    public Optional<StatisticsDTO> getById(int id) {
        Optional<StatisticsModel> statistics = statisticsRepository.findById(id);
        return statistics.map(objectMapperService::toDto);
    }

    public Iterable<StatisticsDTO> getAll() {
        Iterable<StatisticsModel> statistics = statisticsRepository.findAll();
        return StreamSupport.stream(statistics.spliterator(), false)
                .map(objectMapperService::toDto)
                .collect(Collectors.toList());
    }

    public void update(StatisticsDTO statisticsDTO) {
        StatisticsModel existingStatistics = statisticsRepository.findById(statisticsDTO.getId())
                .orElseThrow(() -> new EntityNotFoundException("Statistics not found"));
        StatisticsModel statisticsModel = objectMapperService.toModel(statisticsDTO);
        statisticsRepository.save(statisticsModel);
    }

    public void createInitialStatisticsForUser(int userId) {

        UserModel user = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));

        StatisticsModel statisticsModel = new StatisticsModel();
        statisticsModel.setUser(user);
        statisticsModel.setRoadmapsCompletedCount(0);
        statisticsModel.setChallengesCompletedCount(0);
        statisticsModel.setBestStreak(0);
        statisticsRepository.save(statisticsModel);
    }

    public void incrementRoadmapsCompleted(int userId) {
        StatisticsModel statisticsModel = statisticsRepository.findByUserId(userId)
                .orElseThrow(() -> new EntityNotFoundException("Statistics not found for user ID: " + userId));
        statisticsModel.setRoadmapsCompletedCount(statisticsModel.getRoadmapsCompletedCount() + 1);
        statisticsRepository.save(statisticsModel);;
    }

    public void delete(int id) {
        statisticsRepository.deleteById(id);
    }
}
