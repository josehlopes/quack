package com.thigas.quack.UseCase.Model.Request;

import com.thigas.quack.Domain.Utils.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserTaskDsRequestModel {

    private int id;
    private UserDsRequestModel user;
    private TaskDsRequestModel task;
    private Status status;
    private String imagePath;


}