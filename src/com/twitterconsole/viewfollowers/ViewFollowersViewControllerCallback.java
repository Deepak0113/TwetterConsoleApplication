package com.twitterconsole.viewfollowers;

import com.twitterconsole.dto.User;

public interface ViewFollowersViewControllerCallback {

    void chooseOption(String option, User user);

    void viewFollowers(User user);
}
