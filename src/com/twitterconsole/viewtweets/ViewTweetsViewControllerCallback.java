package com.twitterconsole.viewtweets;

import com.twitterconsole.dto.User;

public interface ViewTweetsViewControllerCallback {
    void chooseOption(String option, User user);

    void viewTweets(User user);
}
