package com.twitterconsole.followuser;

import com.twitterconsole.dto.User;

public interface FollowUserViewCallback {
    void invalidOption(User user);
    void followUser(User user);
    void gotoHome(User user);
    void gotoStart();
    void followUserSuccess(User user, String userId);
    void invalidMessage(String message, User user);
}