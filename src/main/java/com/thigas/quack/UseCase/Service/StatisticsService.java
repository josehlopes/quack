package com.thigas.quack.UseCase.Service;

import com.thigas.quack.Adapter.Mapper.ObjectMapperService;
import com.thigas.quack.UseCase.Gateway.StatisticsDsGateway;
import com.thigas.quack.UseCase.Gateway.UserDsGateway;
import com.thigas.quack.UseCase.Model.Request.StatisticsDtoRequestModel;
import com.thigas.quack.UseCase.Model.Request.UserDtoRequestModel;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class StatisticsService {


    //TODO: Consertar estatisticas
    //TODO: Ajeitar o tipo de dados que vem do front, para não haver furos de camadas
    @Autowired
    private StatisticsDsGateway statisticsGateway;

    @Autowired
    private UserDsGateway userRepository;

    @Autowired
    private ObjectMapperService objectMapperService = new ObjectMapperService();

    public void create(StatisticsDtoRequestModel statisticsRequest) {
        statisticsGateway.save(statisticsRequest);
    }

    public Optional<StatisticsDtoRequestModel> getById(int id) {
        return statisticsGateway.findById(id);
    }

    public Iterable<StatisticsDtoRequestModel> getAll() {
        Iterable<StatisticsDtoRequestModel> statistics = statisticsGateway.findAll();
        return StreamSupport.stream(statistics.spliterator(), false)
                .collect(Collectors.toList());
    }

    public void update(StatisticsDtoRequestModel statisticsRequest) {
        StatisticsDtoRequestModel existingStatistics = statisticsGateway.findById(statisticsRequest.getId())
                .orElseThrow(() -> new EntityNotFoundException("Statistics not found"));
        statisticsGateway.save(statisticsRequest);
    }

    public void createInitialStatisticsForUser(int userId) {

        UserDtoRequestModel user = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));

        StatisticsDtoRequestModel statistics = new StatisticsDtoRequestModel();
        statistics.setUser(user);
        statistics.setRoadmapsCompletedCount(0);
        statistics.setChallengesCompletedCount(0);
        statistics.setBestStreak(0);
        statisticsGateway.save(statistics);
    }

    public void incrementRoadmapsCompleted(int userId) {
        StatisticsDtoRequestModel statistics = statisticsGateway.findByUserId(userId)
                .orElseThrow(() -> new EntityNotFoundException("Statistics not found for user ID: " + userId));
        statistics.setRoadmapsCompletedCount(statistics.getRoadmapsCompletedCount() + 1);
        statisticsGateway.save(statistics);;
    }

    public void delete(int id) {
        statisticsGateway.deleteById(id);
    }
}
