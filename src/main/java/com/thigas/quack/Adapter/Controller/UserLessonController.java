package com.thigas.quack.Adapter.Controller;

import com.thigas.quack.UseCase.Boundary.UserLessonInputBoundary;
import com.thigas.quack.UseCase.Model.Request.CompletedLessonRequestModel;
import com.thigas.quack.UseCase.Model.Request.UserLessonRequestModel;
import com.thigas.quack.UseCase.Model.Response.GenericResponseModel;
import com.thigas.quack.UseCase.Util.ResponseWrapper;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/users/user-lesson")
@AllArgsConstructor
public class UserLessonController {

    private final UserLessonInputBoundary userLessonInput;

    @PostMapping("/complete")
    public ResponseEntity<Void> completeLesson(@RequestBody CompletedLessonRequestModel request) {
        try {
            ResponseWrapper<GenericResponseModel> success = userLessonInput.completedLesson(request);
            if (success.getStatusCode() == 200) {
                return new ResponseEntity<>(HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/exists/{userId}/{lessonId}")
    public ResponseEntity<GenericResponseModel> findByUserIdAndLessonId(@PathVariable Integer userId, @PathVariable Integer lessonId) {
        try {
            ResponseWrapper<GenericResponseModel> response = userLessonInput.findByUserIdAndLessonId(userId, lessonId);
            return ResponseEntity.status(HttpStatus.valueOf(response.getStatusCode())).body(response.getData());
        } catch (Exception ex) {
            return new ResponseEntity<>(new GenericResponseModel("Internal server error", null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<GenericResponseModel> findById(@PathVariable Integer id) {
        try {
            ResponseWrapper<GenericResponseModel> response = userLessonInput.findById(id);
            return new ResponseEntity<>(response.getData(), HttpStatus.valueOf(response.getStatusCode()));
        } catch (Exception ex) {
            return new ResponseEntity<>(new GenericResponseModel("Internal server error", null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<GenericResponseModel> findByUserId(@PathVariable Integer userId) {
        try {
            ResponseWrapper<GenericResponseModel> response = userLessonInput.findByUserId(userId);
            return new ResponseEntity<>(response.getData(), HttpStatus.valueOf(response.getStatusCode()));
        } catch (Exception ex) {
            return new ResponseEntity<>(new GenericResponseModel("Internal server error", null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

