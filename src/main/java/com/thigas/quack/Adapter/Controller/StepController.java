package com.thigas.quack.Adapter.Controller;

import com.thigas.quack.UseCase.Gateway.StepDsGateway;
import com.thigas.quack.UseCase.Model.Request.StepRequestModel;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/steps")
@AllArgsConstructor
public class StepController {
    private final StepDsGateway stepDsGateway;

    @GetMapping("/{id}")
    public ResponseEntity<StepRequestModel> getById(@PathVariable Integer id) {
            return stepDsGateway.getStepById(id)
                    .map(step -> new ResponseEntity<>(step, HttpStatus.OK))
                    .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public ResponseEntity<Iterable<StepRequestModel>> getAll() {
            Iterable<StepRequestModel> steps = stepDsGateway.getAllSteps();
            if (steps != null) {
                return new ResponseEntity<>(steps, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
    }

    @GetMapping("/roadmaps/{roadmapId}/steps")
    public ResponseEntity<List<StepRequestModel>> getStepsByRoadmapId(@PathVariable Integer roadmapId) {
        List<StepRequestModel> steps = stepDsGateway.getStepsByRoadmapId(roadmapId);
        if (steps.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(steps, HttpStatus.OK);
        }
    }

}
