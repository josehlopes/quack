package com.thigas.quack.Adapter.Mapper;

import com.google.gson.Gson;
import com.thigas.quack.UseCase.Model.Request.TaskTextDsRequestModel;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class TaskTextConverter implements AttributeConverter<TaskTextDsRequestModel, String> {

    private final static Gson GSON = new Gson();

    @Override
    public String convertToDatabaseColumn(TaskTextDsRequestModel taskTextDsRequestModel) {
        return GSON.toJson(taskTextDsRequestModel);
    }

    @Override
    public TaskTextDsRequestModel convertToEntityAttribute(String dbData) {
        return GSON.fromJson(dbData, TaskTextDsRequestModel.class);
    }
}
