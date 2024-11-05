package com.thigas.quack.Adapter.Mapper;

import com.google.gson.Gson;
import com.thigas.quack.UseCase.Model.Request.TaskTextDtoRequestModel;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class TaskTextConverter implements AttributeConverter<TaskTextDtoRequestModel, String> {

    private final static Gson GSON = new Gson();

    @Override
    public String convertToDatabaseColumn(TaskTextDtoRequestModel taskTextDtoRequestModel) {
        return GSON.toJson(taskTextDtoRequestModel);
    }

    @Override
    public TaskTextDtoRequestModel convertToEntityAttribute(String dbData) {
        return GSON.fromJson(dbData, TaskTextDtoRequestModel.class);
    }
}
