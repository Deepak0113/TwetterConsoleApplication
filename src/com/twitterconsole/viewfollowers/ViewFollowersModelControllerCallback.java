package com.twitterconsole.viewfollowers;

import com.twitterconsole.dto.User;

import java.util.List;

public interface ViewFollowersModelControllerCallback {
    void invalidMessage(String s, User user);
    void viewFollowersSuccess(List<String> followers, User user);
}
