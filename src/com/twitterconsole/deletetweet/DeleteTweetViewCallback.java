package com.twitterconsole.deletetweet;

import com.twitterconsole.dto.User;

public interface DeleteTweetViewCallback {
    void invalidOption(User user);
    void gotoHome(User user);
    void gotoStart();
    void deleteTweet(User user);
    void invalidMessage(String message, User user);
    void deleteTweetSuccessfully(User user);
}