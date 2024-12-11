package com.thigas.quack.Adapter.Controller;

import com.thigas.quack.UseCase.Gateway.AchievementDsGateway;
import com.thigas.quack.UseCase.Model.Request.AchievementRequestModel;
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
            return achievementDsGateway.getAchievementById(id)
                    .map(userDTO -> new ResponseEntity<>(userDTO, HttpStatus.OK))
                    .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public ResponseEntity<Iterable<AchievementRequestModel>> getAll() {
            Iterable<AchievementRequestModel> achievements = achievementDsGateway.getAllAchievements();
            return new ResponseEntity<>(achievements, HttpStatus.OK);
    }
}
