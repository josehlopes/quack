package com.thigas.quack.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserTaskEntity {

    private int id;
    private UserEntity user;
    private TaskEntity task;
    private Boolean status;
    private String imagePath;

}