package com.thigas.quack.UseCase.Model.Request;

import com.thigas.quack.Domain.Utils.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserStepDsRequestModel {

    private int id;
    private UserDsRequestModel user;
    private StepDsRequestModel step;
    private Status status;
    private String imagePath;

}
