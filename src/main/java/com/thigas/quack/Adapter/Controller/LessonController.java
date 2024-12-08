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
            return lessonDsGateway.getLessonById(id)
                    .map(lesson -> new ResponseEntity<>(lesson, HttpStatus.OK))
                    .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public ResponseEntity<Iterable<LessonRequestModel>> getAll() {
            Iterable<LessonRequestModel> lessons = lessonDsGateway.getAllLessons();
            if (lessons != null) {
                return new ResponseEntity<>(lessons, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

    }
}
