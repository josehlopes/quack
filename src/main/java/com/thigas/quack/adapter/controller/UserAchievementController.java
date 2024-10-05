//package com.thigas.quack.adapter.controller;
//
//import com.thigas.quack.adapter.dto.UserAchievementDTO;
//import com.thigas.quack.application.service.UserAchievementService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//
//@RestController
//@RequestMapping("/user-achievements")
//public class UserAchievementController {
//
//    @Autowired
//    private UserAchievementService userAchievementService;
//
//    @PostMapping
//    public ResponseEntity<UserAchievementDTO> create(@RequestBody UserAchievementDTO userAchievementDTO) {
//        UserAchievementDTO createdUserAchievementDTO = userAchievementService.create(userAchievementDTO);
//        return new ResponseEntity<>(createdUserAchievementDTO, HttpStatus.CREATED);
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<UserAchievementDTO> getById(@PathVariable Integer id) {
//        return userAchievementService.getById(id).map(userAchievementDTO -> new ResponseEntity<>(userAchievementDTO, HttpStatus.OK))
//                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
//    }
//
//    @GetMapping
//    public ResponseEntity<Iterable<UserAchievementDTO>> getAll() {
//        Iterable<UserAchievementDTO> userRoadmaps = userAchievementService.getAll();
//        return new ResponseEntity<>(userRoadmaps, HttpStatus.OK);
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<Void> update(@PathVariable Integer id, @RequestBody UserAchievementDTO userAchievementDTO) {
//        if (id.equals(userAchievementDTO.getId())) {
//            userAchievementService.update(userAchievementDTO);
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        } else {
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> delete(@PathVariable Integer id) {
//        userAchievementService.delete(id);
//        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//    }
//}
