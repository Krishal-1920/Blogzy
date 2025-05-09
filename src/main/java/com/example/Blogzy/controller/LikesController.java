package com.example.Blogzy.controller;

import com.example.Blogzy.model.LikedFeedModel;
import com.example.Blogzy.model.LikesOnFeedModel;
import com.example.Blogzy.model.LikesResponseModel;
import com.example.Blogzy.service.LikesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/feedLikes")
public class LikesController {

    private final LikesService likesService;

    @PostMapping("/likeAPost")
    public ResponseEntity<LikesOnFeedModel> likes(@RequestParam String usersId,
                                                  @RequestParam String feedId){
        return ResponseEntity.ok(likesService.likePost(usersId, feedId));
    }


    @GetMapping("/totalLikes")
    public ResponseEntity<LikesResponseModel> totalLikes(@RequestParam String feedId) {
        return ResponseEntity.ok(likesService.getTotalLikes(feedId));
    }

    @GetMapping("/getLikedFeeds")
    public ResponseEntity<List<LikedFeedModel>> getLikedFeeds(@RequestParam String usersId) {
        return ResponseEntity.ok(likesService.getLikedFeeds(usersId));
    }
}
