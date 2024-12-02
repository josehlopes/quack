package com.thigas.quack.Adapter.Controller;

import com.thigas.quack.UseCase.Gateway.RoadmapDsGateway;
import com.thigas.quack.UseCase.Model.Request.RoadmapRequestModel;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/roadmaps")
@AllArgsConstructor
public class RoadmapController {

    private final RoadmapDsGateway roadmapDsGateway;

    @GetMapping("/{id}")
    public ResponseEntity<RoadmapRequestModel> getById(@PathVariable Integer id) {
        try {
            return roadmapDsGateway.getById(id)
                    .map(roadmap -> new ResponseEntity<>(roadmap, HttpStatus.OK))
                    .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping
    public ResponseEntity<Iterable<RoadmapRequestModel>> getAll() {
        try {
            Iterable<RoadmapRequestModel> roadmaps = roadmapDsGateway.getAll();
            if (roadmaps != null) {
                return new ResponseEntity<>(roadmaps, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/category/{category}")
    public ResponseEntity<Iterable<RoadmapRequestModel>> getByCategory(@PathVariable String category) {
        try {
            Iterable<RoadmapRequestModel> roadmaps = roadmapDsGateway.getByCategory(category);
            if (roadmaps != null && roadmaps.iterator().hasNext()) {
                return new ResponseEntity<>(roadmaps, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

