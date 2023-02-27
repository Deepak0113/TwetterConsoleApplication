package com.twitterconsole.deletetweet;

import com.twitterconsole.dto.User;

public interface DeleteTweetModelControllerCallback {
    void deleteTweetSuccessfully(User user);
    void invalidMessage(String s, User user);
}
