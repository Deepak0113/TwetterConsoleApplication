package com.twitterconsole.followuser;

import com.twitterconsole.dto.User;

public interface FollowUserModelCallback {
    void followUser(User user, String userId);
}