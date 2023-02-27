package com.twitterconsole.viewtweets;

import com.twitterconsole.dto.Post;
import com.twitterconsole.dto.User;

import java.util.List;

public interface ViewTweetsViewCallback {
    void invalidOption(User user);
    void gotoHome(User user);
    void gotoStart();
    void viewTweets(User user);
    void invalidMessage(String message, User user);
    void tweetsSuccess(List<Post> listPost, User user);
}