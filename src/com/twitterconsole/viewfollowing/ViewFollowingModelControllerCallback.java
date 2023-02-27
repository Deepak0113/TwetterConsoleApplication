package com.twitterconsole.viewfollowing;

import com.twitterconsole.dto.User;

import java.util.List;

public interface ViewFollowingModelControllerCallback {
    void invalidMessage(String thereAreNoFollowers, User user);
    void viewFollowersSuccess(List<String> followers, User user);
}
