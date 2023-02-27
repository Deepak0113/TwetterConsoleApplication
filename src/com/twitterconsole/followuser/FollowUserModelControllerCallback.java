package com.twitterconsole.followuser;

import com.twitterconsole.dto.User;

public interface FollowUserModelControllerCallback {

    void followUserSuccess(User user, String userId);

    void invalidMessage(String s, User user);
}
