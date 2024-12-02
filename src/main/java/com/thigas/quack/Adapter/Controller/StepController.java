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

@RestController
@RequestMapping("/api/steps")
@AllArgsConstructor
public class StepController {
    private final StepDsGateway stepDsGateway;

    @GetMapping("/{id}")
    public ResponseEntity<StepRequestModel> getById(@PathVariable Integer id) {
        try {
            return stepDsGateway.getById(id)
                    .map(step -> new ResponseEntity<>(step, HttpStatus.OK))
                    .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping
    public ResponseEntity<Iterable<StepRequestModel>> getAll() {
        try {
            Iterable<StepRequestModel> steps = stepDsGateway.getAll();
            if (steps != null) {
                return new ResponseEntity<>(steps, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
