//package com.thigas.quack.Adapter.Controller;
//
//import com.thigas.quack.UseCase.Model.Request.RoadmapDtoRequestModel;
//import com.thigas.quack.UseCase.Service.RoadmapService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/roadmaps")
//@RequiredArgsConstructor
//public class RoadmapController {
//
//    private final RoadmapService roadmapService;
//
//    @PostMapping
//    public ResponseEntity<Void> create(@RequestBody RoadmapDtoRequestModel roadmapDTO) {
//        roadmapService.create(roadmapDTO);
//        return new ResponseEntity<>(HttpStatus.CREATED);
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<RoadmapDtoRequestModel> getById(@PathVariable Integer id) {
//        return roadmapService.getById(id).map(roadmapDTO -> new ResponseEntity<>(roadmapDTO, HttpStatus.OK))
//                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
//    }
//
//    @GetMapping
//    public ResponseEntity<Iterable<RoadmapDtoRequestModel>> getAll() {
//        Iterable<RoadmapDtoRequestModel> roadmaps = roadmapService.getAll();
//        return new ResponseEntity<>(roadmaps, HttpStatus.OK);
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<Void> update(@PathVariable Integer id, @RequestBody RoadmapDtoRequestModel roadmapDTO) {
//        if (id.equals(roadmapDTO.id())) {
//            roadmapService.update(roadmapDTO);
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        } else {
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> delete(@PathVariable Integer id) {
//        roadmapService.delete(id);
//        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//    }
//}