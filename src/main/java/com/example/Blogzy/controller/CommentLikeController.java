package com.example.Blogzy.controller;

import com.example.Blogzy.model.CommentLikeResponseModel;
import com.example.Blogzy.service.CommentLikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/likeComment")
public class CommentLikeController {

    private final CommentLikeService commentLikeService;

    @PostMapping("/likeAMessage")
    public ResponseEntity<CommentLikeResponseModel> likeItem(@RequestParam String userId,
                                                             @RequestParam(required = false) String feedCommentId,
                                                             @RequestParam(required = false) String replyId){
        return ResponseEntity.ok(commentLikeService.handleLike(userId, feedCommentId, replyId));
    }

}
