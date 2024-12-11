package com.thigas.quack.Adapter.Controller;

import com.thigas.quack.UseCase.Boundary.UserRoadmapInputBoundary;
import com.thigas.quack.UseCase.Model.Request.StartRoadmapRequestModel;
import com.thigas.quack.UseCase.Model.Response.GenericResponseModel;
import com.thigas.quack.UseCase.Util.ResponseWrapper;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users/roadmaps")
@AllArgsConstructor
public class UserRoadmapController {

    private final UserRoadmapInputBoundary userRoadmapInput;

    @PostMapping("/start")
    public ResponseEntity<Void> createRoadmap(@RequestBody StartRoadmapRequestModel request) {
        ResponseWrapper<GenericResponseModel> success = userRoadmapInput.startRoadmap(request);
            if (success.getStatusCode() == 201) {
                return new ResponseEntity<>(HttpStatus.CREATED);
            } else if (success.getStatusCode() == 400) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            } else {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
}
