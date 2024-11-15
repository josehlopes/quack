package com.thigas.quack.Adapter.Controller;

import com.thigas.quack.UseCase.Boundary.UserInputBoundary;
import com.thigas.quack.UseCase.Gateway.UserDsGateway;
import com.thigas.quack.UseCase.Model.Request.UserDtoRequestModel;
import com.thigas.quack.UseCase.Model.Request.UserRegisterDtoRequestModel;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserInputBoundary userInput;
    private final UserDsGateway userDsGateway;

    @GetMapping("/{id}")
    public ResponseEntity<UserDtoRequestModel> getById(@PathVariable Integer id) {
        return userDsGateway.getById(id).map(userDTO -> new ResponseEntity<>(userDTO, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public ResponseEntity<Iterable<UserDtoRequestModel>> getAll() {
        Iterable<UserDtoRequestModel> users = userDsGateway.getAll();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Void> create(@RequestBody UserRegisterDtoRequestModel userRequest) {
        userInput.create(userRequest);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    //TODO: TESTAR MÉTODO UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Integer id, @RequestBody UserDtoRequestModel userDTO) {
        if (id.equals(userDTO.id())) {
            userInput.update(userDTO);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        userInput.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
//
//    @PostMapping("/start-roadmap")
//    public ResponseEntity<Void> startRoadmap(@RequestBody UserRoadmapDtoRequestModel userRoadmapDTO) {
//        try {
//            if (userRoadmapService.startRoadmap(userRoadmapDTO.userId(), userRoadmapDTO.roadmapId())) {
//                return new ResponseEntity<>(HttpStatus.OK);
//            } else {
//                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//            }
//        } catch (Exception e) {
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//
//
//    @PutMapping("/end-roadmap/{id}")
//    public ResponseEntity<Void> endRoadmap(@PathVariable Integer id) {
//        try {
//            if (id == 0) {
//                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//            }
//            if (userRoadmapService.endRoadmap(id)) {
//                return new ResponseEntity<>(HttpStatus.OK);
//            } else {
//                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//            }
//        } catch (Exception e) {
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
}

