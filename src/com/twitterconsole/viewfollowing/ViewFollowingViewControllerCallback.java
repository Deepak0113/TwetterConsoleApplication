package com.twitterconsole.viewfollowing;

import com.twitterconsole.dto.User;

public interface ViewFollowingViewControllerCallback {
    void chooseOption(String option, User user);
    void viewFollowing(User user);
}
