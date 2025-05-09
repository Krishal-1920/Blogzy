package com.example.Blogzy.controller;

import com.example.Blogzy.service.CommentsService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/feedComments")
public class CommentsController {

    private final CommentsService commentsService;

    public ResponseEntity<> postAComment(@RequestParam String usersId,
                                         @RequestParam String feedId,
                                         @RequestBody String comment){

    }
}
