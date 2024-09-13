package com.thigas.quack.adapter.mapper;

import com.thigas.quack.adapter.dto.RoadmapDTO;
import com.thigas.quack.domain.entity.RoadmapEntity;
import com.thigas.quack.infrastructure.persistence.entity.RoadmapModel;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-09-13T17:03:08-0300",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.39.0.v20240820-0604, environment: Java 17.0.12 (Eclipse Adoptium)"
)
public class RoadmapMapperImpl implements RoadmapMapper {

    @Override
    public RoadmapDTO EntityToDto(RoadmapEntity roadmap) {
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
    public RoadmapEntity DtoToEntity(RoadmapDTO roadmapDTO) {
        if ( roadmapDTO == null ) {
            return null;
        }

        RoadmapEntity roadmapEntity = new RoadmapEntity();

        roadmapEntity.setId( roadmapDTO.getId() );
        roadmapEntity.setTitle( roadmapDTO.getTitle() );
        roadmapEntity.setDescription( roadmapDTO.getDescription() );
        roadmapEntity.setImagePath( roadmapDTO.getImagePath() );

        return roadmapEntity;
    }

    @Override
    public RoadmapModel EntityToModel(RoadmapEntity roadmap) {
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
    public RoadmapEntity ModelToEntity(RoadmapModel roadmapModel) {
        if ( roadmapModel == null ) {
            return null;
        }

        RoadmapEntity roadmapEntity = new RoadmapEntity();

        roadmapEntity.setId( roadmapModel.getId() );
        roadmapEntity.setTitle( roadmapModel.getTitle() );
        roadmapEntity.setDescription( roadmapModel.getDescription() );
        roadmapEntity.setImagePath( roadmapModel.getImagePath() );

        return roadmapEntity;
    }
}
