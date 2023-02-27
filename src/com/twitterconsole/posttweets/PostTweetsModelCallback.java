package com.twitterconsole.posttweets;

import com.twitterconsole.dto.User;

public interface PostTweetsModelCallback {
    void postTweet(User user, String tweet);
}