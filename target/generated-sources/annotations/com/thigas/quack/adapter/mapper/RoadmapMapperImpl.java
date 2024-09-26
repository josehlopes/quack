package com.thigas.quack.adapter.mapper;

import com.thigas.quack.adapter.dto.RoadmapDTO;
import com.thigas.quack.domain.entity.RoadmapEntity;
import com.thigas.quack.infrastructure.persistence.entity.RoadmapModel;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-09-25T22:32:28-0300",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.39.0.v20240820-0604, environment: Java 17.0.12 (Eclipse Adoptium)"
)
@Component
public class RoadmapMapperImpl implements RoadmapMapper {

    @Override
    public RoadmapDTO entityToDto(RoadmapEntity roadmap) {
        if ( roadmap == null ) {
            return null;
        }

        RoadmapDTO roadmapDTO = new RoadmapDTO();

        roadmapDTO.setStatus( statusToInt( roadmap.getStatus() ) );
        roadmapDTO.setDescription( roadmap.getDescription() );
        roadmapDTO.setId( roadmap.getId() );
        roadmapDTO.setImagePath( roadmap.getImagePath() );
        roadmapDTO.setTitle( roadmap.getTitle() );

        return roadmapDTO;
    }

    @Override
    public RoadmapEntity dtoToEntity(RoadmapDTO roadmapDTO) {
        if ( roadmapDTO == null ) {
            return null;
        }

        RoadmapEntity roadmapEntity = new RoadmapEntity();

        roadmapEntity.setStatus( intToStatus( roadmapDTO.getStatus() ) );
        roadmapEntity.setDescription( roadmapDTO.getDescription() );
        roadmapEntity.setId( roadmapDTO.getId() );
        roadmapEntity.setImagePath( roadmapDTO.getImagePath() );
        roadmapEntity.setTitle( roadmapDTO.getTitle() );

        return roadmapEntity;
    }

    @Override
    public RoadmapModel entityToModel(RoadmapEntity roadmap) {
        if ( roadmap == null ) {
            return null;
        }

        RoadmapModel roadmapModel = new RoadmapModel();

        roadmapModel.setDescription( roadmap.getDescription() );
        roadmapModel.setId( roadmap.getId() );
        roadmapModel.setImagePath( roadmap.getImagePath() );
        roadmapModel.setStatus( roadmap.getStatus() );
        roadmapModel.setTitle( roadmap.getTitle() );

        return roadmapModel;
    }

    @Override
    public RoadmapEntity modelToEntity(RoadmapModel roadmapModel) {
        if ( roadmapModel == null ) {
            return null;
        }

        RoadmapEntity roadmapEntity = new RoadmapEntity();

        roadmapEntity.setDescription( roadmapModel.getDescription() );
        roadmapEntity.setId( roadmapModel.getId() );
        roadmapEntity.setImagePath( roadmapModel.getImagePath() );
        roadmapEntity.setStatus( roadmapModel.getStatus() );
        roadmapEntity.setTitle( roadmapModel.getTitle() );

        return roadmapEntity;
    }
}
