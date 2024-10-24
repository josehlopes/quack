package com.thigas.quack.adapter.mapper;

import com.google.gson.Gson;
import com.thigas.quack.domain.entity.TaskText;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class TaskTextConverter implements AttributeConverter<TaskText, String> {

    private final static Gson GSON = new Gson();

    @Override
    public String convertToDatabaseColumn(TaskText taskText) {
        return GSON.toJson(taskText);
    }

    @Override
    public TaskText convertToEntityAttribute(String dbData) {
        return GSON.fromJson(dbData, TaskText.class);
    }
}
