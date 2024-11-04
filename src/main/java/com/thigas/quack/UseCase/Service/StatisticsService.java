package com.thigas.quack.UseCase.Service;

import com.thigas.quack.Adapter.Dto.StatisticsDTO;
import com.thigas.quack.Adapter.Mapper.ObjectMapperService;
import com.thigas.quack.UseCase.Gateway.StatisticsDsGateway;
import com.thigas.quack.UseCase.Gateway.UserDsGateway;
import com.thigas.quack.Infrastructure.Model.StatisticsDataMapper;
import com.thigas.quack.Infrastructure.Model.UserDataMapper;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class StatisticsService {


    //TODO: Consertar estatisticas
    @Autowired
    private StatisticsDsGateway statisticsRepository;

    @Autowired
    private UserDsGateway userRepository;

    @Autowired
    private ObjectMapperService objectMapperService = new ObjectMapperService();

    public void create(StatisticsDTO statisticsDTO) {
        StatisticsDataMapper statisticsDataMapper = objectMapperService.toModel(statisticsDTO);
        statisticsRepository.save(statisticsDataMapper);
    }

    public Optional<StatisticsDTO> getById(int id) {
        Optional<StatisticsDataMapper> statistics = statisticsRepository.findById(id);
        return statistics.map(objectMapperService::toDto);
    }

    public Iterable<StatisticsDTO> getAll() {
        Iterable<StatisticsDataMapper> statistics = statisticsRepository.findAll();
        return StreamSupport.stream(statistics.spliterator(), false)
                .map(objectMapperService::toDto)
                .collect(Collectors.toList());
    }

    public void update(StatisticsDTO statisticsDTO) {
        StatisticsDataMapper existingStatistics = statisticsRepository.findById(statisticsDTO.getId())
                .orElseThrow(() -> new EntityNotFoundException("Statistics not found"));
        StatisticsDataMapper statisticsDataMapper = objectMapperService.toModel(statisticsDTO);
        statisticsRepository.save(statisticsDataMapper);
    }

    public void createInitialStatisticsForUser(int userId) {

        UserDataMapper user = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));

        StatisticsDataMapper statisticsDataMapper = new StatisticsDataMapper();
        statisticsDataMapper.setUser(user);
        statisticsDataMapper.setRoadmapsCompletedCount(0);
        statisticsDataMapper.setChallengesCompletedCount(0);
        statisticsDataMapper.setBestStreak(0);
        statisticsRepository.save(statisticsDataMapper);
    }

    public void incrementRoadmapsCompleted(int userId) {
        StatisticsDataMapper statisticsDataMapper = statisticsRepository.findByUserId(userId)
                .orElseThrow(() -> new EntityNotFoundException("Statistics not found for user ID: " + userId));
        statisticsDataMapper.setRoadmapsCompletedCount(statisticsDataMapper.getRoadmapsCompletedCount() + 1);
        statisticsRepository.save(statisticsDataMapper);;
    }

    public void delete(int id) {
        statisticsRepository.deleteById(id);
    }
}
