package com.thigas.quack.Adapter.Controller;

import com.thigas.quack.UseCase.Boundary.UserFollowersAndFollowingInputBoundary;
import com.thigas.quack.UseCase.Model.Request.UserRelationshipRequestModel;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.thigas.quack.UseCase.Model.Request.*;

import java.util.List;


@RestController
@RequestMapping("/api/users/relationship")
@AllArgsConstructor
public class UserRelationshipController {
    
    private final UserFollowersAndFollowingInputBoundary userFollowersAndFollowingInputBoundary;
    
    @PostMapping("/follow")
    public void follow(@RequestBody UserRelationshipRequestModel request) {
        userFollowersAndFollowingInputBoundary.follow(request);
    }
    @PutMapping("/unfollow")
    public void unfollow(@RequestBody UserRelationshipRequestModel request) {
        userFollowersAndFollowingInputBoundary.unfollow(request);
    }
    
    @GetMapping("/followers/{userId}")
    public ResponseEntity<List<UserRequestModel>> getFollowers(@PathVariable Integer userId) {
        List<UserRequestModel> users = userFollowersAndFollowingInputBoundary.getFollowers(userId);
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
    
    @GetMapping("/followings/{userId}")
    public ResponseEntity<List<UserRequestModel>> getFollowing(@PathVariable Integer userId) {
        List<UserRequestModel> users = userFollowersAndFollowingInputBoundary.getFollowing(userId);
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
}
