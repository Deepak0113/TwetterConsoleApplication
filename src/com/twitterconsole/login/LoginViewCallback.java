package com.twitterconsole.login;

import com.twitterconsole.dto.User;

public interface LoginViewCallback {
    void invalidOption();
    void gotoStart();

    /*------ LOGIN ------*/
    void login();
    void invalidMessage(String message);
    void loginSuccess(User user);
}