package com.example.Blogzy.controller;

import com.example.Blogzy.model.ReplyRequestModel;
import com.example.Blogzy.model.ReplyResponseModel;
import com.example.Blogzy.service.RepliesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/replies")
public class RepliesController {

    private final RepliesService repliesService;

    @PostMapping("/replyToComment")
    public ResponseEntity<List<ReplyResponseModel>> repliedToPost(@RequestParam String feedCommentsId,
                                                                  @RequestParam String userId,
                                                                  @RequestBody ReplyRequestModel reply){
        return ResponseEntity.ok(repliesService.repliedToPost(feedCommentsId, userId, reply));
    }

}
