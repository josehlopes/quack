package com.thigas.quack.adapter.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.thigas.quack.adapter.dto.RoadmapDTO;
import com.thigas.quack.domain.entity.Roadmap;
import com.thigas.quack.infrastructure.persistence.entity.RoadmapModel;

@Mapper
public interface RoadmapMapper {

    RoadmapMapper INSTANCE = Mappers.getMapper(RoadmapMapper.class);

    // Mapeando todos os campos do Roadmap para o DTO
    @Mapping(source = "id", target = "id")
    @Mapping(source = "title", target = "title")
    @Mapping(source = "description", target = "description")
    @Mapping(source = "imagePath", target = "imagePath")
    RoadmapDTO toRoadmapDTO(Roadmap roadmap);

    // Mapeando o DTO de volta para o Roadmap
    @Mapping(source = "id", target = "id")
    @Mapping(source = "title", target = "title")
    @Mapping(source = "description", target = "description")
    @Mapping(source = "imagePath", target = "imagePath")
    Roadmap toRoadmap(RoadmapDTO roadmapDTO);

    // Mapeando o Roadmap para o modelo de persistência
    @Mapping(source = "id", target = "id")
    @Mapping(source = "title", target = "title")
    @Mapping(source = "description", target = "description")
    @Mapping(source = "imagePath", target = "imagePath")
    RoadmapModel toRoadmapModel(Roadmap roadmap);

    // Mapeando o modelo de persistência de volta para o Roadmap
    @Mapping(source = "id", target = "id")
    @Mapping(source = "title", target = "title")
    @Mapping(source = "description", target = "description")
    @Mapping(source = "imagePath", target = "imagePath")
    Roadmap toRoadmap(RoadmapModel roadmapModel);

    // Métodos de mapeamento customizados para IDs
    default RoadmapModel map(Long userId) {
        if (userId == null) {
            return null;
        }
        RoadmapModel userModel = new RoadmapModel();
        userModel.setId(userId);
        return userModel;
    }

    default Long map(RoadmapModel userModel) {
        if (userModel == null) {
            return null;
        }
        return userModel.getId();
    }
}