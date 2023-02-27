package com.twitterconsole.deletetweet;

import com.twitterconsole.dto.User;

public interface DeleteTweetModelCallback {
    void deleteTweet(User user, String tweetId);
}