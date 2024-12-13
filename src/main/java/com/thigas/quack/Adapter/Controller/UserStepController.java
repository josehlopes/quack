package com.thigas.quack.Adapter.Controller;

import com.thigas.quack.UseCase.Boundary.UserStepInputBoundary;
import com.thigas.quack.UseCase.Gateway.UserStepDsGateway;
import com.thigas.quack.UseCase.Model.Request.EndStepRequestModel;
import com.thigas.quack.UseCase.Model.Request.StartStepRequestModel;
import com.thigas.quack.UseCase.Model.Request.UserStepRequestModel;
import com.thigas.quack.UseCase.Model.Response.GenericResponseModel;
import com.thigas.quack.UseCase.Util.ResponseWrapper;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users/steps")
@AllArgsConstructor
public class UserStepController {

    private final UserStepInputBoundary userStepInput;
    private final UserStepDsGateway userStepDsGateway;

    @PostMapping("/start")
    public ResponseEntity<GenericResponseModel> startStep(@RequestBody StartStepRequestModel request) {
        ResponseWrapper<GenericResponseModel> success = userStepInput.startStep(request);
        if (success.getStatusCode() == 200) {
            return new ResponseEntity<>(success.getData(), HttpStatus.OK);
        } else if (success.getStatusCode() == 400) {
            return new ResponseEntity<>(success.getData(), HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(success.getData(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/end")
    public ResponseEntity<GenericResponseModel> endStep(@RequestBody EndStepRequestModel request) {
        ResponseWrapper<GenericResponseModel> response = userStepInput.endStep(request);
        if (response.getStatusCode() == 200) {
            return new ResponseEntity<>(response.getData(), HttpStatus.OK);
        } else if (response.getStatusCode() == 400) {
            return new ResponseEntity<>(response.getData(), HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(response.getData(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<UserStepRequestModel>> getStepsByUserId(@PathVariable Integer userId) {
        List<UserStepRequestModel> userSteps = userStepDsGateway.getStepsByUserId(userId);
        if (userSteps.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(userSteps, HttpStatus.OK);
        }
    }
}
