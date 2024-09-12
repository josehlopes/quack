package com.thigas.quack.adapter.mapper;

import com.thigas.quack.adapter.dto.RoadmapDTO;
import com.thigas.quack.domain.entity.Roadmap;
import com.thigas.quack.infrastructure.persistence.entity.RoadmapModel;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-09-12T11:38:40-0300",
    comments = "version: 1.6.0, compiler: Eclipse JDT (IDE) 3.39.0.v20240820-0604, environment: Java 17.0.12 (Eclipse Adoptium)"
)
public class RoadmapMapperImpl implements RoadmapMapper {

    @Override
    public RoadmapDTO toRoadmapDTO(Roadmap roadmap) {
        if ( roadmap == null ) {
            return null;
        }

        RoadmapDTO roadmapDTO = new RoadmapDTO();

        roadmapDTO.setId( roadmap.getId() );
        roadmapDTO.setTitle( roadmap.getTitle() );
        roadmapDTO.setDescription( roadmap.getDescription() );
        roadmapDTO.setImagePath( roadmap.getImagePath() );

        return roadmapDTO;
    }

    @Override
    public Roadmap toRoadmap(RoadmapDTO roadmapDTO) {
        if ( roadmapDTO == null ) {
            return null;
        }

        Roadmap roadmap = new Roadmap();

        roadmap.setId( roadmapDTO.getId() );
        roadmap.setTitle( roadmapDTO.getTitle() );
        roadmap.setDescription( roadmapDTO.getDescription() );
        roadmap.setImagePath( roadmapDTO.getImagePath() );

        return roadmap;
    }

    @Override
    public RoadmapModel toRoadmapModel(Roadmap roadmap) {
        if ( roadmap == null ) {
            return null;
        }

        RoadmapModel roadmapModel = new RoadmapModel();

        roadmapModel.setId( roadmap.getId() );
        roadmapModel.setTitle( roadmap.getTitle() );
        roadmapModel.setDescription( roadmap.getDescription() );
        roadmapModel.setImagePath( roadmap.getImagePath() );

        return roadmapModel;
    }

    @Override
    public Roadmap toRoadmap(RoadmapModel roadmapModel) {
        if ( roadmapModel == null ) {
            return null;
        }

        Roadmap roadmap = new Roadmap();

        roadmap.setId( roadmapModel.getId() );
        roadmap.setTitle( roadmapModel.getTitle() );
        roadmap.setDescription( roadmapModel.getDescription() );
        roadmap.setImagePath( roadmapModel.getImagePath() );

        return roadmap;
    }
}
