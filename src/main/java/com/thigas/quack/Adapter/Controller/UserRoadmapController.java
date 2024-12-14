package com.thigas.quack.Adapter.Controller;

import com.thigas.quack.UseCase.Boundary.UserRoadmapInputBoundary;
import com.thigas.quack.UseCase.Model.Request.CompleteRoadmapRequestModel;
import com.thigas.quack.UseCase.Model.Request.RoadmapRequestModel;
import com.thigas.quack.UseCase.Model.Request.StartRoadmapRequestModel;
import com.thigas.quack.UseCase.Model.Response.GenericResponseModel;
import com.thigas.quack.UseCase.Util.ResponseWrapper;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/users/roadmaps")
@AllArgsConstructor
public class UserRoadmapController {

    private final UserRoadmapInputBoundary userRoadmapInput;

    @PostMapping("/start")
    public ResponseEntity<GenericResponseModel> createRoadmap(@RequestBody StartRoadmapRequestModel request) {
        ResponseWrapper<GenericResponseModel> success = userRoadmapInput.startRoadmap(request);
        if (success.getStatusCode() == 201) {
            return new ResponseEntity<>(success.getData(), HttpStatus.CREATED);
        } else if (success.getStatusCode() == 400) {
            return new ResponseEntity<>(success.getData(), HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(success.getData(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PostMapping("/complete")
    public ResponseEntity<GenericResponseModel> completeRoadmap(@RequestBody CompleteRoadmapRequestModel request) {
        ResponseWrapper<GenericResponseModel> response = userRoadmapInput.completeRoadmap(request);
        if (response.getStatusCode() == 200) {
            return new ResponseEntity<>(response.getData(), HttpStatus.OK);
        } else if (response.getStatusCode() == 400) {
            return new ResponseEntity<>(response.getData(), HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(response.getData(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{userId}")
    public ResponseEntity<GenericResponseModel> getUserRoadmapsByUserId(@PathVariable Integer userId) {
        ResponseWrapper<List<RoadmapRequestModel>> response = userRoadmapInput.getUserRoadmapsByUserId(userId);
        if (response.getStatusCode() == 200) {
            Map<String, Object> responseData = new HashMap<>();
            responseData.put("roadmaps", response.getData());  // Add the roadmaps list inside the map
            return new ResponseEntity<>(new GenericResponseModel("User roadmaps found", responseData), HttpStatus.OK);
        } else if (response.getStatusCode() == 404) {
            return new ResponseEntity<>(new GenericResponseModel("No user roadmaps found for this user"), HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(new GenericResponseModel("Error retrieving user roadmaps"), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
