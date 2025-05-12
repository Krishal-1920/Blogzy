package com.example.Blogzy.controller;

import com.example.Blogzy.model.CommentsFeedModel;
import com.example.Blogzy.model.CommentsRequestModel;
import com.example.Blogzy.service.CommentsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/feedComments")
public class CommentsController {

    private final CommentsService commentsService;


    @PostMapping("/commentOnPost")
    public ResponseEntity<CommentsFeedModel> postAComment(@RequestParam String usersId,
                                                          @RequestParam String feedId,
                                                          @RequestBody CommentsRequestModel comment){
        return commentsService.postAComment(usersId, feedId, comment);
    }


    @GetMapping("/getComments")
    public ResponseEntity<List<CommentsFeedModel>> getComments(@RequestParam String feedId){
        return commentsService.getComments(feedId);
    }
}
