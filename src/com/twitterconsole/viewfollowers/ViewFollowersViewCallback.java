package com.twitterconsole.viewfollowers;

import com.twitterconsole.dto.User;

import java.util.List;

public interface ViewFollowersViewCallback {
    void invalidOption(User user);
    void gotoHome(User user);
    void gotoStart();
    void viewFollowers(User user);
    void invalidMessage(String message, User user);
    void viewFollowersSuccess(List<String> followers, User user);
}