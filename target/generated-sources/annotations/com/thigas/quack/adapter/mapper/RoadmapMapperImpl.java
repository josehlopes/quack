package com.thigas.quack.adapter.mapper;

import com.thigas.quack.adapter.dto.RoadmapDTO;
import com.thigas.quack.domain.entity.RoadmapEntity;
import com.thigas.quack.infrastructure.persistence.entity.RoadmapModel;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-09-27T00:28:42-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.4 (Oracle Corporation)"
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
        roadmapDTO.setId( roadmap.getId() );
        roadmapDTO.setTitle( roadmap.getTitle() );
        roadmapDTO.setDescription( roadmap.getDescription() );
        roadmapDTO.setImagePath( roadmap.getImagePath() );

        return roadmapDTO;
    }

    @Override
    public RoadmapEntity dtoToEntity(RoadmapDTO roadmapDTO) {
        if ( roadmapDTO == null ) {
            return null;
        }

        RoadmapEntity roadmapEntity = new RoadmapEntity();

        roadmapEntity.setStatus( intToStatus( roadmapDTO.getStatus() ) );
        roadmapEntity.setId( roadmapDTO.getId() );
        roadmapEntity.setTitle( roadmapDTO.getTitle() );
        roadmapEntity.setDescription( roadmapDTO.getDescription() );
        roadmapEntity.setImagePath( roadmapDTO.getImagePath() );

        return roadmapEntity;
    }

    @Override
    public RoadmapModel entityToModel(RoadmapEntity roadmap) {
        if ( roadmap == null ) {
            return null;
        }

        RoadmapModel roadmapModel = new RoadmapModel();

        roadmapModel.setId( roadmap.getId() );
        roadmapModel.setTitle( roadmap.getTitle() );
        roadmapModel.setDescription( roadmap.getDescription() );
        roadmapModel.setImagePath( roadmap.getImagePath() );
        roadmapModel.setStatus( roadmap.getStatus() );

        return roadmapModel;
    }

    @Override
    public RoadmapEntity modelToEntity(RoadmapModel roadmapModel) {
        if ( roadmapModel == null ) {
            return null;
        }

        RoadmapEntity roadmapEntity = new RoadmapEntity();

        roadmapEntity.setId( roadmapModel.getId() );
        roadmapEntity.setTitle( roadmapModel.getTitle() );
        roadmapEntity.setDescription( roadmapModel.getDescription() );
        roadmapEntity.setImagePath( roadmapModel.getImagePath() );
        roadmapEntity.setStatus( roadmapModel.getStatus() );

        return roadmapEntity;
    }
}
