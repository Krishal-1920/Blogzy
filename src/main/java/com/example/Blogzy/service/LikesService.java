package com.example.Blogzy.service;

import com.example.Blogzy.entity.Feed;
import com.example.Blogzy.entity.Likes;
import com.example.Blogzy.entity.Users;
import com.example.Blogzy.model.LikesFeedModel;
import com.example.Blogzy.repository.FeedRepository;
import com.example.Blogzy.repository.LikesRepository;
import com.example.Blogzy.repository.UsersRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LikesService {

    private final UsersRepository usersRepository;

    private final FeedRepository feedRepository;

    private final LikesRepository likesRepository;

    @Transactional
    public LikesFeedModel likePost(String userId, String feedId) {
        Users user = usersRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Feed feed = feedRepository.findById(feedId)
                .orElseThrow(() -> new RuntimeException("Feed not found"));

        boolean alreadyLiked = likesRepository.existsByUsersUserIdAndFeedFeedId(user.getUserId(), feedId);
        if (alreadyLiked) {
            throw new RuntimeException("You already liked this post.");
        }

        Likes like = new Likes();
        like.setUsers(user);
        like.setFeed(feed);
        like.setLikes("like");

        likesRepository.save(like);

        LikesFeedModel model = new LikesFeedModel();
        model.setLikes("like");
        model.setFeedId(feedId);
        model.setUserId(userId);

        return model;
    }

//
//    public LikesResponseModel getTotalLikes(String usersId, String feedId) {
//        List<String> username = likesRepository.findUsernameByFeedId(feedId);
//        return new LikesResponseModel(username.size(), username);
//    }

}
