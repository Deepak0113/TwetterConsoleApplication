package com.twitterconsole.viewmytweets;

import com.twitterconsole.dto.User;

public interface ViewMyTweetsViewControllerCallback {
    void chooseOption(String option, User user);
    void viewMyTweets(User user);
}
