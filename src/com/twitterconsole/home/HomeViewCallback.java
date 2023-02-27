package com.twitterconsole.home;

import com.twitterconsole.dto.User;

public interface HomeViewCallback {
    void invalidOption(User user);
    void gotoViewTweets(User user);
    void gotoViewMyTweets(User user);
    void gotoPostTweet(User user);
    void gotoDeleteTweet(User user);
    void gotoFollowUser(User user);
    void gotoViewFollowers(User user);
    void gotoViewFollowing(User user);
}