package com.thigas.quack.Adapter.Controller;

import com.thigas.quack.UseCase.Boundary.UserFollowersAndFollowingInputBoundary;
import com.thigas.quack.UseCase.Model.Request.UserRelationshipRequestModel;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

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
    
    @GetMapping("/followers")
    public void getFollowers(@RequestBody Integer userId) {
        userFollowersAndFollowingInputBoundary.getFollowers(userId);
    }
    
    @GetMapping("/following")
    public void getFollowing(@RequestBody Integer userId) {
        userFollowersAndFollowingInputBoundary.getFollowing(userId);
    }
}
