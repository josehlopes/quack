package com.thigas.quack.UseCase.Mapper;

import com.google.gson.Gson;
import com.thigas.quack.Adapter.Entity.TaskDataMapper;
import com.thigas.quack.Domain.Entity.Interface.Task;
import com.thigas.quack.UseCase.Model.Request.TaskRequestModel;
import com.thigas.quack.UseCase.Model.Request.TaskTextRequestModel;
import com.thigas.quack.UseCase.Model.Response.TaskInfoResponseModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, uses = {MapperDefaults.class})
public interface TaskMapper {

    TaskMapper MAPPER = Mappers.getMapper(TaskMapper.class);

    TaskDataMapper toDataMapper(TaskRequestModel taskRequestModel);

    @Mapping(target = "stepsId", source = "steps", qualifiedByName = "mapStepDataMapperToIds")
    TaskRequestModel toDsModel(TaskDataMapper taskDataMapper);

    TaskInfoResponseModel toInfoDto(TaskDataMapper taskDataMapper);

    @Mapping(target = "stepsId", source = "steps", qualifiedByName = "mapStepsToIds")
    TaskRequestModel toDsModel(Task task);

    default TaskTextRequestModel map(String value) {
        if (value == null || value.isEmpty()) {
            return null;
        }
        return new Gson().fromJson(value, TaskTextRequestModel.class);
    }

    default String map(TaskTextRequestModel taskTextRequestModel) {
        if (taskTextRequestModel == null) {
            return null;
        }
        return new Gson().toJson(taskTextRequestModel);
    }
}
