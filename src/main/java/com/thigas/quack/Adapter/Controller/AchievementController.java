package com.thigas.quack.Adapter.Controller;

import com.thigas.quack.UseCase.Gateway.AchievementDsGateway;
import com.thigas.quack.UseCase.Model.Request.AchievementRequestModel;
import com.thigas.quack.UseCase.Model.Request.UserRequestModel;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/achievements")
@AllArgsConstructor
public class AchievementController {

    AchievementDsGateway achievementDsGateway;

    @GetMapping("/{id}")
    public ResponseEntity<AchievementRequestModel> getById(@PathVariable Integer id) {
        try {
            return achievementDsGateway.getById(id)
                    .map(userDTO -> new ResponseEntity<>(userDTO, HttpStatus.OK))
                    .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping
    public ResponseEntity<Iterable<AchievementRequestModel>> getAll() {
        try {
            Iterable<AchievementRequestModel> achievements = achievementDsGateway.getAll();
            return new ResponseEntity<>(achievements, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
