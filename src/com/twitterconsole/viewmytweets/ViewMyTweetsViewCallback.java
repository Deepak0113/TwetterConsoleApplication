package com.twitterconsole.viewmytweets;

import com.twitterconsole.dto.Post;
import com.twitterconsole.dto.User;

import java.util.List;

public interface ViewMyTweetsViewCallback {
    void invalidOption(User user);
    void viewMyTweets(User user);
    void gotoHome(User user);
    void gotoStart();
    void invalidMessage(String message, User user);
    void myTweetsSuccess(List<Post> listPost, User user);
}