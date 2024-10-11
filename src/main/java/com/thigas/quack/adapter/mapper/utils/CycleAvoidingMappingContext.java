package com.thigas.quack.adapter.mapper.utils;

import org.springframework.stereotype.Component;

import java.util.IdentityHashMap;
import java.util.Map;

@Component
public class CycleAvoidingMappingContext {

    private final Map<Object, Object> knownInstances = new IdentityHashMap<>();

    public <T> T getMappedInstance(Object source, Class<T> targetType) {
        return (T) knownInstances.get(source);
    }

    public void storeMappedInstance(Object source, Object target) {
        knownInstances.put(source, target);
    }
}
