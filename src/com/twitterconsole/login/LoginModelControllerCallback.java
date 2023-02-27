package com.twitterconsole.login;

import com.twitterconsole.dto.User;

public interface LoginModelControllerCallback {
    void loginSuccess(User user);
    void invalidMessage(String message);
}
