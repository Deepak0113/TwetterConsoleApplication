package com.twitterconsole.posttweets;

import com.twitterconsole.dto.User;

public interface PostTweetsModelControllerCallback {
    void postTweetSuccess(User user);
    void invalidMessage(String message, User user);
}
