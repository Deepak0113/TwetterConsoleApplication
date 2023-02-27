package com.twitterconsole.viewfollowing;

import com.twitterconsole.dto.User;

import java.util.List;

public interface ViewFollowingViewCallback {
    void invalidOption(User user);
    void gotoHome(User user);
    void gotoStart();
    void viewFollowing(User user);

    void invalidMessage(String message, User user);

    void viewFollowingSuccess(List<String> followers, User user);
}