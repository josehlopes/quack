package com.thigas.quack.Adapter.Controller;

import com.thigas.quack.UseCase.Boundary.UserLessonInputBoundary;
import com.thigas.quack.UseCase.Model.Request.CompletedLessonRequestModel;
import com.thigas.quack.UseCase.Model.Response.GenericResponseModel;
import com.thigas.quack.UseCase.Util.ResponseWrapper;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users/lessons")
@AllArgsConstructor
public class UserLessonController {

    private final UserLessonInputBoundary userLessonInput;

    @PostMapping("/complete")
    public ResponseEntity<Void> completeLesson(@RequestBody CompletedLessonRequestModel request) {
        ResponseWrapper<GenericResponseModel> success = userLessonInput.completedLesson(request);
        if (success.getStatusCode() == 200) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else if (success.getStatusCode() == 404) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/exists/{userId}/{lessonId}")
    public ResponseEntity<GenericResponseModel> findByUserIdAndLessonId(@PathVariable Integer userId, @PathVariable Integer lessonId) {
        ResponseWrapper<GenericResponseModel> response = userLessonInput.getByUserIdAndLessonId(userId, lessonId);
        if (response.getStatusCode() == 200) {
            return ResponseEntity.ok(response.getData());
        } else if (response.getStatusCode() == 404) {
            return new ResponseEntity<>(new GenericResponseModel("Not found", null), HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(new GenericResponseModel("Internal server error", null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<GenericResponseModel> findById(@PathVariable Integer id) {
        ResponseWrapper<GenericResponseModel> response = userLessonInput.getById(id);
        if (response.getStatusCode() == 200) {
            return new ResponseEntity<>(response.getData(), HttpStatus.OK);
        } else if (response.getStatusCode() == 404) {
            return new ResponseEntity<>(new GenericResponseModel("Not found", null), HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(new GenericResponseModel("Internal server error", null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<GenericResponseModel> findByUserId(@PathVariable Integer userId) {
        ResponseWrapper<GenericResponseModel> response = userLessonInput.getByUserId(userId);
        if (response.getStatusCode() == 200) {
            return new ResponseEntity<>(response.getData(), HttpStatus.OK);
        } else if (response.getStatusCode() == 404) {
            return new ResponseEntity<>(new GenericResponseModel("Not found", null), HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(new GenericResponseModel("Internal server error", null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

