//package com.thigas.quack.Adapter.Controller;
//
//import com.thigas.quack.UseCase.Model.Request.Address.AchievementDtoRequestModel;
//import com.thigas.quack.UseCase.Service.AchievementService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/achievements")
//@RequiredArgsConstructor
//public class AchievementController {
//
//    private final AchievementService achievementService;
//
//    @PostMapping
//    public ResponseEntity<Void> create(@RequestBody AchievementDtoRequestModel achievementDtoRequest) {
//        achievementService.create(achievementDtoRequest);
//        return new ResponseEntity<>(HttpStatus.CREATED);
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<AchievementDtoRequestModel> getById(@PathVariable Integer id) {
//        return achievementService.getById(id).map(dto -> new ResponseEntity<>(dto, HttpStatus.OK))
//                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
//    }
//
//    @GetMapping
//    public ResponseEntity<Iterable<AchievementDtoRequestModel>> getAll() {
//        Iterable<AchievementDtoRequestModel> achievements = achievementService.getAll();
//        return new ResponseEntity<>(achievements, HttpStatus.OK);
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<Void> update(@PathVariable Integer id, @RequestBody AchievementDtoRequestModel achievementDtoRequest) {
//        if (id.equals(achievementDtoRequest.id())) {
//            achievementService.update(achievementDtoRequest);
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        } else {
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> delete(@PathVariable Integer id) {
//        achievementService.delete(id);
//        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//    }
//}
