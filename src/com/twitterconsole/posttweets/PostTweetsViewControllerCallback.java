package com.twitterconsole.posttweets;

import com.twitterconsole.dto.User;

public interface PostTweetsViewControllerCallback {
    void chooseOption(String option, User user);
    void postTweet(User user, String tweet);
}
