package com.twitterconsole.deletetweet;

import com.twitterconsole.dto.User;

public interface DeleteTweetViewControllerCallback {
    void chooseOption(String option, User user);
    void deleteTweet(User user, String tweetId);
}
