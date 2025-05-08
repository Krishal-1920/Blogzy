package com.example.Blogzy.controller;

import com.example.Blogzy.model.FeedModel;
import com.example.Blogzy.model.ParentFeedModel;
import com.example.Blogzy.service.FeedService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/feed")
public class FeedController {

    private final FeedService feedService;

    @PostMapping("/createContent/{usersId}")
    public ResponseEntity<ParentFeedModel> createContent(@PathVariable String usersId,
                                                         @RequestBody FeedModel feedModel){
        return ResponseEntity.ok(feedService.createContent(usersId, feedModel));
    }


    @GetMapping("/getAll/{usersId}")
    public ResponseEntity<List<ParentFeedModel>> getAll(@PathVariable String usersId){
        return ResponseEntity.ok(feedService.allFeed());
    }
}
