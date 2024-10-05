package com.thigas.quack.adapter.mapper;

import com.thigas.quack.adapter.model.BaseEntity;
import com.thigas.quack.adapter.model.BaseModel;
import org.mapstruct.Context;

import java.util.Set;
import java.util.stream.Collectors;

public class MapperUtils {

    // Método genérico para converter uma lista de entidades em uma lista de IDs
    public static <T extends BaseEntity> Set<Integer> entitiesToIntegers(Set<T> entities) {
        if (entities == null) {
            return null;
        }
        return entities.stream()
                .map(BaseEntity::getId)
                .collect(Collectors.toSet());
    }

    // Método genérico para converter uma lista de IDs em uma lista de entidades
    public static <T extends BaseEntity> Set<T> integersToEntities(Set<Integer> ids, Class<T> clazz, @Context CycleAvoidingMappingContext context) {
        if (ids == null) {
            return null;
        }
        return ids.stream().map(id -> {
            try {
                T entity = context.getMappedInstance(id, clazz);
                if (entity == null) {
                    entity = clazz.getDeclaredConstructor().newInstance();
                    entity.setId(id);
                    context.storeMappedInstance(id, entity);
                }
                return entity;
            } catch (Exception e) {
                throw new RuntimeException("Error instantiating entity", e);
            }
        }).collect(Collectors.toSet());
    }

    // Método genérico para converter uma lista de models em uma lista de IDs
    public static <T extends BaseModel> Set<Integer> modelsToIntegers(Set<T> models) {
        if (models == null) {
            return null;
        }
        return models.stream()
                .map(BaseModel::getId) // Assegure que BaseModel tenha getId()
                .collect(Collectors.toSet());
    }

    // Método genérico para converter uma lista de IDs em uma lista de models
    public static <T extends BaseModel> Set<T> integersToModels(Set<Integer> ids, Class<T> clazz, @Context CycleAvoidingMappingContext context) {
        if (ids == null) {
            return null;
        }
        return ids.stream().map(id -> {
            try {
                T model = context.getMappedInstance(id, clazz);
                if (model == null) {
                    model = clazz.getDeclaredConstructor().newInstance();
                    model.setId(id);
                    context.storeMappedInstance(id, model);
                }
                return model;
            } catch (Exception e) {
                throw new RuntimeException("Error instantiating model", e);
            }
        }).collect(Collectors.toSet());
    }

    public static <T extends BaseEntity>
}
