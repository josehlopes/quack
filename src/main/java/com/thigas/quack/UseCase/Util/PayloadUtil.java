// src/main/java/com/thigas/quack/UseCase/Util/PayloadUtil.java
package com.thigas.quack.UseCase.Util;

import java.util.Map;

public class PayloadUtil {

    public static Map<String, Object> createRegisterPayload(String token) {
        return Map.of("token", token);
    }

    public static Map<String, Object> createLoginPayload(int userId, String token) {
        return Map.of("id", userId, "token", token);
    }

    public static Map<String, Object> createAddressPayload(String message) {
        return Map.of("message", message);
    }

    //TODO: Adicione métodos para outros payloads conforme necessário
    public static Map<String, Object> createUpdatePayload(String message) {
        return Map.of("message", message);
    }

    public static Map<String, Object> createDeletePayload(String message) {
        return Map.of("message", message);
    }
}