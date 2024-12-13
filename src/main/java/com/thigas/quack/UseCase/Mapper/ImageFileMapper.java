package com.thigas.quack.UseCase.Mapper;

import com.thigas.quack.UseCase.Model.Request.ProfileImageRequestModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;
import org.springframework.web.multipart.MultipartFile;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, uses = {MapperDefaults.class})
public interface ImageFileMapper {
    
    @Mappings({
            @Mapping(target = "name", expression = "java(file.getName())"),
            @Mapping(target = "originalFileName", expression = "java(file.getOriginalFilename())"),
            @Mapping(target = "contentType", expression = "java(file.getContentType())"),
            @Mapping(target = "content", source = "file", qualifiedByName = "getContent")
    })
    ProfileImageRequestModel toMultiPartModel(MultipartFile file);
}
