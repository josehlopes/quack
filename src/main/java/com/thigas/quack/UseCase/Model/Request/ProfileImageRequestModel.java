package com.thigas.quack.UseCase.Model.Request;

public record ProfileImageRequestModel(String name, String originalFileName, String contentType, byte[] content) {
}
