package com.twitterconsole.followuser;

import com.twitterconsole.dto.User;

public interface FollowUserViewControllerCallback {
    void chooseOption(String option, User user);

    void followUser(User user, String userId);
}
