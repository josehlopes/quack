package com.thigas.quack.Adapter.Persistence;

import com.thigas.quack.Adapter.Entity.StatisticsDataMapper;
import com.thigas.quack.Adapter.Repository.JpaStatisticsRepository;
import com.thigas.quack.Adapter.Repository.UserRepository;
import com.thigas.quack.UseCase.Gateway.StatisticsDsGateway;
import com.thigas.quack.UseCase.Mapper.MapStructMapper;
import com.thigas.quack.UseCase.Model.Request.StatisticsDtoRequestModel;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RequiredArgsConstructor
public class StatisticsDsGatewayImplementation implements StatisticsDsGateway {

    private final JpaStatisticsRepository statisticsRepository;
    private final UserRepository userRepository;
    private final MapStructMapper mapper;

    @Override
    public void save(StatisticsDtoRequestModel statisticsRequest) {
        StatisticsDataMapper toSaveStatistics = mapper.mapStatisticsDtoRequestToDataMapper(statisticsRequest);
        statisticsRepository.save(toSaveStatistics);
    }

    @Override
    public Optional<StatisticsDtoRequestModel> findById(int id) {
        Optional<StatisticsDataMapper> statistics = statisticsRepository.findById(id);
        return statistics.map(mapper::mapStatisticsDataMapperToDtoRequest);
    }

    @Override
    public Iterable<StatisticsDtoRequestModel> findAll() {
        Iterable<StatisticsDataMapper> statistics = statisticsRepository.findAll();
        return StreamSupport.stream(statistics.spliterator(), false)
                .map(mapper::mapStatisticsDataMapperToDtoRequest)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(int id) {
        statisticsRepository.deleteById(id);
    }

    @Override
    public Optional<StatisticsDtoRequestModel> findByUserId(int userId) {
        Optional<StatisticsDataMapper> statistics = statisticsRepository.findByUserId(userId);
        return statistics.map(mapper::mapStatisticsDataMapperToDtoRequest);
    }

    @Override
    public void incrementRoadmapsCompleted(int userId) {
        StatisticsDtoRequestModel statistics = findByUserId(userId)
                .orElseThrow(() -> new EntityNotFoundException("Statistics not found for user ID: " + userId));
        statistics = new StatisticsDtoRequestModel(
                statistics.id(), statistics.userId(), statistics.streakDays(), statistics.bestStreak(),
                statistics.userLevel(), statistics.points(), statistics.userExperience(),
                statistics.challengesCompletedCount(), statistics.roadmapsCompletedCount() + 1
        );
        save(statistics);
    }

//    @Override
//    public void createInitialStatisticsForUser(int userId) {
//        UserDsDtoRequestModel user = userRepository.findById(userId).map(mapper::mapUserDataMapperToUserDtoRequest)
//                .orElseThrow(() -> new EntityNotFoundException("User not found"));
//
//        StatisticsDtoRequestModel statistics = new StatisticsDtoRequestModel(
//                null, user.id(), 0, 0, 0, 0.0, 0.0, 0, 0
//        );
//        save(statistics);
//    }
}