package com.example.Blogzy.service;

import com.example.Blogzy.entity.Comments;
import com.example.Blogzy.entity.Feed;
import com.example.Blogzy.entity.Users;
import com.example.Blogzy.exceptions.DataNotFoundException;
import com.example.Blogzy.model.CommentsFeedModel;
import com.example.Blogzy.model.CommentsRequestModel;
import com.example.Blogzy.repository.CommentsRepository;
import com.example.Blogzy.repository.FeedRepository;
import com.example.Blogzy.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class CommentsService {

    private final UsersRepository usersRepository;

    private final CommentsRepository commentsRepository;

    private final FeedRepository feedRepository;

    public ResponseEntity<CommentsFeedModel> postAComment(String userId, String feedId,
                                                          CommentsRequestModel request) {
        // Fetch user and feed from the database.
        Users user = usersRepository.findById(userId)
                .orElseThrow(() -> new DataNotFoundException("User not found"));
        Feed feed = feedRepository.findById(feedId)
                .orElseThrow(() -> new DataNotFoundException("Feed not found"));

        // Optional: Save the comment in your database.
        Comments commentEntity = new Comments();
        commentEntity.setComments(request.getComment());
        commentEntity.setUsers(user);
        commentEntity.setFeed(feed);
        commentsRepository.save(commentEntity);

        // Build the response model.
        CommentsFeedModel response = new CommentsFeedModel();
        response.setUsersname(user.getUsername());
        response.setContent(feed.getContent());
        response.setComments(request.getComment());

        return ResponseEntity.ok(response);
    }



    public ResponseEntity<List<CommentsFeedModel>> getComments(String feedId) {
        Feed feedById = feedRepository.findById(feedId)
                .orElseThrow(() -> new RuntimeException("Feed not found"));

        List<Comments> comments = commentsRepository.findByFeed(feedById);
        List<CommentsFeedModel> response = comments.stream()
               .map(comment -> {
                   CommentsFeedModel model = new CommentsFeedModel();
                   model.setUsersname(comment.getUsers().getUsername());
                   model.setContent(comment.getFeed().getContent());
                   model.setComments(comment.getComments());
                   return model;
               })
               .toList();
        return ResponseEntity.ok(response);
    }


}
