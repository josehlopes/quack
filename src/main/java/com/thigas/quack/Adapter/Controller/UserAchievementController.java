package com.thigas.quack.Adapter.Controller;

import com.thigas.quack.UseCase.Boundary.UserAchievementInputBoundary;
import com.thigas.quack.UseCase.Gateway.UserAchievementDsGateway;
import com.thigas.quack.UseCase.Model.Request.AchievementRequestModel;
import com.thigas.quack.UseCase.Model.Request.UserAchievementUnlockRequestModel;
import com.thigas.quack.UseCase.Model.Response.AddressInfoResponseModel;
import com.thigas.quack.UseCase.Model.Response.GenericResponseModel;
import com.thigas.quack.UseCase.Util.ResponseWrapper;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users/achievement")
@AllArgsConstructor
public class UserAchievementController {

    private final UserAchievementInputBoundary userAchievementInput;
    private final UserAchievementDsGateway userAchievementDsGateway;

    @PostMapping("createAddress")
    public ResponseEntity<Void> createAchievement(@RequestBody UserAchievementUnlockRequestModel request) {
            ResponseWrapper<GenericResponseModel> success = userAchievementInput.unlockUserAchievement(request);
            if (success.getStatusCode() == 201) {
                return new ResponseEntity<>(HttpStatus.CREATED);
            } else {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
    }

    @GetMapping("getAllAchievements/{userId}")
    public ResponseEntity<Iterable<AchievementRequestModel>> getAllUserAchievements(@PathVariable Integer userId) {
        try {
            Iterable<AchievementRequestModel> achievements = userAchievementDsGateway.getAllUserAchievements(userId);
            return new ResponseEntity<>(achievements, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
