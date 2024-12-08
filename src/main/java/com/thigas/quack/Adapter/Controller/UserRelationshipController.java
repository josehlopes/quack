package com.thigas.quack.Adapter.Controller;

import com.thigas.quack.UseCase.Boundary.UserRelationshipInputBoundary;
import com.thigas.quack.UseCase.Model.Request.UserRelationshipRequestModel;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users/relationship")
@AllArgsConstructor
public class UserRelationshipController {
    
    private final UserRelationshipInputBoundary userRelationshipInputBoundary;
    
    @PostMapping("/follow")
    public void follow(@RequestBody UserRelationshipRequestModel request) {
        userRelationshipInputBoundary.follow(request);
    }
    @PutMapping("/unfollow")
    public void unfollow(@RequestBody UserRelationshipRequestModel request) {
        userRelationshipInputBoundary.unfollow(request);
    }
    
    @GetMapping("/followers")
    public void getFollowers(@RequestBody Integer userId) {
        userRelationshipInputBoundary.getFollowers(userId);
    }
    
    @GetMapping("/following")
    public void getFollowing(@RequestBody Integer userId) {
        userRelationshipInputBoundary.getFollowing(userId);
    }
}
