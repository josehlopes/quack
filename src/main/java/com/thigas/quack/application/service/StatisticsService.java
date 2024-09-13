package com.thigas.quack.application.service;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thigas.quack.adapter.dto.StatisticsDTO;
import com.thigas.quack.adapter.mapper.StatisticsMapper;
import com.thigas.quack.domain.entity.StatisticsEntity;
import com.thigas.quack.domain.repository.IStatisticsRepository;

@Service
public class StatisticsService {

    @Autowired
    private IStatisticsRepository statisticsRepository;

    // Instância do mapper
    private final StatisticsMapper statisticsMapper = StatisticsMapper.INSTANCE;

    public StatisticsDTO create(StatisticsDTO statisticsDTO) {
        // Converter DTO para entidade
        StatisticsEntity statistics = statisticsMapper.DtoToEntity(statisticsDTO);
        // Salvar a entidade
        StatisticsEntity toSaveStatistics = statisticsRepository.save(statistics);
        // Converter entidade de volta para DTO
        return statisticsMapper.EntityToDto(toSaveStatistics);
    }

    public Optional<StatisticsDTO> getById(int id) {
        // Buscar a entidade do repositório
        Optional<StatisticsEntity> statistics = statisticsRepository.findById(id);
        // Converter a entidade para DTO
        return statistics.map(statisticsMapper::EntityToDto);
    }

    public Iterable<StatisticsDTO> getAll() {
        // Buscar todas as entidades
        Iterable<StatisticsEntity> statisticss = statisticsRepository.findAll();
        // Converter todas as entidades para DTOs
        return StreamSupport.stream(statisticss.spliterator(), false)
                .map(statisticsMapper::EntityToDto)
                .collect(Collectors.toList());
    }

    public void update(StatisticsDTO statisticsDTO) {
        // Converter DTO para entidade
        StatisticsEntity statistics = statisticsMapper.DtoToEntity(statisticsDTO);
        // Atualizar a entidade
        statisticsRepository.save(statistics);
    }

    public void delete(int id) {
        statisticsRepository.deleteById(id);
    }
}