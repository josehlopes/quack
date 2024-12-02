package com.thigas.quack.Adapter.Controller;
import com.thigas.quack.UseCase.Gateway.LessonDsGateway;
import com.thigas.quack.UseCase.Model.Request.LessonRequestModel;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/lessons")
@AllArgsConstructor
public class LessonController {
    private final LessonDsGateway lessonDsGateway;

    @GetMapping("/{id}")
    public ResponseEntity<LessonRequestModel> getById(@PathVariable Integer id) {
        try {
            return lessonDsGateway.getById(id)
                    .map(lesson -> new ResponseEntity<>(lesson, HttpStatus.OK))
                    .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping
    public ResponseEntity<Iterable<LessonRequestModel>> getAll() {
        try {
            Iterable<LessonRequestModel> lessons = lessonDsGateway.getAll();
            if (lessons != null) {
                return new ResponseEntity<>(lessons, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
