package com.thigas.quack.adapter.mapper;

import com.thigas.quack.adapter.model.BaseEntity;
import com.thigas.quack.adapter.model.BaseModel;
import com.thigas.quack.domain.model.Status;
import org.mapstruct.Context;

import java.util.Set;
import java.util.stream.Collectors;

public class MapperUtils {

    public static <T extends BaseEntity> Set<Integer> entitiesToIntegers(Set<T> entities) {
        if (entities == null) {
            return null;
        }
        return entities.stream()
                .map(BaseEntity::getId)
                .collect(Collectors.toSet());
    }

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

    public static <T extends BaseModel> Set<Integer> modelsToIntegers(Set<T> models) {
        if (models == null) {
            return null;
        }
        return models.stream()
                .map(BaseModel::getId)
                .collect(Collectors.toSet());
    }

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

    public static <T extends BaseEntity> T integerToEntity(Integer id, Class<T> clazz, @Context CycleAvoidingMappingContext context) {
        if (id == null) {
            return null;
        }
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
    }

    public static <T extends BaseEntity> Integer entityToInteger(T entity) {
        if (entity == null) {
            return null;
        }
        return entity.getId();
    }

    public static <T extends BaseModel> T integerToModel(Integer id, Class<T> clazz, @Context CycleAvoidingMappingContext context) {
        if (id == null) {
            return null;
        }
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
    }

    public static <T extends BaseModel> Integer modelToInteger(T model) {
        if (model == null) {
            return null;
        }
        return model.getId();
    }

    public static int statusToInt(Status status) {
        return status != null ? status.getValue() : 0;
    }

    public static Status intToStatus(int value) {
        return Status.fromValue(value);
    }
}

