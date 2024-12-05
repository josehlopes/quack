package com.thigas.quack.UseCase.Mapper;

import com.google.gson.Gson;
import com.thigas.quack.UseCase.Model.Request.TaskTextRequestModel;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class TaskTextConverter implements AttributeConverter<TaskTextRequestModel, String> {

    private final static Gson GSON = new Gson();

    @Override
    public String convertToDatabaseColumn(TaskTextRequestModel taskTextRequestModel) {
        return GSON.toJson(taskTextRequestModel);
    }

    @Override
    public TaskTextRequestModel convertToEntityAttribute(String dbData) {
        return GSON.fromJson(dbData, TaskTextRequestModel.class);
    }

}
