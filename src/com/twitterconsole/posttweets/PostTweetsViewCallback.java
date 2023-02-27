package com.twitterconsole.posttweets;

import com.twitterconsole.dto.User;

public interface PostTweetsViewCallback {
    void invalidOption(User user);
    void gotoHome(User user);
    void postTweet(User user);
    void gotoStart();
    void postTweetSuccess(User user);
    void invalidMessage(String message, User user);
}